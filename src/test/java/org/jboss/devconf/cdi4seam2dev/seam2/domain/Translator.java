package org.jboss.devconf.cdi4seam2dev.seam2.domain;

import org.jboss.devconf.cdi4seam2dev.util.Logger;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Seam component with name "translator" living in EVENT context.
 */
@Name("translator")
@Scope(ScopeType.EVENT)
public class Translator {

	/*
	 * Inject component with name "dictionary"; instantiate new if the context
	 * variable is null
	 */
	@In(create = true)
	Dictionary dictionary;

	Logger logger;

	/*
	 * Setter method injection - inject component with name "logger". Throw an
	 * exception if no such component exists.
	 */
	@In
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * @param text
	 * @param log
	 * @return translated text
	 */
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
