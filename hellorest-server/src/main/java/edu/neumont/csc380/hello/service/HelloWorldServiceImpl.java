package edu.neumont.csc380.hello.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService, ImageService, VideoService {
	public String sayHello(String name) {
		return "Howdy, " + name + "!";
	}
	
	private Map<Long, Image> images = new HashMap<Long, Image>();
	private Map<Long, Video> videos = new HashMap<Long, Video>();
	private Long sequenceId = 1L;
	
	public Response getImage(Long id)
	{
		Image i = images.get(id);
		if(i == null)
		{
			return Response.status(404).build();
		}
		else
		{
			return Response.ok(i).build();
		}
	}
	
	public Response getVideo(Long id)
	{
		Video v = videos.get(id);
		if(v == null)
		{
			return Response.status(404).build();
		}
		else
		{
			return Response.ok(v).build();
		}
	}
	
	public Response updateImage(Long id, Image image)
	{
		Image i = images.put(id, image);
		return Response.ok(i).build();
	}
	
	public Response updateVideo(Long id, Video video)
	{
		Video v = videos.put(id,  video);
		return Response.ok(v).build();
	}
	
	public Response createImage(Image image)
	{
		image.setId(sequenceId++);
		images.put(image.getId(), image);
		return Response.status(201).entity(image).build();
	}
	
	public Response createVideo(Video video)
	{
		video.setId(sequenceId++);
		videos.put(video.getId(), video);
		return Response.status(201).entity(video).build();
	}
	
	public Response deleteImage(Long id)
	{
		images.remove(id);
		return Response.status(204).build();
	}
	
	public Response deleteVideo(Long id)
	{
		videos.remove(id);
		return Response.status(204).build();
	}
}
