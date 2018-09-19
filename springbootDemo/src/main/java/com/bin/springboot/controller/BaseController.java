package com.bin.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.bin.springboot.core.GlobalResponseCode;
import com.bin.springboot.core.ResBody;

public class BaseController {
	public Logger log = LoggerFactory.getLogger(BaseController.class);

	public ResBody getValidatedInfo(BindingResult bindingResult){
		List<ObjectError> errorList = bindingResult.getAllErrors();
		StringBuffer validatedInfo = new StringBuffer();
		for (ObjectError error : errorList) {
			validatedInfo = validatedInfo.append(error.getDefaultMessage()).append(" ");
		}
		
		return  ResBody.buildErrorResBody(GlobalResponseCode.BUSSINESS_PARAM_ERROR, validatedInfo);
	}
}
