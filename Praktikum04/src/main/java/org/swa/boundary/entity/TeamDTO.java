package org.swa.boundary.entity;

public class TeamDTO {
    private String name;
    private String category;

    public TeamDTO(){}

    public TeamDTO(String name, String category){
        setName(name);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}
