package edu.neumont.csc380.hello.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
@Consumes("application/json")
@Produces("application/json")
public interface HelloWorldService {
	@GET
	@Path("/{id}")
	@Produces("application/json")
	Response getGreeting(@PathParam("id") Long id);
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	Response updateGreeting(@PathParam("id") Long id, Greeting greeting);
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	Response createGreeting(Greeting greeting);
	
	@DELETE
	@Path("/{id}")
	Response deleteGreeting(@PathParam("id") Long id);
}
