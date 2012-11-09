package com.maty.j2ee.entity;

public class SearchFilter {

	public enum Operator {
		EQ, LIKE, GT, LT, GTE, LTE
	}

	public String fieldName;
	public Object value;
	public Operator operator;

	public SearchFilter(String fieldName, Operator operator, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}

	public SearchFilter(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = Operator.EQ;
	}
}
