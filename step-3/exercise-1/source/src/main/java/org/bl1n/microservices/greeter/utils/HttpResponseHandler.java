package org.bl1n.microservices.greeter.utils;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

public class HttpResponseHandler {

	public static void includeObjectAtResponse(HttpServletResponse response, Object object) throws IOException {
		
		String hostname;
        
        try {
        	hostname = InetAddress.getLocalHost().getHostName();
        }catch(IOException e) {
        	hostname = "Default origin";
        }
		
		response.addHeader("x-origin", hostname);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(JsonConverter.objectToJson(object));
	}
	
}
