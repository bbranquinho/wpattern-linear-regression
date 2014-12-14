package br.com.wpattern.ai.linear.regression.interfaces;

import br.com.wpattern.ai.linear.regression.beans.DatasetMatrixBean;

public interface IDescentGradient {

	public double[] executeLinearRegression();

	public DatasetMatrixBean getRealMatrix();

}
