package com.bin.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bin.springboot.core.ResBody;

@ControllerAdvice
public class ExceptionHandle {

	private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

	/**
	 * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResBody exceptionGet(Exception e) {
		log.error("系统异常", e);
		return ResBody.buildErrorResBody("系统异常！", null);
	}
}