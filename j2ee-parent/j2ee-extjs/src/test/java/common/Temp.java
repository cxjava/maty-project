package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test();
		// test1();
		// test2();
		test3();
	}

	private static void test3() {
		//216.239.32.1
		StringBuilder sb = new StringBuilder();
		for (int i = 30; i < 39; i++) {
			for (int j = 1; j < 255; j=j+3) {
				sb.append("203.208.").append(i).append(".").append(j).append(System.getProperty("line.separator"));
			}
		}
		System.out.println(sb.toString());
	}

	private static void test() {
		try {
			String aaa = FileUtils.readFileToString(new File("D:/123.txt"));
			String[] aa = StringUtils.split(aaa, System.getProperty("line.separator"));
			for (String string : aa) {
				System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void test1() {
		final String numberList = "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten";

		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			StringUtils.split(numberList, ',');
		}
		System.out.println(System.currentTimeMillis() - start);

		start = System.currentTimeMillis();
		Splitter splitter = Splitter.on(',');
		for (int i = 0; i < 1000000; i++) {
			splitter.split(numberList);
		}
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			numberList.split(",");
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	private static void test2() {
		final String numberList = "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			final String[] numbers = StringUtils.split(numberList, ',');
			for (String number : numbers) {
				number.length();
			}
		}
		System.out.println(System.currentTimeMillis() - start);

		Splitter splitter = Splitter.on(',');
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			Iterable<String> numbers = splitter.split(numberList);
			for (String number : numbers) {
				number.length();
			}
		}
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			String[] numbers = numberList.split(",");
			for (String number : numbers) {
				number.length();
			}
		}
		System.out.println(System.currentTimeMillis() - start);

	}
}
