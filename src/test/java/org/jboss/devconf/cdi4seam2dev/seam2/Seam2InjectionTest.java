package org.jboss.devconf.cdi4seam2dev.seam2;

import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.devconf.cdi4seam2dev.seam2.domain.Translator;
import org.jboss.seam.Component;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class Seam2InjectionTest extends Seam2Test {

	@Deployment
	public static WebArchive createTestArchive() {
		return createTestArchiveBase().addClass(Seam2InjectionTest.class);
	}

	@Test
	public void testInjection() {

		// Programmatic lookup - Seam 2 injection is not supported yet
		Translator translator = (Translator) Component
				.getInstance(Translator.class);

		// Seam component invocation
		assertEquals("this is the test",
				translator.translate("Toto je test"));
	}

}
