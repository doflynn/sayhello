/**
 * 
 */
package com.lodentech.sayhello.svc;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author denni
 *
 */
public class SayHelloSvcTest {

	/**
	 * Test method for {@link com.lodentech.sayhello.svc.SayHelloSvc#sayHello(java.lang.String)}.
	 */
	@Test
	public void testSayHello() {
		String name = "TEST";
		
		SayHelloSvc testHello = new SayHelloSvc();
		String greeting = testHello.sayHello(name).toString();
		
		assertTrue( greeting.contains(name));
	}

}
