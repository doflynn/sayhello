/**
 * Copyright (c) 2016 Loden Technologies, LLC
 */
package com.lodentech.sayhello.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lodentech.sayhello.api.ISayHello;

/**
 * Implementation of SayHello
 *
 */
public class SayHelloImpl implements ISayHello {

	final Logger logger = LoggerFactory.getLogger(SayHelloImpl.class);
	
	private static final String HELLO_CASUAL = "Hi ";
	private static final String HELLO_INFORMAL = "Hello ";
	private static final String HELLO_FORMAL = "Greetings ";
	
	private String hello = HELLO_INFORMAL;
	
	/* (non-Javadoc)
	 * @see com.lodentech.sayhello.api.ISayHello#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		logger.debug("Saying hello to: ", name);
		
		return hello + name;
	}

}
