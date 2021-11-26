package org.swa.boundary.entity;

public class PersonDTO {

    private String name;

    public PersonDTO() {}

    public PersonDTO(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
