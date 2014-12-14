package br.com.wpattern.ai.linear.regression.processors;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import br.com.wpattern.ai.linear.regression.beans.DatasetBean;
import br.com.wpattern.ai.linear.regression.beans.DatasetMatrixBean;
import br.com.wpattern.ai.linear.regression.constants.ErrorMessages;
import br.com.wpattern.ai.linear.regression.enums.DatasetFields;
import br.com.wpattern.ai.linear.regression.exceptions.ProcessorException;
import br.com.wpattern.ai.linear.regression.interfaces.IDatasetProcessor;

public class DatasetProcessor implements IDatasetProcessor {

	private static final Logger LOGGER = Logger.getLogger(DatasetProcessor.class);

	private static final String RECORD_DELIMITER = " ";

	private List<DatasetBean> dataset;

	private String filepath;

	//////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	//////////////////////////////////////////////////////////////////////////////

	public DatasetProcessor() {
	}

	public DatasetProcessor(String filepath) {
		this.filepath = filepath;
	}

	//////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS
	//////////////////////////////////////////////////////////////////////////////

	@Override
	public void loadDataset(String filepath) throws ProcessorException {
		if ((this.filepath == null) || ((this.filepath != null) && !this.filepath.equals(filepath))) {
			this.dataset = null;
			this.filepath = filepath;
		}

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Dataset loaded from file [%s].", filepath));
		}
	}

	@Override
	public List<DatasetBean> getDataset() throws ProcessorException {
		if (this.filepath == null) {
			throw new ProcessorException(ErrorMessages.FILE_PATH_NOT_FILLED);
		}

		if (this.dataset == null) {
			FileInputStream inputStream = this.loadFile(this.filepath);
			this.dataset = this.processFile(inputStream);
		}

		return this.dataset;
	}

	@Override
	public List<DatasetBean> getDataset(String filepath) throws ProcessorException {
		this.loadDataset(filepath);

		return this.getDataset();
	}

	@Override
	public DatasetMatrixBean getRealMatrix(Set<DatasetFields> availableFields) throws ProcessorException {
		if (availableFields == null) {
			return null;
		}

		availableFields.remove(DatasetFields.MEDIAN_VALUE);
		availableFields.remove(DatasetFields.UNKNOWN_FIELD);

		int row = 0;
		this.dataset = this.getDataset();
		DatasetFields[] matrixFields = this.convertToArray(availableFields);
		double[][] matrix = new double[this.dataset.size()][availableFields.size() + 1];

		for (DatasetBean databean : this.dataset) {
			for (int column = 0; column < matrixFields.length; column++) {
				Double matrixValue = null;

				switch (matrixFields[column]) {
				case PER_CAPITA_CRIME:
					matrixValue = databean.getPerCapitaCrime();
					break;

				case PROPORTIONAL_RESIDENTIAL_LAND:
					matrixValue = databean.getProportionalResidentialLand();
					break;

				case PROPORTIONAL_NONRETAIL_BUSINESS:
					matrixValue = databean.getProportionalNonretailBusiness();
					break;

				case RIVER_BOUNDS:
					matrixValue = databean.getRiverBounds();
					break;

				case NITRIC_OXIDES_CONCENTRATION:
					matrixValue = databean.getNitricOxidesConcentration();
					break;

				case ROOMS_PER_DWELLING:
					matrixValue = databean.getRoomsPerDwelling();
					break;

				case PROPORTION_OWNER:
					matrixValue = databean.getProportionOwner();
					break;

				case WEIGHTED_DISTANCES:
					matrixValue = databean.getWeightedDistances();
					break;

				case INDEX_ACCESSIBILITY:
					matrixValue = databean.getIndexAccessibility();
					break;

				case PROPERTY_TAX_RATE:
					matrixValue = databean.getPropertyTaxRate();
					break;

				case PUPIL_TEACHER_RATIO:
					matrixValue = databean.getPupilTeacherRatio();
					break;

				case LOWER_STATUS:
					matrixValue = databean.getLowerStatus();
					break;

				case MEDIAN_VALUE:
					matrixValue = databean.getMedianValue();
					break;

				default:
					LOGGER.error(String.format(ErrorMessages.FIELD_NOT_MAPPED, matrixFields[column]));
					break;
				}

				matrix[row][column] = matrixValue;
			}

			row++;
		}

		return new DatasetMatrixBean(matrix, matrixFields);
	}

	//////////////////////////////////////////////////////////////////////////////
	// PRIVATE METHODS
	//////////////////////////////////////////////////////////////////////////////

	private DatasetFields[] convertToArray(Set<DatasetFields> availableFields) {
		DatasetFields[] matrixFields = new DatasetFields[availableFields.size() + 1];
		int column = 0;

		matrixFields[column++] = DatasetFields.MEDIAN_VALUE;

		for (DatasetFields field : availableFields) {
			matrixFields[column++] = field;
		}

		return matrixFields;
	}

	private FileInputStream  loadFile(String filepath) throws ProcessorException {
		try {
			FileInputStream inputStream = new FileInputStream(filepath);

			return inputStream;
		} catch (FileNotFoundException e) {
			throw new ProcessorException(String.format(ErrorMessages.FILE_NOT_FOUNDED, filepath), e);
		}
	}

	private List<DatasetBean> processFile(FileInputStream inputStream) throws ProcessorException {
		if (this.dataset != null) {
			return this.dataset;
		}

		DataInputStream dataInputStream = new DataInputStream(inputStream);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
		DatasetBean processedRecord;
		String line;

		this.dataset = new ArrayList<DatasetBean>();

		try {
			while ((line = bufferedReader.readLine()) != null) {
				processedRecord = this.processRecord(line);

				if (processedRecord != null) {
					this.dataset.add(processedRecord);
				}
			}
		} catch (IOException e) {
			throw new ProcessorException(String.format(ErrorMessages.FILE_CAN_NOT_BE_PROCESSED, e.getMessage()));
		}

		return this.dataset;
	}

	private DatasetBean processRecord(String record) {
		StringTokenizer tokenizer = new StringTokenizer(record, RECORD_DELIMITER);
		DatasetBean processedBean = new DatasetBean();
		Double value;
		DatasetFields field;
		int position = 0;

		try {
			while (tokenizer.hasMoreTokens()) {
				value = Double.parseDouble(tokenizer.nextToken());
				field = DatasetFields.parse(position++);

				switch (field) {
				case PER_CAPITA_CRIME:
					processedBean.setPerCapitaCrime(value);
					break;

				case PROPORTIONAL_RESIDENTIAL_LAND:
					processedBean.setProportionalResidentialLand(value);
					break;

				case PROPORTIONAL_NONRETAIL_BUSINESS:
					processedBean.setProportionalNonretailBusiness(value);
					break;

				case RIVER_BOUNDS:
					processedBean.setRiverBounds(value);
					break;

				case NITRIC_OXIDES_CONCENTRATION:
					processedBean.setNitricOxidesConcentration(value);
					break;

				case ROOMS_PER_DWELLING:
					processedBean.setRoomsPerDwelling(value);
					break;

				case PROPORTION_OWNER:
					processedBean.setProportionOwner(value);
					break;

				case WEIGHTED_DISTANCES:
					processedBean.setWeightedDistances(value);
					break;

				case INDEX_ACCESSIBILITY:
					processedBean.setIndexAccessibility(value);
					break;

				case PROPERTY_TAX_RATE:
					processedBean.setPropertyTaxRate(value);
					break;

				case PUPIL_TEACHER_RATIO:
					processedBean.setPupilTeacherRatio(value);
					break;

				case LOWER_STATUS:
					processedBean.setLowerStatus(value);
					break;

				case MEDIAN_VALUE:
					processedBean.setMedianValue(value);
					break;
				}
			}
		} catch (Exception e) {
			LOGGER.error(String.format(ErrorMessages.ERROR_TO_PROCESS_RECORD, e.getMessage(), record));
		}

		return processedBean;
	}

}
