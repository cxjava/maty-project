package com.maty.j2ee.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HTTPStatusCodeAuthenticationFilter extends UserFilter { 
	private static final Logger LOG = LoggerFactory.getLogger(HTTPStatusCodeAuthenticationFilter.class);
        /** 
         * This method is copied from AuthenticationFilter 
         * <p>
         * Determines whether the current subject is authenticated. 
         * <p/>
         * The default implementation 
         * {@link #getSubject(javax.servlet.ServletRequest, javax.servlet.ServletResponse) 
         * acquires} the currently executing Subject and then returns 
         * {@link org.apache.shiro.subject.Subject#isAuthenticated() 
         * subject.isAuthenticated()}; 
         * 
         * @return true if the subject is authenticated; false if the subject is 
         *         unauthenticated 
         */ 
//        @Override 
//        protected boolean isAccessAllowed(ServletRequest request, 
//                        ServletResponse response, Object mappedValue) { 
//        	LOG.debug("mappedValue : {}.", mappedValue);
//        	 if (isLoginRequest(request, response)) {
//                 return true;
//             } else {
//                 Subject subject = getSubject(request, response);
//                 // If principal is not null, then the user is known and should be allowed access.
//                 return subject.getPrincipal() != null;
//             }
//        } 

        /** 
         * Takes responsibility for returning an appropriate response when access is 
         * not allowed. 
         */ 
        @Override 
        protected boolean onAccessDenied(ServletRequest request, 
                        ServletResponse response) throws Exception { 
        	HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
    		HttpServletResponse httpServletResponse = WebUtils.toHttp(response);

    		if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {
    			LOG.debug("it is not an ajax request.");
    			 saveRequestAndRedirectToLogin(request, response);
    		} else {
    			LOG.debug("it's an ajax request.");
    			httpServletResponse.addHeader("WWW-Authentication", "ACME-AUTH"); 
    			httpServletRequest.getRequestDispatcher("/timeOut").forward(httpServletRequest, httpServletResponse);
    		}
             return false; 
        } 

} 