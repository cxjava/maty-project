package com.maty.j2ee.service.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @author Maty Chen
 * 
 */
public class LoginException extends AuthenticationException {

	/**  */
	private static final long serialVersionUID = 1625966047389581357L;
	/**
	 * error code，config in the i18n file，use
	 * MessageSource.getMessage(errorCode, null, locale) get the value ,and show
	 * to user
	 */
	private String errorCode;

	/**
	 * 
	 */
	public LoginException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param errorCode
	 * @param cause
	 */
	public LoginException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public LoginException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @param message
	 */
	public LoginException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LoginException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the errorCode error code，config in the i18n file，use
	 *         MessageSource.getMessage(errorCode, null, locale) get the value
	 *         ,and show to user
	 */
	public String getErrorCode() {
		return errorCode;
	}

}
