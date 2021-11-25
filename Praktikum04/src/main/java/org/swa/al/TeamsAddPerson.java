package org.swa.al;

import org.swa.boundary.entity.PersonDTO;
import org.swa.boundary.entity.TeamDTO;

public interface TeamsAddPerson {

    TeamDTO addCoach(int teamId, PersonDTO coach);
    boolean deleteCoach(int teamId);
    TeamDTO addPlayer(int teamId, PersonDTO player);
    boolean deletePlayer(int teamId, int playerId);

}
