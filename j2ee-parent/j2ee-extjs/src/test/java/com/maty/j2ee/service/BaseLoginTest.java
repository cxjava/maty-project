package com.maty.j2ee.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseUser;
import com.maty.j2ee.repository.BaseUserRepository;

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
        final String password = "1";
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
}
