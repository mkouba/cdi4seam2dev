package org.jboss.devconf.cdi4seam2dev.seam2.domain;

import java.util.Map;
import java.util.TreeMap;

import org.jboss.devconf.cdi4seam2dev.util.Logger;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Seam component with name "dictionary" living in EVENT context.
 */
@Name("dictionary")
@Scope(ScopeType.EVENT)
public class Dictionary {
	
	@In
	private Logger logger;

	private Map<String, String> data;

	@Create
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
