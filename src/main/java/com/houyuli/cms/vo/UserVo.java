package com.houyuli.cms.vo;

import com.houyuli.cms.domain.User;

public class UserVo extends User{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private String createdStart;// 注册开始时间
	private String createdEnd;// 注册结束时间
	public String getCreatedStart() {
		return createdStart;
	}
	public void setCreatedStart(String createdStart) {
		this.createdStart = createdStart;
	}
	public String getCreatedEnd() {
		return createdEnd;
	}
	public void setCreatedEnd(String createdEnd) {
		this.createdEnd = createdEnd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
