package br.com.wpattern.ai.linear.regression;

import java.util.Arrays;
import java.util.Set;

import org.apache.log4j.Logger;

import br.com.wpattern.ai.linear.regression.beans.DatasetMatrixBean;
import br.com.wpattern.ai.linear.regression.constants.ErrorMessages;
import br.com.wpattern.ai.linear.regression.constants.FatalErrorCode;
import br.com.wpattern.ai.linear.regression.enums.DatasetFields;
import br.com.wpattern.ai.linear.regression.exceptions.ProcessorException;
import br.com.wpattern.ai.linear.regression.interfaces.IDatasetProcessor;
import br.com.wpattern.ai.linear.regression.interfaces.IDescentGradient;
import br.com.wpattern.ai.linear.regression.processors.DatasetProcessor;

public class DescentGradient implements IDescentGradient {

	private static final Logger LOGGER = Logger.getLogger(DescentGradient.class);

	private static final String FILEPATH = System.getProperty("user.dir") + "\\files\\dataset.txt";

	private DatasetMatrixBean realMatrix;

	public DescentGradient(Set<DatasetFields> availableFields) {
		IDatasetProcessor datasetProcessor = new DatasetProcessor(FILEPATH);

		try {
			this.realMatrix = datasetProcessor.getRealMatrix(availableFields);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(String.format("Real matrix loaded [%s].", this.realMatrix));
			}
		} catch (ProcessorException e) {
			LOGGER.fatal(String.format(ErrorMessages.PROGRAM_CAN_NOT_LOAD_DATASET, e.getMessage()));
			System.exit(FatalErrorCode.PROGRAM_CAN_NOT_LOAD_DATASET);
		}
	}

	@Override
	public double[] executeLinearRegression() {
		int numberCoefficients = this.realMatrix.getMatrixFields().length - 1;
		double[] coefficients = new double[numberCoefficients];
		double[] newCoefficients = new double[numberCoefficients];
		double[] learningRate = new double[numberCoefficients];
		int maxIterations = 100;

		Arrays.fill(learningRate, 1.0D);
		Arrays.fill(coefficients, 1.0D);

		for (int i = 0; i < maxIterations; i++) {
			for (int j = 0; j <= numberCoefficients; j++) {
				newCoefficients[j] = coefficients[j] - learningRate[j] * (this.calculateJ(coefficients, j) / this.realMatrix.getNumberRecords());
			}
		}

		return coefficients;
	}

	private double calculateJ(double[] coefficients, int coefficientIndex) {
		double sum = 0.0D;

		for (int i = 0; i < this.realMatrix.getNumberRecords(); i++) {
			sum += (this.calculateHypotheses(coefficients, this.realMatrix.getMatrix()[i]) - this.realMatrix.getMatrix()[i][0]) * this.realMatrix.getMatrix()[i][coefficientIndex + 1];
		}

		return sum;
	}

	private double calculateHypotheses(double[] coefficients, double[] record) {


		return 0;
	}

	@Override
	public DatasetMatrixBean getRealMatrix() {
		return this.realMatrix;
	}

}
