package com.maty.j2ee.web.filter;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Maty Chen
 * @date 2013-1-15下午5:05:15
 */
public class MySessionListenerAdapter implements SessionListener {
private static final Logger LOG = LoggerFactory.getLogger(MySessionListenerAdapter.class);

	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		LOG.debug("session : {}.", session);
	}

	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub
		LOG.debug("session : {}.", session);
	}

	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		LOG.debug("session : {}.", session);
		
	}

}
