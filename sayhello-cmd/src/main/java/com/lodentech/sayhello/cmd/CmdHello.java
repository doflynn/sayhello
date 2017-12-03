package com.lodentech.sayhello.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lodentech.sayhello.api.ISayHello;


import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

/**
 * SayHello Karaf Shell Command
 *
 */
@Command(scope = "sayhello", name = "hello", description="Say hello")
@Service
public class CmdHello implements Action
{
	final Logger logger = LoggerFactory.getLogger(CmdHello.class);

	@Reference
	ISayHello svcSayHello = null;
    
    //Command line arguments - just one argument.
    @Argument(index=0,name="name", required=true, description="name of person to say hello to.")
    String name = null;

	@Override
	public Object execute() throws Exception {
		if ( svcSayHello != null ) {
	    	System.out.println( svcSayHello.sayHello(name).toString() );			
		}
		else {
			System.out.println( "svcSayHello not initialized");
		}

		return null;
	}

}
