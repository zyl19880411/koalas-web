package com.muze.core.app.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.*;

/**
 * author:jfhan desc:字符串压缩/解压工具，提供gzip和zip两种方式，压缩后的字符串使用base64转码
 * */

public class ZipUtils {

	
	public static final String CHARSET_NAME="UTF-8";
	/**
	 * 
	 * 使用gzip进行压缩
	 * @throws UnsupportedEncodingException 
	 */
	public static String compressBASE64(String primStr) throws UnsupportedEncodingException {
		if (primStr == null || primStr.length() == 0) {
			return primStr;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;

		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			in = new ByteArrayInputStream(primStr.getBytes(CHARSET_NAME));

			byte[] b = new byte[1024];
			int count = -1;
			while (((count = in.read(b)) >= 0)) {
				gzip.write(b, 0, count);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return new String(new Base64().encode(out.toByteArray()));
	}

	public static void main(String[] args) throws IOException {

		// compressBASE64压缩
		String str = "你好啦啦啦dcasdfsadadfasd哈哈heihei";
		System.out.println("原长度：" + str.length());
		String compress=ZipUtils.compressBASE64(str);
		System.out.println("压缩后compressBASE64长度：" + compress.length());
		System.out.println("压缩后compressBASE64值：" + compress);
		str = ZipUtils.uncompressBASE64(compress);
		System.out.println("解压缩后compressBASE64：" + str);

		System.out.println("********************************************");
		
		// compress压缩
		System.out.println("原长度：" + str.length());
		compress=ZipUtils.compress(str);
		System.out.println("压缩后compress长度：" + compress.length());
		System.out.println("压缩后compress值：" + compress);
		str = ZipUtils.uncompress(compress);
		System.out.println("解压缩后compress：" + str);
		
		System.out.println("********************************************");

		// zip压缩
		System.out.println("原长度：" + str.length());
		compress=ZipUtils.zip(str);
		System.out.println("压缩后zip长度：" + compress.length());
		System.out.println("压缩后zip值：" + compress);
		str = ZipUtils.unzip(compress);
		System.out.println("解压缩后zip：" + str);

	}

	/**
	 * 使用gzip进行解压缩
	 * 
	 * @param compressedStr
	 * @return 解压后的字符串
	 */
	public static String uncompressBASE64(String compressedStr) {
		if (compressedStr == null || compressedStr.length() == 0) {
			return "";
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		GZIPInputStream ginzip = null;
		byte[] compressed = null;
		String decompressed = null;
		try {
			compressed = new Base64().decode(compressedStr.getBytes(CHARSET_NAME));
			in = new ByteArrayInputStream(compressed);
			ginzip = new GZIPInputStream(in);

			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = ginzip.read(buffer)) >= 0) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString(CHARSET_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ginzip != null) {
				try {
					ginzip.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}

		return decompressed;
	}

	/**
	 * 使用zip进行压缩
	 * 
	 * @param str
	 *            压缩前的文本
	 * @return 返回压缩后的文本
	 */
	public static final String zip(String str) {
		if (str == null || str.length() == 0)
			return "";
		byte[] compressed;
		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;

		ZipOutputStream zout = null;
		String compressedStr = null;
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("0"));

			in = new ByteArrayInputStream(str.getBytes(CHARSET_NAME));

			byte[] b = new byte[1024];
			int count = -1;
			while (((count = in.read(b)) >= 0)) {
				zout.write(b, 0, count);
			}
			zout.closeEntry();
			compressed = out.toByteArray();
			compressedStr = new String(new Base64().encode(compressed));
		} catch (IOException e) {
			compressed = null;
		} finally {
			if (zout != null) {
				try {
					zout.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return compressedStr;
	}

	/**
	 * 使用zip进行解压缩
	 * 
	 * @param compressed
	 *            压缩后的文本
	 * @return 解压后的字符串
	 */
	public static final String unzip(String compressedStr) {
		if (compressedStr == null || compressedStr.length() == 0) {
			return "";
		}

		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		String decompressed = null;
		try {
			byte[] compressed = new Base64().decode(compressedStr
					.getBytes(CHARSET_NAME));
			out = new ByteArrayOutputStream();
			in = new ByteArrayInputStream(compressed);
			zin = new ZipInputStream(in);
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zin.read(buffer)) >= 0) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString(CHARSET_NAME);
		} catch (IOException e) {
			decompressed = null;
		} finally {
			if (zin != null) {
				try {
					zin.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return decompressed;
	}

	// 压缩
	public static String compress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);

		ByteArrayInputStream in = null;
		in = new ByteArrayInputStream(str.getBytes(CHARSET_NAME));

		byte[] b = new byte[1024];
		int count = -1;
		while (((count = in.read(b)) != -1)) {
			gzip.write(b, 0, count);
		}

		gzip.close();
		return out.toString("iso8859-1");
	}

	// 解压缩
	public static String uncompress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(
				str.getBytes("iso8859-1"));
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		// toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
		return out.toString(CHARSET_NAME);
	}
}
