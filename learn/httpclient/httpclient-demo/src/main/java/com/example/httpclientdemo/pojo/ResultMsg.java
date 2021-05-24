package com.example.httpclientdemo.pojo;


public class ResultMsg {
	
	private boolean success;
	private Object message;

	public ResultMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultMsg(boolean boo, Object msg) {
		this.success = boo;
		this.message = msg;
	}
	public boolean isSuccess() {
		return success;
	}

	public ResultMsg setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public Object getMessage() {
		return message;
	}

	public ResultMsg setMessage(Object message) {
		this.success = false;
		this.message = message;
		return this;
	}
	public static ResultMsg getSuccessOnly() {
		return new ResultMsg(true,null);
	}
	public static ResultMsg getFailureOnly() {
		return new ResultMsg(false,null);
	}
}
