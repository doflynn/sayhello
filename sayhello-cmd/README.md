# SayHello Karaf Shell Command

Apache Karaf provides a shell interface with a default set of commands.  Shell commands can easily
be created to allow you to create command line interfaces to your services.

For reference, see the Karaf [Extending Console](http://karaf.apache.org/manual/latest/#_console_3) documentation for details.

## Command Usage

sayhello:hello <name>
* Where *name* is the name of the person to say hello to

### Example

    karaf@root()> sayhello:hello dennis
    Greetings dennis
    karaf@root()> 
    
### Help

    karaf@root()> sayhello --help
    SUBSHELL
    	sayhello
    
    COMMANDS
        sayhello:hello Say hello
    karaf@root()>       

## Prerequisites

The *sayhello command* requires the *sayhello service* that is registered via Declarative Services.

   