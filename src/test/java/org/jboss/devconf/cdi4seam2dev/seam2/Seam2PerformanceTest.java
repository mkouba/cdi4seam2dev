package org.jboss.devconf.cdi4seam2dev.seam2;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.devconf.cdi4seam2dev.seam2.domain.Translator;
import org.jboss.devconf.cdi4seam2dev.util.HeapUtil;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;
import org.jboss.seam.Component;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class Seam2PerformanceTest extends Seam2Test {

	@Deployment
	public static WebArchive createTestArchive() {
		return createTestArchiveBase().addClass(Seam2PerformanceTest.class);
	}

	@Test
	public void testPerformance() {

		// Seam 2 injection is not supported yet
		// Arquillian extension is work in progress
		Translator translator = (Translator) Component
				.getInstance(Translator.class);

		HeapUtil.logHeapStatus();
		long start = System.currentTimeMillis();

		for (int i = 0; i < TestConstants.LOOP; i++) {
			// We only test injection performance
			translator.translate("Toto je test");
		}
		
		long time = System.currentTimeMillis() - start;
		HeapUtil.logHeapStatus();
		
		System.out.println("Loop of " + TestConstants.LOOP + " cycles finished in " + time
				+ " ms");
	}

}
