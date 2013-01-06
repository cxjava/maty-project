package com.maty.j2ee.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @author Maty Chen
 * 
 */
public class CaptchaException extends AuthenticationException {

	/**  */
	private static final long serialVersionUID = -2411082498869295717L;
	/**
	 * error code，config in the i18n file，use
	 * MessageSource.getMessage(errorCode, null, locale) get the value ,and show
	 * to user
	 */
	private String errorCode;

	/**
	 * 
	 */
	public CaptchaException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param errorCode
	 * @param cause
	 */
	public CaptchaException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public CaptchaException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @param message
	 */
	public CaptchaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CaptchaException(Throwable cause) {
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
