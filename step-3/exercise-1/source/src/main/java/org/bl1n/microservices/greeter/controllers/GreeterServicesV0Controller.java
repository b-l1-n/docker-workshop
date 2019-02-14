package org.bl1n.microservices.greeter.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.bl1n.microservices.greeter.dto.Bar;
import org.bl1n.microservices.greeter.services.BarService;
import org.bl1n.microservices.greeter.utils.HttpResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bar")
public class GreeterServicesV0Controller {

	@Autowired
	BarService barService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public void barEndpoint (HttpServletResponse response) throws IOException {
		System.out.println("Calling barEndpoint");
		
		Bar bar = barService.bar();
		
		HttpResponseHandler.includeObjectAtResponse(response, bar);
	}
}
