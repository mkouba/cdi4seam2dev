package org.jboss.devconf.cdi4seam2dev.cdi;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.devconf.cdi4seam2dev.cdi.domain.Translator;
import org.jboss.devconf.cdi4seam2dev.util.HeapUtil;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CdiPerformanceTest extends CdiTest {

	@Deployment
	public static WebArchive createTestArchive() {
		return createTestArchiveBase().addClass(CdiPerformanceTest.class);
	}
	
	@Inject
	Translator translator;
	
	@Test
	public void testPerformance() {

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
