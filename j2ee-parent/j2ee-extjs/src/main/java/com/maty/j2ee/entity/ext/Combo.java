package com.maty.j2ee.entity.ext;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * EXT Combo object
 * 
 * @author Maty Chen
 * @date 2012-2-27 上午9:32:31
 */
public class Combo implements Serializable {
	private static final long serialVersionUID = 6720784189359113848L;
	private String k;
	private String v;

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * 
	 */
	public Combo() {
		super();
	}

	/**
	 * @param k
	 * @param v
	 */
	public Combo(String k, String v) {
		super();
		this.k = k;
		this.v = v;
	}

	/**
	 * @return the k
	 */
	public String getK() {
		return k;
	}

	/**
	 * @param k
	 *            the k to set
	 */
	public void setK(String k) {
		this.k = k;
	}

	/**
	 * @return the v
	 */
	public String getV() {
		return v;
	}

	/**
	 * @param v
	 *            the v to set
	 */
	public void setV(String v) {
		this.v = v;
	}

}
