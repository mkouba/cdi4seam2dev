package org.jboss.devconf.cdi4seam2dev.util;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public final class HeapUtil {

	public static final long MEGABYTE = 1048576;

	private HeapUtil() {
	}
	
	public static void logHeapStatus() {

		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

		System.out.println(String.format(
				"Heap: %sM used, %sM commited, %sM max", memoryMXBean
						.getHeapMemoryUsage().getUsed() / MEGABYTE,
				memoryMXBean.getHeapMemoryUsage().getCommitted() / MEGABYTE,
				memoryMXBean.getHeapMemoryUsage().getMax() / MEGABYTE));
	}
}
