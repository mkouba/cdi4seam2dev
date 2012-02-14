package org.jboss.devconf.cdi4seam2dev.cdi;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.devconf.cdi4seam2dev.cdi.domain.Translator;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CdiInjectionTest extends CdiTest {

	@Deployment
	public static WebArchive createTestArchive() {
		return createTestArchiveBase().addClass(CdiInjectionTest.class);
	}

	@Inject
	Translator translator;

	@Test
	public void testInjection() {

		// CDI component invocation
		assertEquals("this is the test", translator.translate("Toto je test"));
	}

}
