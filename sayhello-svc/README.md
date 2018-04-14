# SayHello Service

The *sayhello service* is the core of the sayhello tutorial.  It provides the OSGi service component 
that implements the core logic for sayhello.  The service component is registered with OSGi using
Declarative Services (DS).

Service registration vs DS is simplified beginning wit Karaf v4 via annotations instead of creating
blueprint XML deployment descriptors.

## Configuration

The *sayhello service* uses the Configuration Admin service to manage it configuration settings.  The
configuration PID  "com.lodentech.sayhello" has a corresponding configuration file located in KARAF_ETC
folder.

Changes to the *sayhello service* configuration properties can be made by editing the configuration file
or by the [WebConsole](http://localhost:8181/system/console/configMgr).  The *sayhello service* will be
notified when any change is made to its configuration properties.

## CXF REST

The SayHello service is also registered as a REST service via CXF.  OSGi _blueprint_ is used to 
configure CXF to deploy the previously registered SayHello service.

The REST web service is accessbile via:

## Execution
The web app for SayHello is accessbile via

    http://localhost:8181/sayhello



