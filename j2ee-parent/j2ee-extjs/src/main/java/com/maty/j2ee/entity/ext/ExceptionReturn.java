package com.maty.j2ee.entity.ext;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/**
 * Ext exception return object
 * 
 * @author Maty Chen
 * @date 2011-10-11 下午12:56:56
 */
public class ExceptionReturn implements Serializable {

	private static final long serialVersionUID = 9087824523427593553L;

	/**
	 * constructor
	 */
	public ExceptionReturn() {
	}

	/**
	 * 
	 * @param msg
	 *            exception
	 */
	public ExceptionReturn(Throwable exceptionMessage) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exceptionMessage.printStackTrace(pw);
		// 异常情况
		this.success = false;
		// 太详细了
		this.exceptionMessage = exceptionMessage.getMessage();
	}

	/** is success */
	private boolean success;
	/** exception message */
	private Object exceptionMessage;

	/**
	 * @return the success is success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set is success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the exceptionMessage exception message
	 */
	public Object getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage
	 *            the exceptionMessage to set exception message
	 */
	public void setExceptionMessage(Object exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
