package org.swa.al;

import org.swa.boundary.entity.TeamDTO;

public interface TeamsEdit {

    TeamDTO editTeam(int teamId, TeamDTO team);
    boolean deleteTeam(int teamId);

}
