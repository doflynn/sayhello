/**
 * Copyright (c) 2016 Loden Technologies, LLC
 */
package com.lodentech.sayhello.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lodentech.sayhello.api.ISayHello;

// annotations...
import javax.inject.Singleton;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;


/**
 * Implementation of SayHello
 *
 * @author doflynn
 */
@OsgiServiceProvider(classes=ISayHello.class)
@Properties(@Property(name = "service.exported.interfaces", value = "*"))
@Singleton
public class SayHelloImpl implements ISayHello {

	final Logger logger = LoggerFactory.getLogger(SayHelloImpl.class);
	
	private static final String HELLO_CASUAL = "Hi ";
	private static final String HELLO_INFORMAL = "Hello ";
	private static final String HELLO_FORMAL = "Greetings ";
	
	private String hello = HELLO_INFORMAL;
	
	public void start() {
		logger.debug("activating sayHello service");
		
	}
	
	public void stop() {
		logger.debug("deactivating sayHello service");
		
	}
	
	/* (non-Javadoc)
	 * @see com.lodentech.sayhello.api.ISayHello#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		logger.info("Saying hello to: ", name);
		
		return hello + name;
	}

}
