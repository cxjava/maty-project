package common;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

/**
 * @author Maty Chen
 * @date 2013-2-18上午11:11:07
 */
public class Icon {

	private static String aa=".test {background-image:url(../img/icons/test.png)!important;background-repeat:no-repeat;}";
	private static String filePath="D:\\03_ide\\workspace-sts\\UI\\WebContent\\img\\icons\\";
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		File file=new File(filePath);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File imgfile : files) {
				sb.append(aa.replaceAll("test", FilenameUtils.getBaseName(imgfile.getName())));
				sb.append("\r\n");
			}
		}
		System.out.println(sb.toString());
	}
}
