/**
 * Copyright (c) 2016 Loden Technologies, LLC
 */
package com.lodentech.sayhello.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lodentech.sayhello.api.ISayHello;

import java.util.Map;

import org.osgi.service.component.ComponentContext;
// annotations...
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;


/**
 * Implementation of SayHello
 *
 * @author doflynn
 */
@Component( configurationPid={"com.lodentech.sayhello"}, immediate=true)
public class SayHelloSvc implements ISayHello {

	private static final String GREETING = "greeting";

	final Logger logger = LoggerFactory.getLogger(SayHelloSvc.class);

	private String greeting = "Hello";
	
	@Activate
	public void start(ComponentContext ctx) {
		logger.info("activating sayHello service");
		updateConfig(ctx);
	}
	
	@Deactivate
	public void stop() {
		logger.info("deactivating sayHello service");
		
	}
	
	@Modified
	public void updateConfig( ComponentContext ctx ) {
		logger.info("updating sayHello configuration");
		
		String value = ctx.getProperties().get(GREETING).toString();
		if ( value != null ) {
			this.greeting = value;
			logger.info("...greeting = "+this.greeting);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lodentech.sayhello.api.ISayHello#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		logger.info("Saying hello to: ", name);
		
		return this.greeting + " " + name;
	}

}
