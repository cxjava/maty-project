package com.maty.j2ee.entity;

/**
 * dynamic get all search data
 */
public class SearchFilter {

	/**
	 * all the operator
	 */
	public enum Operator {
		EQ, LIKE, GT, LT, GTE, LTE, DISTINCT
	}

	private String fieldName;
	private Object value;
	private Operator operator;

	/**
	 * Constructor
	 * 
	 * @param fieldName
	 * @param operator
	 * @param value
	 */
	public SearchFilter(String fieldName, Operator operator, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}

	/**
	 * Default operator is EQ
	 * 
	 * @param fieldName
	 * @param value
	 */
	public SearchFilter(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = Operator.EQ;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
