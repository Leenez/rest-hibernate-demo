package com.demos.rest_hibernate_demo;

import dao.Hibernate;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import models.Publisher;


@Path("library")
public class LibraryResource {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Publisher getPublisherInfo(@FormParam("publisher-id") int identifier) {
		return (Publisher) Hibernate.getPublisher(identifier);
	}
}
