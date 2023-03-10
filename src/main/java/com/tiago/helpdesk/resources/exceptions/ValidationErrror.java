package com.tiago.helpdesk.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrror extends StandardError {
	private static final long serialVersionUID = 1L;

	List<FieldMessage> errors = new ArrayList<>();

	public ValidationErrror() {
		super();
	}

	public ValidationErrror(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	
	
}
