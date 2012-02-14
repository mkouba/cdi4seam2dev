package org.jboss.devconf.cdi4seam2dev.cdi.domain;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.jboss.devconf.cdi4seam2dev.util.Logger;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;

/**
 * Request scoped CDI component.
 */
@RequestScoped
public class Translator {

	/*
	 * Inject component with bean type "Dictionary" and qualifier @Default;
	 * instantiation of new component is handled automatically
	 */
	@Inject
	Dictionary dictionary;

	Logger logger;
	
	@Inject
	public void initLogger(Logger logger) {
		this.logger = logger;
	}

	public String translate(String text) {

		if (text == null)
			throw new NullPointerException();

		String[] tokens = (text.split(TestConstants.SEPARATOR));

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < tokens.length; i++) {
			result.append(dictionary.lookup(tokens[i]));
			if (i < (tokens.length - 1))
				result.append(TestConstants.SEPARATOR);
		}

		logger.log("Translation finished");

		return result.toString();
	}

}
