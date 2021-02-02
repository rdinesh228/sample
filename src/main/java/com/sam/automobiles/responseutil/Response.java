package com.sam.automobiles.responseutil;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Response<T> implements Serializable {

	/** System generated Serial version UID */
	private static final long serialVersionUID = -433698502344827128L;
	private static final String SUCCESS_MESSAGE = "Success";
	private Boolean success;
	private String message;
	private String errorCode;
	private String timeStamp;
	private T data;

	public Response() {
		super();
	}

	public Response(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public static <T> Response<T> success() {
		Response<T> response = new Response<T>((T) null);
		response.setSuccess(true);
		response.setMessage(SUCCESS_MESSAGE);
		response.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return response;
	}

	public static <T> Response<T> success(String message) {
		Response<T> response = new Response<T>((T) null);
		response.setSuccess(true);
		response.setMessage(message);
		response.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return response;
	}

	public static <T> Response<T> success(T t) {
		Response<T> response = new Response<T>(t);
		response.setSuccess(true);
		response.setMessage(SUCCESS_MESSAGE);
		response.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return response;
	}

	public static <T> Response<T> success(T t, String message) {
		Response<T> response = new Response<T>(t);
		response.setSuccess(true);
		response.setMessage(message);
		response.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return response;
	}

	/*
	 * public static <T> Response<T> failure(ErrorCode error) { Response<T> response
	 * = new Response<T>((T) null); response.setSuccess(false);
	 * response.setMessage(error.getMessage());
	 * response.setErrorCode(error.getCode()); response.setTimeStamp(new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); return response;
	 * }
	 * 
	 * public static <T> Response<T> failure(ErrorCode error, Object data) {
	 * 
	 * @SuppressWarnings("unchecked") Response<T> response = new Response<T>((T)
	 * data); response.setSuccess(false); response.setMessage(error.getMessage());
	 * response.setErrorCode(error.getCode()); response.setTimeStamp(new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); return response;
	 * }
	 */

	public static <T> Response<T> failure(String errorCode, String errorMessage) {
		Response<T> response = new Response<T>((T) null);
		response.setSuccess(false);
		response.setMessage(errorMessage);
		response.setErrorCode(errorCode);
		response.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return response;
	}

	public static <T> Response<T> copyProperties(T data, Response<?> originalResponse) {
		Response<T> response = new Response<T>();
		response.setData(data);
		response.setErrorCode(originalResponse.getErrorCode());
		response.setMessage(originalResponse.getMessage());
		response.setSuccess(originalResponse.getSuccess());
		response.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return response;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}