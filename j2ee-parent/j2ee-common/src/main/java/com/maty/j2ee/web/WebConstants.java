package com.maty.j2ee.web;

/**
 * web中使用的常量
 * 
 * @author maty
 * @date 2011-6-16 下午01:55:19
 */
public interface WebConstants {
	/** 超时提醒 */
	public static final String TIME_OUT = "{\"error\":true,\"msg\":\"登录超时,请重新登录！\"}";
	/** 保存session中的admin用户key */
	public static final String CURRENT_USER = "CURRENT_USER";
	
}
