package org.bl1n.microservices.greeter.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	public static String objectToJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String json = mapper.writeValueAsString(object);
			return json;
		}catch(JsonProcessingException e) {
			return null;
		}
	}
	public static <T> T jsonToObject (String json, Class<T> clazz){
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Object object = mapper.readValue(json, clazz);
			return clazz.cast(object);
		}catch (Exception e) {
			return null;
		}
	}
	
}