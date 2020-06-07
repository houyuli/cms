package com.houyuli.cms.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 给密码加密的工具类
 * 
 * @ClassName: Md5Util
 * @Description: TODO
 * @author: King
 * @date: 2020年6月7日 下午7:52:15
 */
public class Md5Util {
	/**
	 * 直接对密码进行散列，那么黑客可以对通过获得这个密码散列值， 然后通过查散列值字典（例如MD5密码破解网站），得到某用户的密码。
	 * 加Salt可以一定程度上解决这个问题
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
