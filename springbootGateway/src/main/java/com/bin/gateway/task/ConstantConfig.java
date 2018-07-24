package com.bin.gateway.task;

import java.util.HashMap;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 常量定义表
 * @author pyp
 *
 */
public class ConstantConfig {
	
	 @SuppressWarnings("serial")
	 public static final  HashMap<String,String> ROUTES =new HashMap<String, String>(){
		 
	 };	
	 //控制qps  2000次/s
	public static RateLimiter LIMITER =RateLimiter.create(2000);
	
}
