package common;

import org.apache.commons.lang3.StringUtils;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;
		System.out.println(Integer.valueOf(0/10));
		System.out.println(Integer.valueOf(1/10));
		System.out.println(Integer.valueOf(9/10));
		System.out.println(Integer.valueOf(10/10));
		System.out.println(Integer.valueOf(11/10));
		System.out.println(Integer.valueOf(21/10));
		String aa=" field desc ,, ";
		for(String t:StringUtils.split(aa, ',')){
			System.out.println(t);
			for(String m:StringUtils.split(t,' ')){
				System.out.println(m);
			}
		}
	}

}
