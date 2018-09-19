package com.bin.springboot.core;

import javax.validation.constraints.NotNull;

public class PageInfo {

	//页数
	@NotNull(message = "pageNum不能为null")
	private Integer pageNum;
	
	//每页长度
	@NotNull(message = "pageSize不能为null")
	private Integer pageSize;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	

}
