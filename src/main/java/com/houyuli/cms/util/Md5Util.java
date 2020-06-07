package com.houyuli.cms.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * ��������ܵĹ�����
 * 
 * @ClassName: Md5Util
 * @Description: TODO
 * @author: King
 * @date: 2020��6��7�� ����7:52:15
 */
public class Md5Util {
	/**
	 * ֱ�Ӷ��������ɢ�У���ô�ڿͿ��Զ�ͨ������������ɢ��ֵ�� Ȼ��ͨ����ɢ��ֵ�ֵ䣨����MD5�����ƽ���վ�����õ�ĳ�û������롣
	 * ��Salt����һ���̶��Ͻ���������
	 */
	private static final String salt = "a1b2c3";

	public static String md5Encode(String password) {

		return DigestUtils.md5Hex(password + salt);
	}

	public static void main(String[] args) {
		Md5Util.md5Encode("1");
		Md5Util.md5Encode("1");
		Md5Util.md5Encode("123456");
	}
}
