package org.swa.al;

import org.swa.bl.Team;
import org.swa.bl.TeamsCatalog;
import org.swa.boundary.entity.TeamDTO;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;


public class TeamService {

    @Inject
    TeamsCatalog teamsCatalog;


    Collection<TeamDTO> getTeams(){
       return teamsCatalog.listTeams();

    }

}
