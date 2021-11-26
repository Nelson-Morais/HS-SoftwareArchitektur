package org.swa.dal;

import org.swa.bl.Team;
import org.swa.bl.TeamsCatalog;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ApplicationScoped
public class TeamsRepository implements TeamsCatalog {

    Map<Integer, Team> teams = new ConcurrentHashMap<>();



    public TeamsRepository(){

    }



    @Override
    public Map<Integer,Team> listTeams() {
        return teams;
    }

    @Override
    public Team getTeam(int id) {
        return teams.get(id);
    }

    @Override
    public Team getTeam(String name) {
        for(Team el : teams.values()){
            if( el.getName().equals(name)){
                return el;
            }
        }
        return null;
    }

    @Override
    public void addTeam(int id, Team team) {
        teams.put(id,team);
    }

    @Override
    public boolean editTeam(int id,Team oldTeam ,Team newTeam) {
       return teams.replace(id,oldTeam,newTeam);
    }

    @Override
    public boolean deleteTeam(int id) {
        return teams.remove(id) != null;
    }
}
