package br.com.wpattern.ai.linear.regression.beans;

import br.com.wpattern.ai.linear.regression.enums.DatasetFields;

public class DatasetMatrixBean extends BaseBeans {

	private static final long serialVersionUID = 201212070228L;

	private double[][] matrix;

	private DatasetFields[] matrixFields;

	private int numberAttributes;

	private int numberRecords;

	public DatasetMatrixBean() {
	}

	public DatasetMatrixBean(double[][] matrix, DatasetFields[] matrixFields) {
		this.setMatrix(matrix);
		this.setMatrixFields(matrixFields);
	}

	public double[][] getMatrix() {
		return this.matrix;
	}

	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
		this.numberRecords = matrix.length;
	}

	public DatasetFields[] getMatrixFields() {
		return this.matrixFields;
	}

	public void setMatrixFields(DatasetFields[] matrixFields) {
		this.matrixFields = matrixFields;
		this.numberAttributes = this.matrixFields.length - 1;
	}

	public int getNumberAttributes() {
		return this.numberAttributes;
	}

	public int getNumberRecords() {
		return this.numberRecords;
	}

}
