package com.maty.j2ee.service;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseUser;
import com.maty.j2ee.repository.BaseUserRepository;
import com.maty.j2ee.shiro.ShiroRealm;

public class BaseLoginTest extends Base {
	@Autowired
	private BaseUserService userService;
	@Autowired
	private BaseUserRepository userRepository;
	private BaseUser user;

	@Before
	public void before() {
		user = new BaseUser();
		user.setAccount("LiHuai");
		user.setRealName("李坏");
		user.setPassword("123456");
		user.setLastLoginTime(new Date());
	}


	@Test
    public void testBackwardsCompatibleSaltedAuthenticationInfo() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Sha1Hash.ALGORITHM_NAME);
        //enable this for Shiro 1.0 backwards compatibility:
        matcher.setHashIterations(1024); 
        //simulate an account with SHA-1 hashed password, using the username as the salt
        //(BAD IDEA, but backwards-compatible):
        final String username = "test";
        //1 SHA256 twice equal below;
        final String password = "9c2e4d8fe97d881430de4e754b4205b9c27ce96715231cffc4337340cb110280";
      //Note that a normal app would reference an attribute rather
		//than create a new RNG every time:
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		ByteSource  byteSource = rng.nextBytes();
		String salt=byteSource.toHex();
		System.out.println(salt);
		//now hash the plain-text password with the random salt and multiple
		//iterations and then Base64-encode the value (requires less space than Hex):
		Sha1Hash sha1Hash = new Sha1Hash(password, byteSource, 1024);
		String hexPassword=sha1Hash.toHex();
		System.out.println(hexPassword);
        AuthenticationInfo account = new  SimpleAuthenticationInfo(new ShiroRealm.ShiroUser(username, username), hexPassword,
        		ByteSource.Util.bytes(Hex.decode(salt)), "getName()");
 
        //simulate a username/password (plaintext) token created in response to a login attempt:
        AuthenticationToken token = new UsernamePasswordToken(username, password);
 
        //verify the hashed token matches what is in the account:
        assertTrue(matcher.doCredentialsMatch(token, account));
    }
	
	@Test
	public void testException(){
		Subject currentUser = SecurityUtils.getSubject();
		
		try {
		if ( !currentUser.isAuthenticated() ) {
		    //collect user principals and credentials in a gui specific manner 
		    //such as username/password html form, X509 certificate, OpenID, etc.
		    //We'll use the username/password example here since it is the most common.
		    //(do you know what movie this is from? ;)
		    UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
		    //this is all you have to do to support 'remember me' (no config - built in!):
		    token.setRememberMe(true);
		    currentUser.login( token );
		}
		
		    //if no exception, that's it, we're done!
		} catch ( UnknownAccountException uae ) {
		    //username wasn't in the system, show them an error message?
		} catch ( IncorrectCredentialsException ice ) {
		    //password didn't match, try again?
		} catch ( LockedAccountException lae ) {
		    //account for that username is locked - can't login.  Show them a message?
		} catch ( AuthenticationException ae ) {
		    //unexpected condition - error?
		}
	}
}
