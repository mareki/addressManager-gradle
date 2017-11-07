package com.acme.am.testsupport;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class DummyLogger extends Logger {

	public DummyLogger() {
		super("Dummy");
		setLevel(Level.DEBUG);
	}

	// Eclipse thinks DummyLogger is a CDI injectable class otherwise
	public static Logger createInstance() {
		return new DummyLogger() {
			// NOP

			public void debug(Object message) {
				System.out.println("DummyLogger: " + message);
			}
		};
	}

}
