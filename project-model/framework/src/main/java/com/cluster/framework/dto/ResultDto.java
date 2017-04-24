package com.cluster.framework.dto;

import java.io.Serializable;

/**
 * 封装返回数据
 * @className ResultDto.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 下午2:13:30
 * @version   1.0
 */
public class ResultDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String OK_CODE = "200";
	public static final String ERROR_CODE = "500";
	public static final String EXCEPTION_CODE = "451";
	public static final String VALIDATE_CODE = "407";
	
	/**
	 * 错误代码
	 * */
	private String code;
	
	/**
	 * 错误信息
	 * */
	private String message;
	
	/**
	 * 返回数据
	 * */
	private T data;
	
	public ResultDto(){}
	
	public ResultDto(String code,String message){
		this.code = code;
		this.message = message;
	}
	
	public ResultDto(String code,String message,T data){
		this.code = code;
		this.message = message;
		this.data = data;
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
