package org.jboss.devconf.cdi4seam2dev.cdi.domain;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.jboss.devconf.cdi4seam2dev.util.Logger;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;

/**
 * Request scoped CDI component.
 */
@RequestScoped
public class Dictionary {

	@Inject
	private Logger logger;

	private Map<String, String> data;

	@PostConstruct
	public void init() {
		data = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		data.put("toto", "this");
		data.put("je", "is");
		data.put("test", "the test");
		data.put("jdi", "go");
	}

	public String lookup(String key) {
		logger.log("Performing lookup");
		return data.containsKey(key) ? data.get(key) : TestConstants.NOT_AVAILABLE;
	}

}
