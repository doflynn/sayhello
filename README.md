# Karaf-Maven Tutorial: sayhello
Apache Karaf tutorial modeled after "Hello World"

## POM Hierarchy
* sayhello: parent POM
* sayhello-api: Public APIs
* sayhello-svc: OSGi service implementation

## Build
`mvn clean install`

## Karaf Commands
The following are common commands 
* `feature:repo-add mvn:com.lodentech.sayhello/sayhello-feature/1.0.0-SNAPSHOT/xml`
* `feature:install sayhello-feature`
* `feature:uninstall sayhello-feature`
* `feature:repo-refresh`
* `feature:repo-remove mvn:com.lodentech.sayhello/sayhello-feature/1.0.0-SNAPSHOT/xml`
