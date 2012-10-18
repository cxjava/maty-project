package com.maty.j2ee.common.datatables;

/**
 * 列信息
 * 
 * @author cx
 * @date 2011-7-26 下午3:07:40
 */
public class ColumnInfo {

	/**
	 * 列名
	 */
	private String columnName;
	/**
	 * 是否正则
	 */
	private Boolean regex;
	/**
	 * 查询的字符
	 */
	private String search;
	/**
	 * 查找
	 */
	private Boolean searchable;
	/**
	 * 排序
	 */
	private Boolean sortable;

	/**
	 * @return 列名
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName
	 *            列名
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return 查询的字符
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search
	 *            查询的字符
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @return 是否正则
	 */
	public Boolean getRegex() {
		return regex;
	}

	/**
	 * @param regex
	 *            是否正则
	 */
	public void setRegex(Boolean regex) {
		this.regex = regex;
	}

	/**
	 * @return 查找
	 */
	public Boolean getSearchable() {
		return searchable;
	}

	/**
	 * @param searchable
	 *            查找
	 */
	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	/**
	 * @return 排序
	 */
	public Boolean getSortable() {
		return sortable;
	}

	/**
	 * @param sortable
	 *            排序
	 */
	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

}
