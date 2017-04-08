package com.lodentech.sayhello.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lodentech.sayhello.api.ISayHello;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

/**
 * SayHello Karaf Shell Command
 *
 */
@Singleton
@OsgiServiceProvider(classes=CmdHello.class)
@Properties(//
{
 @Property(name = "osgi.command.scope", value = "sayhello"),
 @Property(name = "osgi.command.function", value = "hello")
})
public class CmdHello 
{
	final Logger logger = LoggerFactory.getLogger(CmdHello.class);

    @Inject @OsgiService
    ISayHello svcSayHello;
    
    public void hello( String name ) throws Exception {
    	System.out.println( svcSayHello.sayHello(name) );
    }

}
