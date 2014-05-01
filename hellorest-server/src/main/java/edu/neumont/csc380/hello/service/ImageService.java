package edu.neumont.csc380.hello.service;

<<<<<<< HEAD
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
=======
import java.io.File;

>>>>>>> 6426a5f3f3d828697b58b88e97aa5dbbc9eab824
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;


@Path("/image")
@PermitAll
public interface ImageService {

	@GET
	@Path("/{id")
	@Produces("multipart/mixed")
	Response getImage(@PathParam("id") Long id);
	
	@PUT
	@Path("/{id}")
<<<<<<< HEAD
	@RolesAllowed("ImageOwner")
	@Consumes({"multipart/mixed"})
//	@Consumes({"image/jpg", "image/png"})
=======
	@Consumes("multipart/mixed")
>>>>>>> 6426a5f3f3d828697b58b88e97aa5dbbc9eab824
	@Produces("application/json")
	Response updateImage(@PathParam("id") Long id, @Multipart(value = "imageData") Image imageData, @Multipart(value = "imageFile") File imageFile);
	
	@POST
	@Consumes("multipart/mixed")
	@Produces("application/json")
	Response createImage(@Multipart(value = "imageData") Image imageData, @Multipart(value = "imageFile") File imageFile);
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed("ImageOwner")
	Response deleteImage(@PathParam("id") Long id);

}
