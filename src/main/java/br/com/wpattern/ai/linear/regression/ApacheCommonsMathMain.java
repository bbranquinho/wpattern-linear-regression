package br.com.wpattern.ai.linear.regression;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

/**
 * Main class.
 * 
 * @author Branquinho
 */
public class ApacheCommonsMathMain {

	public static void main(String[] args) {
		OLSMultipleLinearRegression olsMultipleLinearRegression = new OLSMultipleLinearRegression();

		double[] data = new double[]{
				75000, 100,
				86000, 200,
				97700, 150,
				60000, 55,
				81400, 140,
				98400, 160,
				112700, 180,
				63800, 130,
				64700, 80,
				30000, 45
		};

		olsMultipleLinearRegression.newSampleData(data, 10, 1);

		double[] result = olsMultipleLinearRegression.estimateRegressionParameters();

		for (double r : result) {
			System.out.println(r);
		}
	}

}
