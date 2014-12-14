package br.com.wpattern.ai.test.linear.regression;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import br.com.wpattern.ai.linear.regression.beans.DatasetBean;
import br.com.wpattern.ai.linear.regression.exceptions.ProcessorException;
import br.com.wpattern.ai.linear.regression.interfaces.IDatasetProcessor;
import br.com.wpattern.ai.linear.regression.processors.DatasetProcessor;

public class TestDataset {

	private static final Logger LOGGER = Logger.getLogger(TestDataset.class);

	private static final String FILEPATH = System.getProperty("user.dir") + "\\files\\dataset.txt";

	@Test
	public void testLoadDataset() {
		IDatasetProcessor datasetProcessor = new DatasetProcessor();

		try {
			List<DatasetBean> datasetLoaded = datasetProcessor.getDataset(FILEPATH);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(String.format("Dataset loaded [%s].", datasetLoaded));
			}
		} catch (ProcessorException e) {
			Assert.fail(e.getMessage());
		}
	}

}
