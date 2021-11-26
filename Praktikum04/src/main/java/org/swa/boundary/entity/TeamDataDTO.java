package org.swa.boundary.entity;


import org.swa.bl.Team;

import javax.ws.rs.core.Link;
import java.util.HashMap;
import java.util.Map;

public class TeamDataDTO {

    private int id;
    private String type;
    private TeamDTO attributes;
    private RelationshipsDTO relationships;
    Map<String, Link> links = new HashMap<>();


    public TeamDataDTO(){}

    public TeamDataDTO(int id, String type, TeamDTO attributes, RelationshipsDTO relationships){
        setId(id);
        setType(type);
        setAttributes(attributes);
        setRelationships(relationships);

    }

    public Map<String, Link> getLinks() {
        return links;
    }

    public int getId() {
        return id;
    }

    public RelationshipsDTO getRelationships() {
        return relationships;
    }

    public String getType() {
        return type;
    }

    public TeamDTO getAttributes() {
        return attributes;
    }

    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAttributes(TeamDTO attributes) {
        this.attributes = attributes;
    }

    public void setRelationships(RelationshipsDTO relationships) {
        this.relationships = relationships;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class TeamDataDTOConverter{

        public static TeamDataDTO toDTO(Team team){

            return new TeamDataDTO(team.getId(), "teams", new TeamDTO(team.getName(), team.getCategory()), null);
        }

        public static Team toTeam(TeamDataDTO teamDataDTO){

            return new Team(teamDataDTO.getAttributes().getName(), teamDataDTO.getAttributes().getCategory());
        }


    }


}
