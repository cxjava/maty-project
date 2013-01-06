package com.maty.j2ee.exception;

/**
 * Service层公用的Exception.
 * 
 * 继承自RuntimeException, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * 
 * @author calvin
 * @author Maty Chen
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 3583566093089790852L;

	/**
	 * error code，config in the i18n file，use
	 * MessageSource.getMessage(errorCode, null, locale) get the value ,and show
	 * to user
	 */
	private String errorCode;

	/**
	 * constructor
	 */
	public ServiceException() {
		super();
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param errorCode
	 *            use MessageSource.getMessage(errorCode, null, locale) get the
	 *            value ,and show to user
	 */
	public ServiceException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @param cause
	 * @param errorCode
	 *            use MessageSource.getMessage(errorCode, null, locale) get the
	 *            value ,and show to user
	 */
	public ServiceException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param message
	 * @param cause
	 * @param errorCode
	 *            use MessageSource.getMessage(errorCode, null, locale) get the
	 *            value ,and show to user
	 */
	public ServiceException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode use MessageSource.getMessage(errorCode, null,
	 *         locale) get the value ,and show to user
	 */
	public String getErrorCode() {
		return errorCode;
	}

}
