package org.swa.al;

import org.swa.bl.Team;
import org.swa.bl.TeamsCatalog;
import org.swa.boundary.entity.FinalDTO;
import org.swa.boundary.entity.TeamDataDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class TeamService {

    @Inject
    TeamsCatalog teamsCatalog;


    public FinalDTO getTeams(){

        FinalDTO obj = new FinalDTO();
        for (Team el : teamsCatalog.listTeams().values()){
            obj.getData().add(TeamDataDTO.TeamDataDTOConverter.toDTO(el));
        }


       return obj;

    }

    public FinalDTO addTeam(FinalDTO finalDTO){
        teamsCatalog.addTeam(0, TeamDataDTO.TeamDataDTOConverter.toTeam(finalDTO.getData().get(0)));
        FinalDTO obj = new FinalDTO();
        obj.getData().add(TeamDataDTO.TeamDataDTOConverter.toDTO(teamsCatalog.getTeam(0)));
        return obj;
    }

}
