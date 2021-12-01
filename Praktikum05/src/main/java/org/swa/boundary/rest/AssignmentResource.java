package org.swa.boundary.rest;


import org.swa.boundary.entity.AssignmentDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/assignments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssignmentResource {


    @GET
    @Path("{id}")
    public Response getAssignment(int id){

        return Response.ok().build();
    }

    @POST
    public Response createAssignment(AssignmentDTO assignmentDTO){

        return Response.ok().build();
    }

    @PUT
    public Response editAssignment(AssignmentDTO assignmentDTO){

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAssignment(int id){

        return Response.ok().build();
    }



}
