package org.swa.boundary.rest;

import org.swa.al.TeamController;
import org.swa.boundary.entity.FinalDTO;
import org.swa.boundary.entity.TeamDataDTO;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Collection;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TeamsResource {


    @Inject
    TeamController controller;

    @GET
    public Response getTeams(){
        FinalDTO obj = controller.getTeams();
        return Response.ok(obj).build();

    }

    @POST
    public Response addTeam(FinalDTO dto){

        controller.addTeam(dto);
        return Response.ok().build();
    }



}
