package com.maty.j2ee.entity.ext;

import java.io.Serializable;

/**
 * Ext pager
 * 
 * @author Maty Chen
 * @date 2011-3-17 上午10:37:27
 */
public class ExtPager implements Serializable {
	private static final long serialVersionUID = 8298962642187346187L;
	private Integer limit;
	private Integer start;
	/** 大写的ASC or DESC */
	private String dir;
	/** 排序的字段 */
	private String sort;

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * @return the dir 大写的ASC or DESC
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * @param dir
	 *            the dir to set 大写的ASC or DESC
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * @return the sort 排序的字段
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort
	 *            the sort to set 排序的字段
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

}
