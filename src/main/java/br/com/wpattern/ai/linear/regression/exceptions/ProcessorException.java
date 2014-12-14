package br.com.wpattern.ai.linear.regression.exceptions;

public class ProcessorException extends Exception {

	private static final long serialVersionUID = 201204120236L;

	public ProcessorException() {
	}

	public ProcessorException(String message) {
		super(message);
	}

	public ProcessorException(Throwable throwable) {
		super(throwable);
	}

	public ProcessorException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
