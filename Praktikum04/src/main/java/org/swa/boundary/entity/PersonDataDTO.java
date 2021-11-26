package org.swa.boundary.entity;


import javax.ws.rs.core.Link;
import java.util.Map;

public class PersonDataDTO {

    private PersonDTO data;
    private Map<String, Link> links;


    public PersonDataDTO(){}

    public PersonDataDTO(PersonDTO data, Map<String, Link> links){
        setData(data);
        setLinks(links);
    }

    public Map<String, Link> getLinks() {
        return links;
    }

    public PersonDTO getData() {
        return data;
    }

    public void setData(PersonDTO data) {
        this.data = data;
    }

    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }
}
