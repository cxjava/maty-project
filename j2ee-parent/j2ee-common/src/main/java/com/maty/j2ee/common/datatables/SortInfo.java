package com.maty.j2ee.common.datatables;

/**
 * 排序值
 * 
 * @author cx
 * @date 2011-7-26 下午3:07:40
 */
public class SortInfo {

	/**
	 * 排序列名
	 */
	private String columnName;
	/**
	 * desc or asc
	 */
	private String sortDir;
	/**
	 * @return
	 * 排序列名
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName
	 * 排序列名
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return
	 * desc or asc
	 */
	public String getSortDir() {
		return sortDir;
	}
	/**
	 * @param sortDir
	 * desc or asc
	 */
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	

}
