package com.example.hrms.core.results;

public class SuccessResult extends Result{

	public SuccessResult(boolean success) {
		super(true);
	}
	public SuccessResult(String message) {
		super(true,message);
	}

}
