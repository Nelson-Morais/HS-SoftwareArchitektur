package org.swa.boundary.rest;

import org.swa.al.TeamController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

        return Response.ok().build();

    }



}
