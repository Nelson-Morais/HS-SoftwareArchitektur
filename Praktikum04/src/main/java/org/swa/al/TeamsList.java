package org.swa.al;

import org.swa.boundary.entity.TeamDTO;

public interface TeamsList {

    TeamDTO getTeams();
    TeamDTO getTeam(int id);
    TeamDTO getTeam(String name);

}
