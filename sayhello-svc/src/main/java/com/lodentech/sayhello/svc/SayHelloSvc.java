/**
 * Copyright (c) 2016 Loden Technologies, LLC
 */
package com.lodentech.sayhello.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lodentech.sayhello.api.ISayHello;

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
@Component( name="svcSayHello", configurationPid={"com.lodentech.sayhello"}, immediate=true)
public class SayHelloSvc implements ISayHello {

	private static final String GREETING = "greeting";

	final Logger logger = LoggerFactory.getLogger(SayHelloSvc.class);
	protected String greeting;
	protected String name;

	@Override
	public ISayHello sayHello(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getGreeting() {
		return this.greeting;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.greeting + " " + this.name;
	}

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

}