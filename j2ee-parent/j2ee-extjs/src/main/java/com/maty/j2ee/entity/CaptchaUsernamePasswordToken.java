package com.maty.j2ee.entity;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Maty Chen
 *
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
	/**  */
	private static final long serialVersionUID = -7650828353661192814L;
	/** The captcha */
	private String captcha;

	/**
	 * @return
	 */
	public String getCaptcha() {
		return captcha;
	}

	/**
	 * @param captcha
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	/**
	 * 
	 */
	public CaptchaUsernamePasswordToken() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 * @param rememberMe
	 * @param host
	 * @param captcha
	 */
	public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}
}