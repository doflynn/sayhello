/**
 * SayHello Public APIs
 * 
 * Copyright 2016 Loden Technologies, LLC
 */
package com.lodentech.sayhello.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * SayHello - OSGi 'Hello World' example
 * 
 * @author doflynn
 */
@Path("/hello")
public interface ISayHello {
	/**
	 * Say Hello to someone
	 * 
	 * @param name - the person to say hello to
	 * @return personal greeeting
	 */
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public ISayHello sayHello( @PathParam("id") String name);
	
	public String getGreeting();
	public String getName();
}
