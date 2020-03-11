package com.joaodartora.guicepoc.configuration;

import com.google.inject.AbstractModule;
import com.joaodartora.guicepoc.app.History;
import com.joaodartora.guicepoc.app.Store;

public class AppModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Store.class);
		bind(History.class);
	}
}
