package org.jboss.devconf.cdi4seam2dev.seam2;

import java.io.File;

import org.jboss.devconf.cdi4seam2dev.seam2.domain.Translator;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;
import org.jboss.seam.contexts.Lifecycle;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.After;
import org.junit.Before;

public abstract class Seam2Test {

	/**
	 * Create test archive base. Include Seam dependencies.
	 * 
	 * @return test archive base
	 */
	public static WebArchive createTestArchiveBase() {
		return ShrinkWrap
				.create(WebArchive.class)
				.addPackage(Translator.class.getPackage())
				.addAsLibraries(
						ShrinkWrap.create(JavaArchive.class).addPackage(
								TestConstants.class.getPackage()))
				.addClasses(Seam2Test.class)
				.addAsResource(
						new File("src/test/resources/META-INF/seam.properties"))
				.addAsWebInfResource(
						new File("src/test/resources/WEB-INF/web.xml"))
				.addAsLibraries(
						DependencyResolvers
								.use(MavenDependencyResolver.class)
								.artifact(
										"org.jboss.seam:jboss-seam:2.2.1.Final")
								.artifact("javassist:javassist:3.12.1.GA")
								.artifact("dom4j:dom4j:1.6.1")
								.artifact(
										"org.hibernate:hibernate-validator:3.1.0.GA")
								.resolveAs(GenericArchive.class));
	}

	/**
	 * Begin call - event, session, app, conversation, business context are
	 * available
	 */
	@Before
	public void init() {
		Lifecycle.beginCall();
	}

	@After
	public void cleanup() {
		Lifecycle.endCall();
	}

}
