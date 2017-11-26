# SayHello - Karaf Tutorial
This project (*sayhello*) is a tutorial reference for maven project, with modules, for the Apache Karaf platform.  This 
project is modeled after "Hello World", that utilizes OSGi services to provide access to a POJO from various access points.


## POM Hierarchy
* sayhello - parent POM
* sayhello-api - Public APIs
* sayhello-svc -  OSGi service implementation
* sayhello-cmd - Karaf console command
* sayhello-ui - Web UI

## Build
    mvn clean install

## Karaf 

### Prerequisites 
* Apache Karav v4.1.3
* Apache CXF v3.2.1


    feature:install webconsole
    
    feature:repo-add cxf 3.2.1
    feature:install cxf cxf-jaxrs
    feature:install pax-cdi
    
    
    
### Install SayHello Feature
The following are common commands 

    feature:repo-add mvn:com.lodentech.sayhello/sayhello-feature/1.0.0-SNAPSHOT/xml
    feature:install sayhello-feature
    feature:uninstall sayhello-feature
    feature:repo-refresh
    feature:repo-remove mvn:com.lodentech.sayhello/sayhello-feature/1.0.0-SNAPSHOT/xml

## Licensing
This project, and its modules are licensed under the (Apache Software License v2.0)[https://www.apache.org/licenses/LICENSE-2.0] 


