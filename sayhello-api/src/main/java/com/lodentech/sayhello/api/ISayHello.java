/**
 * SayHello Public APIs
 * 
 * Copyright 2016 Loden Technologies, LLC
 */
package com.lodentech.sayhello.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * SayHello - OSGi 'Hello World' example
 * 
 * @author doflynn
 */
@Path("/v1/accidents")
public interface ISayHello {
	/**
	 * Say Hello to someone
	 * 
	 * @param name - the person to say hello to
	 * @return personal greeeting
	 */
	public String sayHello( String name)
;}
