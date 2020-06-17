package com.demos.rest_hibernate_demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.Hibernate;

@WebListener
public class StartupListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Server starting");
		System.out.println("Creating database tables");
		Hibernate h = new Hibernate();
		h.createDemoMySQLDb();
		System.out.println("Created database tables");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Server stopping");
	}
}
