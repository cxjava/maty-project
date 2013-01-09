package com.maty.j2ee.entity.ext;

import java.io.Serializable;

/**
 * Ext Ajax返回对象
 * 
 * @author Maty Chen
 * @date 2011-3-10 下午09:43:35
 */
public class ExtReturn implements Serializable {

	private static final long serialVersionUID = 4434330175390793196L;

	/**
	 * Constructor
	 */
	public ExtReturn() {
	}

	/**
	 * 是否更新成功的构造方法
	 * 
	 * @param success
	 *            是否成功
	 * @param msg
	 *            消息
	 */
	public ExtReturn(boolean success, String successMsg) {
		this.success = success;
		this.msg = successMsg;
		this.obj = "";
	}

	/**
	 * 是否更新成功的构造方法
	 * 
	 * @param success
	 *            是否成功
	 * @param msg
	 *            消息
	 * @param other
	 *            其他对象
	 */
	public ExtReturn(boolean success, String msg, Object other) {
		this.success = success;
		this.msg = msg;
		this.obj = other;
	}

	/**
	 * 异常时的构造方法
	 * 
	 * @param msg
	 *            异常消息
	 */
	public ExtReturn(String errorMsg) {
		// 异常情况
		this.success = false;
		this.msg = errorMsg;
		this.obj = "";
	}

	/**
	 * 异常时的构造方法
	 * 
	 * @param msg
	 *            异常消息
	 */
	public ExtReturn(String errorMsg, Object other) {
		// 异常情况
		this.success = false;
		this.msg = errorMsg;
		this.obj = other;
	}

	/**
	 * 是否成功
	 */
	private boolean success;
	/**
	 * 返回消息
	 */
	private String msg;
	/**
	 * 其他对象
	 */
	private Object obj;

	/**
	 * @return 是否成功
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            是否成功
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return 返回消息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            返回消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return 其他对象
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param o
	 *            其他对象
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

}
