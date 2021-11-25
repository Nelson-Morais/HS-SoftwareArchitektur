package org.swa.bl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Team {
    private int id;
    private String name;
    private String category;
    private Person coach;
    private Map<Integer,Person> players;


    public Team(){}

    public Team(int id, String name, String category){
        this.id = id;
        this.name = name;
        this.category = category;
        this.coach = null;
        players = new ConcurrentHashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Person getCoach() {
        return coach;
    }

    public Map<Integer,Person> getPlayers() {
        return players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

    public void setId(int id) {
        this.id = id;
    }
}



