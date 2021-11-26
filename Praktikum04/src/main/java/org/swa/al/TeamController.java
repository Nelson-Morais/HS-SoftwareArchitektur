package org.swa.al;


import org.swa.bl.Team;
import org.swa.bl.TeamsCatalog;
import org.swa.boundary.entity.FinalDTO;
import org.swa.boundary.entity.PersonDTO;
import org.swa.boundary.entity.TeamDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;

@ApplicationScoped
public class TeamController implements TeamsList, TeamsSubmit, TeamsEdit, TeamsAddPerson {

    @Inject
    TeamService teamService;

    @Override
    public FinalDTO getTeams() {
        return teamService.getTeams();
    }


    @Override
    public TeamDTO getTeam(int id) {
        return null;
    }

    @Override
    public TeamDTO getTeam(String name) {
        return null;
    }

    @Override
    public FinalDTO addTeam(FinalDTO finalDTO) {

        return teamService.addTeam(finalDTO);
    }

    @Override
    public TeamDTO editTeam(int teamId, TeamDTO team) {
        return null;
    }

    @Override
    public boolean deleteTeam(int teamId) {
        return false;
    }

    @Override
    public TeamDTO addCoach(int teamId, PersonDTO coach) {
        return null;
    }

    @Override
    public boolean deleteCoach(int teamId) {
        return false;
    }

    @Override
    public TeamDTO addPlayer(int teamId, PersonDTO player) {
        return null;
    }

    @Override
    public boolean deletePlayer(int teamId, int playerId) {
        return false;
    }
}