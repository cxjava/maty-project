package com.maty.j2ee.entity.ext;

/**
 * 
 * 
 * @author Maty Chen
 * @date 2011-8-2 下午3:20:49
 */
public class Table {

	protected Table() {
	}

	/**
	 * change the pojo column to database column<br>
	 * fileName -> FILE_NAME
	 * 
	 * @param field
	 * @return
	 */
	public static String toClumn(String field) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (Character.isUpperCase(c) && i > 0) {
				sb.append("_").append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toUpperCase(c));
			}
		}
		return sb.toString();
	}
}
