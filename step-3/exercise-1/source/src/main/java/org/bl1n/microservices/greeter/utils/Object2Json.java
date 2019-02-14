package org.bl1n.microservices.greeter.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;

public class Object2Json {

		private ObjectMapper objectMapper;

		public Object2Json(ObjectMapper objectMapper){
			this.objectMapper = objectMapper;
		}

		public Object2Json(){
			objectMapper = new ObjectMapper();
			objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'"));
		}

		public String object2Json(Object object) throws IOException {
			return objectMapper.writeValueAsString(object);
		}

		public <T> T json2Object(String json, Class<T> clazz) throws IOException {
				return objectMapper.readValue(json, clazz);
		}

	}