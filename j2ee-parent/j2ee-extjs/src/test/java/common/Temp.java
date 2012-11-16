package common;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String aa="en_US,de_DE,zh_CN";
		System.out.println(ArrayUtils.contains(StringUtils.split(aa, ","),"zh_CN"));
	}

}
