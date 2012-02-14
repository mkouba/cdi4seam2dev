package org.jboss.devconf.cdi4seam2dev.util;

public class Logger {

	public Logger() {
	}

	public void log(String text) {
		if(TestConstants.LOG_ENABLED)
			System.out.println("> " + text);
	}

}
