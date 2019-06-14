package com.muze.core.app.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * 封装各种格式的编码解码工具类.
 * 
 * 1.Commons-Codec的 hex/base64 编码
 * 2.自制的base62 编码
 * 3.Commons-Lang的xml/html escape
 * 4.JDK提供的URLEncoder
 * 
 * @author calvin
 */
public class Encodes {

	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	private static int offset = 2;
	private static ArrayList<Character> list;
	static {
		list = new ArrayList<Character>();
		for(char c : BASE62){
			list.add(c);
		}
	}
	/**
	 * Hex编码.
	 */
	public static String encodeHex(byte[] input) {
		return Hex.encodeHexString(input);
	}
 
	/**
	 * Hex解码.
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw Exceptions.unchecked(e);
		}
	}

	/**
	 * Base64编码.
	 */
	public static String encodeBase64(byte[] input) {
		return Base64.encodeBase64String(input);
	}

	/**
	 * Base64编码, URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548).
	 */
	public static String encodeUrlSafeBase64(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("你好".getBytes("UTF-8").length);
		
		String a = "123456";
		String encode = Encodes.encode(a);
		System.out.println(encode);
		String decode = Encodes.decode(encode);
		System.out.println(decode);
	}
	
	/**
	 * Base64解码.
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input);
	}

	/**
	 * Base62编码。
	 */
	public static String encodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
		}
		return new String(chars);
	}

	/**
	 * Html 转码.
	 */
	public static String escapeHtml(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}

	/**
	 * Html 解码.
	 */
	public static String unescapeHtml(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml4(htmlEscaped);
	}

	/**
	 * Xml 转码.
	 */
	@SuppressWarnings("deprecation")
	public static String escapeXml(String xml) {
		return StringEscapeUtils.escapeXml(xml);
	}

	/**
	 * Xml 解码.
	 */
	public static String unescapeXml(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}

	/**
	 * URL 编码, Encode默认为UTF-8.
	 */
	public static String urlEncode(String part) {
		try {
			return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw Exceptions.unchecked(e);
		}
	}

	/**
	 * URL 解码, Encode默认为UTF-8.
	 */
	public static String urlDecode(String part) {

		try {
			return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw Exceptions.unchecked(e);
		}
	}
	
	// encode rongxin.li
	public static String encode(String str) throws Exception {
		str = Encodes.encodeUrlSafeBase64(str.getBytes("Utf-8"));
		StringBuffer buff1 = new StringBuffer();
		int length = list.size();
		for (char c : str.toCharArray()) {
			int i = list.indexOf(c);
			if (i < 0) {
				buff1.append(c);
				continue;
			}
			i = i + offset < length ? i + offset : i + offset - length;
			buff1.append(list.get(i));
		}
		return buff1.toString();
	}

	// decode rongxin.li
	public static String decode(String str) {
		StringBuffer buff2 = new StringBuffer();
		int length = list.size();
		for (char c : str.toString().toCharArray()) {
			int i = list.indexOf(c);
			if (i < 0) {
				buff2.append(c);
				continue;
			}
			i = i - offset >= 0 ? i - offset : i - offset + length;
			buff2.append(list.get(i));
		}
		String deStr = buff2.toString();
		byte[] base64de = Encodes.decodeBase64(deStr);
		try {
			return new String(base64de,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
