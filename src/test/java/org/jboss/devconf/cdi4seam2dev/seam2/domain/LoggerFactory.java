package org.jboss.devconf.cdi4seam2dev.seam2.domain;

import org.jboss.devconf.cdi4seam2dev.util.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Seam component - factory for {@link Logger}.
 */
@AutoCreate
@Name("loggerFactory")
@Scope(ScopeType.STATELESS)
public class LoggerFactory {

	@Factory(scope = ScopeType.EVENT, autoCreate = true)
	public Logger getLogger() {
		return new Logger();
	}

}
