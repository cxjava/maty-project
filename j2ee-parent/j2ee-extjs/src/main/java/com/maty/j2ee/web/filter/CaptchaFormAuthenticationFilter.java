package com.maty.j2ee.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maty.j2ee.entity.CaptchaUsernamePasswordToken;
import com.maty.j2ee.service.exception.CaptchaException;

/**
 * 
 * @author <a href="mailto:ketayao@gmail.com">ketayao</a> Version 1.1.0
 * @since 2012-8-7 上午9:20:26
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

	private static final Logger LOG = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);

	/** default parameter name */
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	/** default parameter name */
	public static final String DEFAULT_ERRORCODE_PARAM = "captcha";

	/** captcha name */
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	private String errorCodeKeyAttribute = DEFAULT_ERRORCODE_PARAM;

	/**
	 * @return
	 */
	public String getCaptchaParam() {
		return captchaParam;
	}

	/**
	 * @return the errorCodeKeyAttribute
	 */
	public String getErrorCodeKeyAttribute() {
		return errorCodeKeyAttribute;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#createToken(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse)
	 */
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		return new CaptchaUsernamePasswordToken(username, password, rememberMe, host, captcha);
	}

	/**
	 * 覆盖默认实现，用sendRedirect直接跳出框架，以免造成js框架重复加载js出错。
	 * 
	 * @param token
	 * @param subject
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#onLoginSuccess(org.apache.shiro.authc.AuthenticationToken,
	 *      org.apache.shiro.subject.Subject, javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse)
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		// issueSuccessRedirect(request, response);
		// we handled the success redirect directly, prevent the chain from
		// continuing:
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {
			// 不是ajax请求
			LOG.debug("not ajax");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + this.getSuccessUrl());
		} else {
			LOG.debug("is ajax");
			httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest, httpServletResponse);
		}

		return false;
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
		setFailureAttribute(request, e);
		setErrorCodeAttribute(request, e);
		// login failed, let request continue back to the login page:
		return true;
	}

	protected void setErrorCodeAttribute(ServletRequest request, AuthenticationException ae) {
		if (ae instanceof CaptchaException) {
			CaptchaException captchaException = (CaptchaException) ae;
			request.setAttribute(getErrorCodeKeyAttribute(), captchaException.getErrorCode());
		}
	}

}