# SayHello - Karaf Feature
This module provides the Karaf feature deployment for the *sayhello* project

## Default Configuration Settings  
Default configuration settings are defined in *com.lodentech.sayhello.cfg* file.  This file will be stored into the 
Maven repository and installed in the Karaf container when the feature is installed.

### Karaf Feature Installation

1. Add the maven repo for *sayhello* 

    karaf> feature:repo-add mvn:com.lodentech.sayhello/sayhello-feature/1.0.0-SNAPSHOT/xml
  
2. Install the *sayhello feature

    karaf> feature:install sayhello
   
## DevOps
The maven pom for this module includes instructions for storing the files in the *resources* folder in the maven repository.

### Build
The maven build process references the *osgi.bnd* file to define additional attributes to the bundle's manifest.  This build step requires
the *osgi.bnd* file to exist in each module, even it the file is empty, to successfully perform the build step.

### Feature Includes Configuration File
The Karaf feature definition includes the reference to the default configuration file stored in the maven repository.  When
the feature is installed the first time, Karaf will include the default configuration file in its deployment. 

		<!--
		 * when installing the feature, also install the default configuration settings 
		 -->
		<configfile finalname="${karaf.etc}/com.lodentech.sayhello.cfg" override="false">
			mvn:${groupId}/sayhello-feature/${project.version}/cfg/configuration
		</configfile>


