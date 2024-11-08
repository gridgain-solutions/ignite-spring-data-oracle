package org.gridgain.demo.springdata;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.lifecycle.LifecycleAware;

public class IgniteServer implements LifecycleAware {
	private static Ignite ignite;

	public static void main(String[] args) {
		//System.setProperty("IGNITE_QUIET", "true");
		//System.setProperty("java.net.preferIPv4Stack", "true");
		new IgniteServer().start();
	}

	@Override
	public void start() throws IgniteException {
		try {
			ignite = Ignition.start("src/main/resources/server-config.xml");
		} catch (Exception e) {
			throw new IgniteException(e);
		}
	}

	@Override
	public void stop() throws IgniteException {
		ignite.close();
	}
}
