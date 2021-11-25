package org.swa.dal;

import org.swa.bl.PeopleCatalog;
import org.swa.bl.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PeopleRepository implements PeopleCatalog {

    Map<Integer, Person> people = new ConcurrentHashMap<>();


    @Override
    public Map<Integer, Person> listPeople() {
        return people;
    }

    @Override
    public Person getPerson(int id) {
        return people.get(id);
    }

    @Override
    public Person getPerson(String name) {
        for( Person el : people.values()){
            if(el.getName().equals(name)){
                return el;
            }
        }
        return null;
    }

    @Override
    public void addPerson(int id, Person person) {
        people.put(id, person);
    }

    @Override
    public boolean editPerson(int id,Person oldPerson, Person newPerson) {
        return people.replace(id, oldPerson, newPerson);
    }

    @Override
    public boolean deletePerson(int id) {
        return people.remove(id) != null;
    }
}
