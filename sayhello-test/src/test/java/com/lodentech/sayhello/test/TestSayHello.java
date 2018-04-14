package com.lodentech.sayhello.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import com.lodentech.sayhello.api.ISayHello;

import javax.inject.Inject;

import org.osgi.framework.BundleContext;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.ConfigurationManager;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.karaf.options.LogLevelOption.LogLevel;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.MavenUrlReference;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.osgi.framework.BundleContext;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class TestSayHello {
	final Logger logger = LoggerFactory.getLogger(TestSayHello.class);

	@Inject
	protected BundleContext bundleContext;

	@Inject
	ISayHello svcSayHello;

    @Configuration
    public Option[] config() {
        System.out.println("Configuration Pax Exam");
        
        MavenArtifactUrlReference karafUrl = maven()
            .groupId("org.apache.karaf")
            .artifactId("apache-karaf")
            .version(karafVersion())
            .type("tar.gz");
        
        MavenUrlReference repoKarafStandard = maven()
                .groupId("org.apache.karaf.features")
                .artifactId("standard")
                .classifier("features")
                .type("xml")
                .version(karafVersion());
        
        /*
         * mvn:org.apache.cxf.karaf/apache-cxf/3.2.1/xml/features
         */
//        MavenArtifactUrlReference repoApacheCXF = maven()
//                .groupId("org.apache.cxf.karaf")
//                .artifactId("apache-cxf")
//                .version("3.2.1")
//                .type("xml");
                
//        MavenArtifactUrlReference SayHelloRepo = maven()
//                .groupId("com.lodentech.sayhello")
//                .artifactId("sayhello-feature")
//                .versionAsInProject()
//                .type("xml");

        /*
         *  mvn:com.lodentech.sayhello/sayhello-feature/1.0.0-SNAPSHOT/xml
         */
        MavenArtifactUrlReference repoSayHello = maven()
                .groupId("com.lodentech.sayhello")
                .artifactId("sayhello-feature")
                .version("1.0.0-SNAPSHOT")
                .type("xml");
        System.out.println("SayHelloRepo: "+repoSayHello.toString() );
        
        return new Option[] {
            karafDistributionConfiguration()
            	.frameworkUrl(karafUrl)
            	.name("Apache Karaf")
                .unpackDirectory(new File("target", "paxexam"))
                .useDeployFolder(false),
            keepRuntimeFolder(),
            features(repoKarafStandard, "scr", "war"),
//            features(repoApacheCXF, "cxf"),
            features( maven()
            			.groupId("org.apache.cxf.karaf")
            			.artifactId("apache-cxf")
            			.type("xml")
						.classifier("features")
						.versionAsInProject(), 
						"cxf-core", "cxh-hppt", "cxf-jaxws", "cxf-jackson"),
            features(repoSayHello, "sayhello"),
            // KarafDistributionOption.debugConfiguration("5005", true),
        };
    }

    public static String karafVersion() {
        ConfigurationManager cm = new ConfigurationManager();
        String karafVersion = cm.getProperty("pax.exam.karaf.version", "4.0.8");
        
        System.out.println("Pax Exam Karaf Version: "+karafVersion);
        return karafVersion;
    }

	@Test
	public void testTrue() throws Exception {
		logger.debug("testTrue");
		System.out.println("SayHello: testTrue");
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testSayHello() throws Exception {
		logger.debug("testSayHello");
		
		System.out.println("SayHello: "+ this.svcSayHello.sayHello("John Doe") );
		Assert.assertTrue(true);
	}

}
