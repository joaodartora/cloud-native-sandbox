package com.joaodartora.guice.configuration;

import com.google.inject.AbstractModule;
import com.joaodartora.guice.app.History;
import com.joaodartora.guice.app.Store;

public class AppModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Store.class);
		bind(History.class);
	}
}
