package edu.neumont.csc380.hello.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
	private Map<Long, Greeting> greetings = new HashMap<Long, Greeting>();
	private Long sequenceId = 1L;
	
	public Response getGreeting(Long id) {
		Greeting g = greetings.get(id);
		if ( g == null ) {
			return Response.status(404).build();
		} else {
			return Response.ok(g).build();
		}
	}

	public Response updateGreeting(Long id, Greeting greeting) {
		Greeting g = greetings.put(id, greeting);
		return Response.ok(g).build();
	}

	public Response createGreeting(Greeting greeting) {
		greeting.setId(sequenceId++);
		greetings.put(greeting.getId(), greeting);
		return Response.status(201).entity(greeting).build();
	}

	public Response deleteGreeting(Long id) {
		greetings.remove(id);
		return Response.status(204).build();
	}
}
