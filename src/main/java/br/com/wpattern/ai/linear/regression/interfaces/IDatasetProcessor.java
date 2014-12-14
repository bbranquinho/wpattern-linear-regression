package br.com.wpattern.ai.linear.regression.interfaces;

import java.util.List;
import java.util.Set;

import br.com.wpattern.ai.linear.regression.beans.DatasetBean;
import br.com.wpattern.ai.linear.regression.beans.DatasetMatrixBean;
import br.com.wpattern.ai.linear.regression.enums.DatasetFields;
import br.com.wpattern.ai.linear.regression.exceptions.ProcessorException;

/**
 * Process file with data of houses.
 * 
 * @author Branquinho
 * @since December 4, 2012.
 */
public interface IDatasetProcessor {

	/**
	 * Load a file with data of houses.
	 * 
	 * @param filepath
	 * 			Path of file.
	 * 
	 * @throws ProcessorException
	 * 			Fail to load a file. For example, not found the file.
	 */
	public void loadDataset(String filepath) throws ProcessorException;

	/**
	 * Get dataset already loaded.
	 * 
	 * @return
	 * 			Dataset loaded.
	 * 
	 * @throws ProcessorException
	 * 			Can't process the dataset. The file path has not been filled or not exist.
	 */
	public List<DatasetBean> getDataset() throws ProcessorException;

	/**
	 * Load and get the dataset.
	 * 
	 * @param filepath
	 * 			Path of file.
	 * 
	 * @return
	 * 			Dataset loaded.
	 * 
	 * @throws ProcessorException
	 * 			Fail to load a file. For example, not found the file.
	 */
	public List<DatasetBean> getDataset(String filepath) throws ProcessorException;

	/**
	 * Fields used to create the matrix of values.
	 * 
	 * @param fields
	 * 			Collection of fields.
	 * 
	 * @return
	 * 			Matrix with all values.
	 */
	public DatasetMatrixBean getRealMatrix(Set<DatasetFields> availableFields) throws ProcessorException;

}
