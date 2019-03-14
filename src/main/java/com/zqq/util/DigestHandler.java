package com.zqq.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import com.appresso.ds.common.fw.id.Main;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;





public class DigestHandler {
	private  static final String ALGORITHM="MD5";
	private static final char[] HEX_DIGITS={'0','1','2','3','4','5','6',
			'7','8','9','a','b','c','d','e','f'};
	/**
	 * encode String
	 * @param algorithm
	 * @param str
	 * @return
	 */
	public String encode(String algorithm,String str){
		if (str==null) {
			return null;
		}
		try {
			MessageDigest messageDigest=MessageDigest.getInstance(algorithm);
			messageDigest.update(str.getBytes());
			return Base64.encode(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * encode by MD5
	 * @param str
	 * @return
	 */
	public String encodeByMD5(String str){
		if (str==null) {
			return null;
		}
		try {
			MessageDigest messageDigest=MessageDigest.getInstance(ALGORITHM);
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getFormattedText(byte[] bytes){
		int len=bytes.length;
		StringBuilder buf=new StringBuilder(len*2);
		for (int i = 0; i < len; i++) {
			buf.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return buf.toString();
	}
	/**
	 * 加密
	 * @param password
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encPwdStr(String password )throws UnsupportedEncodingException{
		byte[] inpwd=password.getBytes("ISO-8859-1");
		int len=inpwd.length;
		for (int i = 0; i < len; i++) {
			inpwd[i] ^=0x5a;
		}
		return Base64.encode(inpwd);
	}
	/**
	 * 解密
	 * @param password
	 * @return
	 * @throws Base64DecodingException
	 */
	public static String decPwdStr(String password) throws Base64DecodingException{
		byte[] inpwd=Base64.decode(password);
		int len=inpwd.length;
		for (int i = 0; i < len; i++) {
			inpwd[i] ^=0x5a;
		}
		String buf="";
		try {
			buf=new String(inpwd,"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return buf;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(decPwdStr("root@123"));
	}
}
