package com.houyuli.cms.util;

/**
 * �Զ����쳣
 * 
 * @ClassName: CMSException
 * @Description: TODO
 * @author: King
 * @date: 2020��6��7�� ����6:01:38
 */
public class CMSException extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	private String mssage;

	public String getMssage() {
		return mssage;
	}

	public void setMssage(String mssage) {
		this.mssage = mssage;
	}

	public CMSException(String mssage) {
		super();
		this.mssage = mssage;
	}

	public CMSException() {
		super();
	}
}
