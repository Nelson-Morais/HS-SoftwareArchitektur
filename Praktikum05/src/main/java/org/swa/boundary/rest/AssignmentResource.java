package org.swa.boundary.rest;




import io.quarkus.logging.Log;
import org.swa.assignments.al.AssignmentController;
import org.swa.assignments.bl.AssignmentEntity;
import org.swa.boundary.entity.AssignmentDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/assignments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssignmentResource {



    @Inject
    AssignmentController assignmentController;

    @GET
    public Response listAssignments(){
        return Response.ok().entity(assignmentController.getAssignments()).build();
    }

    @GET
    @Path("{id}")
    public Response getAssignment(@PathParam("id")final long id){
        Log.info("AssignmentResource GET /{id}");
        if(assignmentController.getAssignment(id) != null){

            return Response.ok().entity(assignmentController.getAssignment(id)).build();
        }
        return Response.noContent().build();
    }

    @POST
    public Response createAssignment(AssignmentDTO assignmentDTO){
        assignmentController.createAssignment(assignmentDTO);
        return Response.ok().build();
    }

    @PUT
    public Response editAssignment(AssignmentDTO assignmentDTO){
        assignmentController.editAssignment(assignmentDTO);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAssignment(@PathParam("id") long id){
        if(assignmentController.deleteAssignment(id)){

            return Response.ok().build();
        }

        return Response.notModified().build();
    }



}
