package org.swa.bl;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;


public interface TeamsCatalog {

    Map<Integer,Team> listTeams();
    Team getTeam(int id);
    Team getTeam(String name);
    void addTeam(int id, Team team);
    boolean editTeam(int id, Team oldTeam, Team newTeam);
    boolean deleteTeam(int id);

}
