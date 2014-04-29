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


@Path("/video")
public interface VideoService {

	@GET
	@Path("/{id}")
	@Produces({"video/quicktime", "video/avi", "video/mp4"})
	Response getVideo(@PathParam("id") Long id);
	
	@PUT
	@Path("/{id}")
	@Consumes({"multipart/mixed"})
//	@Consumes({"video/quicktime", "video/avi", "video/mp4"})
	@Produces("application/json")
	Response updateVideo(@PathParam("id") Long id, Video video);
	
	@POST
	@Consumes({"multipart/mixed"})
//	@Consumes({"video/quicktime", "video/avi", "video/mp4"})
	@Produces("application/json")
	Response createVideo(Video video);
	
	@DELETE
	@Path("/{id}")
	Response deleteVideo(@PathParam("id") Long id);

}
