package com.maty.j2ee.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * field table
 */
@Entity
@Table(name = "t_base_field")
public class BaseField extends IdEntity {

	private String field;
	private String fieldName;
	/** field value */
	private String valueField;
	/** field display value */
	private String displayField;
	/** is enabled */
	private Integer enabled;
	private Integer sort;

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
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
	 * @return the valueField field value
	 */
	public String getValueField() {
		return valueField;
	}

	/**
	 * @param valueField
	 *            the valueField to set field value
	 */
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	/**
	 * @return the displayField field display value
	 */
	public String getDisplayField() {
		return displayField;
	}

	/**
	 * @param displayField
	 *            the displayField to set field display value
	 */
	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}

	/**
	 * @return the enabled is enabled
	 */
	public Integer getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set is enabled
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort
	 *            the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}