package com.lodentech.sayhello.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import com.lodentech.sayhello.api.ISayHello;

import javax.inject.Inject;
import org.ops4j.pax.cdi.api.OsgiService;

import org.osgi.framework.BundleContext;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.karaf.options.LogLevelOption.LogLevel;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;

import org.osgi.framework.BundleContext;

@RunWith(PaxExam.class)
public class TestSayHello {
	final Logger logger = LoggerFactory.getLogger(TestSayHello.class);

	@Inject
	protected BundleContext bundleContext;

	@Inject
	@OsgiService
	ISayHello svcSayHello;

    @Configuration
    public Option[] config() {
        MavenArtifactUrlReference karafUrl = maven()
            .groupId("org.apache.karaf")
            .artifactId("apache-karaf")
            .version("4.0.8").type("tar.gz");
        MavenArtifactUrlReference SayHelloRepo = maven()
            .groupId("com.lodentech.sayhello")
            .artifactId("sayhello-feature")
            .versionAsInProject()
            .type("xml");
        return new Option[] {
            karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf")
                .unpackDirectory(new File("target/exam")).useDeployFolder(false),
            keepRuntimeFolder(),
            features(SayHelloRepo, "sayhello-feature")
            // KarafDistributionOption.debugConfiguration("5005", true),
        };
    }

	@Test
	public void test() throws Exception {
		Assert.assertTrue(true);
	}

}
