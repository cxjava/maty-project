package com.maty.j2ee.pojo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

/**
 * 公用条件查询类
 */
public class Criteria {
    /**
     * 存放条件查询值
     */
    private Map<String, Object> condition;

    /**
     * 是否相异
     */
    protected boolean distinct;

    /**
     * 排序字段
     */
    protected String orderByClause;

    /**
     * 每页大小，即mysql中的length
     */
    private Integer limit;

    /**
     * 开始行数，即mysql中的offset
     */
    private Integer start;

    protected Criteria(Criteria example) {
        this.orderByClause = example.orderByClause;
        this.condition = example.condition;
        this.distinct = example.distinct;
        this.limit = example.limit;
        this.start = example.start;
    }

    public Criteria() {
        this.condition = new HashMap<String, Object>();
    }

    public void clear() {
        this.condition.clear();
        this.orderByClause = null;
        this.distinct = false;
        this.limit=null;
        this.start=null;
    }

    /**
     * @param condition 
	 *            查询的条件名称
	 * @param value
	 *            查询的值
     */
    public Criteria put(String condition, Object value) {
        this.condition.put(condition, value);
        return (Criteria) this;
    }

    /**
     * @param orderByClause 
	 *            排序字段
	 */
	public void setOrderByClause(String orderByClause) {
		// TODO:防sql注入啊
		// if(有sql注入){this.this.orderByClause = "1";}
		this.orderByClause = orderByClause;
	}

    /**
     * @param distinct 
	 *            是否相异
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    /**
     * @param limit 
	 *            每页大小，即mysql中的length
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @param start 
	 *            开始行数，即mysql中的offset
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * 以Integer类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	public Integer getInteger(String key) {
		return MapUtils.getInteger(condition, key);
	}

	public int getIntValue(String key) {
		return MapUtils.getIntValue(condition, key);
	}

	/**
	 * 以Long类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Long 键值
	 */
	public Long getLong(String key) {
		return MapUtils.getLong(condition, key);
	}

	public long getLongValue(String key) {
		return MapUtils.getLongValue(condition, key);
	}

	/**
	 * 以String类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return String 键值
	 */
	public String getString(String key) {
		return MapUtils.getString(condition, key);
	}

	/**
	 * 以Boolean类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Boolean getBoolean(String key) {
		return MapUtils.getBoolean(condition, key);
	}

	public boolean getBooleanValue(String key) {
		return MapUtils.getBooleanValue(condition, key);
	}

}