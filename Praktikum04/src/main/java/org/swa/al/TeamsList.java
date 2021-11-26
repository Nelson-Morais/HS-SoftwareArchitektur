package org.swa.al;

import org.swa.boundary.entity.FinalDTO;
import org.swa.boundary.entity.TeamDTO;

public interface TeamsList {

    FinalDTO getTeams();
    TeamDTO getTeam(int id);
    TeamDTO getTeam(String name);

}
