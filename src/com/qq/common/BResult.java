package com.qq.common;

public class BResult {

	private boolean success;
	private String msg;
	private Object model;
    private Integer target;
	
	public BResult() {
		this.success = true;
	}


	public BResult(boolean success) {
		this();
		this.success = success;
	}
	
	public BResult(Integer target) {
		this();
		this.target=target;
	}

	
	public BResult(String message) {
		this();
		this.msg = message;
	}

	public BResult(String message, Object model) {
		this();
		this.msg = message;
		this.model = model;
	}

	public BResult(boolean success, String message) {
		this.success = success;
		this.msg = message;
	}

	public BResult(boolean success, String message, Object model) {
		this.success = success;
		this.msg = message;
		this.model = model;
	}

	public static BResult success() {
		return new BResult();
	}

	public static BResult success(String message) {
		return new BResult(message);
	}

	public static BResult success(String message, Object model) {
		return new BResult(message, model);
	}

	public static BResult fail(String message) {
		return new BResult(false, message);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String message) {
		this.msg = message;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}


	public Integer getTarget() {
		return target;
	}


	public void setTarget(Integer target) {
		this.target = target;
	}
	
}
