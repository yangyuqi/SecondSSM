package com.second.api.config;

public enum ResultCode {
	SUCCESS("200", "成功"),
	FAILED("300","失败"),
	FAILEDPARAME("400","参数错误");
	
	private String code;
	private String msg;
	
	private ResultCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
