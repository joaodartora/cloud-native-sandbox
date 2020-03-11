package com.joaodartora.guicepoc.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.joaodartora.guicepoc.configuration.AppModule;
import com.joaodartora.guicepoc.services.Bath;
import com.joaodartora.guicepoc.services.Haircut;

public class Main {

	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new AppModule());
		Store store = injector.getInstance(Store.class);
		Bath bath = injector.getInstance(Bath.class);
		Haircut haircut = injector.getInstance(Haircut.class);
		History history = injector.getInstance(History.class);
		Menu menu = new Menu(store, bath, haircut, history);
		menu.generateMenu();
	}
}
