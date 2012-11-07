package com.maty.j2ee.common.jackjson;

import java.io.IOException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * jackjson一些转换方法
 * 
 * @author chenxin
 * @date 2010-6-28 下午04:07:33
 */
public class Jackson {
	private static final Logger logger = LoggerFactory.getLogger(Jackson.class);

	/** 格式化时间的string */
	// private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * fromJsonToObject<br>
	 * jackjson把json字符串转换为Java对象的实现方法
	 * 
	 * <pre>
	 * return Jackson.jsonToObj(this.answersJson, new TypeReference&lt;List&lt;StanzaAnswer&gt;&gt;() {
	 * });
	 * </pre>
	 * 
	 * @param <T>
	 *            转换为的java对象
	 * @param json
	 *            json字符串
	 * @param typeReference
	 *            jackjson自定义的类型
	 * @return 返回Java对象
	 */
	public static <T> T jsonToObj(String json, TypeReference<T> typeReference) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, typeReference);
		} catch (JsonParseException e) {
			logger.error("JsonParseException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}

	/**
	 * fromJsonToObject<br>
	 * json转换为java对象
	 * 
	 * <pre>
	 * return Jackson.jsonToObj(this.answersJson, Jackson.class);
	 * </pre>
	 * 
	 * @param <T>
	 *            要转换的对象
	 * @param json
	 *            字符串
	 * @param valueType
	 *            对象的class
	 * @return 返回对象
	 */
	public static <T> T jsonToObj(String json, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, valueType);
		} catch (JsonParseException e) {
			logger.error("JsonParseException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}

	/**
	 * fromObjectToJson<br>
	 * java对象转换为json字符串
	 * 
	 * @param object
	 *            Java对象
	 * @return 返回字符串
	 */
	public static String objToJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}

	/**
	 * fromObjectToJson<br>
	 * java对象转换为json字符串
	 * 
	 * @param object
	 *            要转换的对象
	 * @param filterName
	 *            过滤器的名称
	 * @param properties
	 *            要过滤哪些字段
	 * @return
	 */
	public static String objToJson(Object object, String filterName, Set<String> properties) {
		ObjectMapper mapper = new ObjectMapper();
		FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, SimpleBeanPropertyFilter.serializeAllExcept(properties));
		try {
			mapper.setFilters(filters);
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}

	/**
	 * fromObjectToJson<br>
	 * java对象转换为json字符串
	 * 
	 * @param object
	 *            要转换的对象
	 * @param filterName
	 *            过滤器的名称
	 * @param properties
	 *            要过滤的字段名称
	 * @return
	 */
	public static String objToJson(Object object, String filterName, String property) {
		ObjectMapper mapper = new ObjectMapper();
		FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, SimpleBeanPropertyFilter.serializeAllExcept(property));
		try {
			mapper.setFilters(filters);
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}
}
