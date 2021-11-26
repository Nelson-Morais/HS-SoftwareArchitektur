package org.swa.boundary.entity;

import java.util.List;

public class RelationshipsDTO {

    private PersonDTO manager;
    private List<PersonDTO> players;

    public RelationshipsDTO(){}

    public RelationshipsDTO(PersonDTO manager, List<PersonDTO> players){
        setManager(manager);
        setPlayers(players);
    }

    public List<PersonDTO> getPlayers() {
        return players;
    }

    public PersonDTO getManager() {
        return manager;
    }

    public void setPlayers(List<PersonDTO> players) {
        this.players = players;
    }

    public void setManager(PersonDTO manager) {
        this.manager = manager;
    }
}
