package com.springboot.core;

public class ResBody {
	
	/**
	 * 请求响应状态
	 */
	private int status;
	/**
	 * 请求响应码
	 */
	private String code;
	/**
	 * 请求响应消息
	 */
	private String message;
	/**
	 * 请求响应数据对象
	 */
	private Object content;
	
	public ResBody(){}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	public static ResBody buildSuccessResBody(Object content){
		return buildResBody(GlobalResponseCode.SYS_SUCCUES_STATUS,GlobalResponseCode.SYS_SUCCUES,"请求成功",content);
	}
	
	public static ResBody buildErrorResBody(String message,Object content){
		return buildResBody(GlobalResponseCode.SYS_ERROR_STATUS,GlobalResponseCode.SYS_ERROR,message,content);
	}
	
	
	
	public static ResBody buildResBody(int status,String code,String message,Object content){
		ResBody resBody = new ResBody();
		resBody.setStatus(status);
		resBody.setCode(code);
		resBody.setMessage(message);
		resBody.setContent(content);
		return resBody;
	}
	
	
	

}
