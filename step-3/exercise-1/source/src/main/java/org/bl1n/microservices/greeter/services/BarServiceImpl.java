package org.bl1n.microservices.greeter.services;

import org.bl1n.microservices.greeter.dto.Bar;
import org.springframework.stereotype.Service;

@Service
public class BarServiceImpl implements BarService{

	@Override
	public Bar bar() {
		Bar bar = new Bar();

		bar.setMessage("Hello from Java Service");
		
		return bar;
	}
}
