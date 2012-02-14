package org.jboss.devconf.cdi4seam2dev.cdi.domain;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;

import org.jboss.devconf.cdi4seam2dev.util.Logger;

/**
 * Dependent CDI component - producer for {@link Logger}. Bean instance exists
 * to service producer invocation only.
 */
public class LoggerProducer {

	@Produces
	@RequestScoped
	public Logger produceLogger(BeanManager beanManager) {

		// Just a parameter injection test
		if (beanManager == null)
			throw new NullPointerException();

		return new Logger();
	}

}
