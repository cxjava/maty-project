package com.maty.j2ee.entity.ext;

import java.io.Serializable;
import java.util.List;

/**
 * Ext Grid return object
 * 
 * @author Maty Chen
 * @date 2011-3-10 下午09:43:35
 */
public class ExtGridReturn implements Serializable {
	private static final long serialVersionUID = -8009510606594225281L;
	/** total count */
	private Long results;
	/** rows */
	private List<?> rows;

	/**
	 * constructor
	 */
	public ExtGridReturn() {
	}

	/**
	 * @param results
	 *            total count
	 * @param rows
	 *            rows
	 */
	public ExtGridReturn(Long results, List<?> rows) {
		this.results = results;
		this.rows = rows;
	}

	/**
	 * @return the results total count
	 */
	public Long getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set total count
	 */
	public void setResults(Long results) {
		this.results = results;
	}

	/**
	 * @return the rows rows
	 */
	public List<?> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set rows
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
