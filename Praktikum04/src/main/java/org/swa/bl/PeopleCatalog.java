package org.swa.bl;

import java.util.Map;

public interface PeopleCatalog {

    Map<Integer, Person> listPeople();
    Person getPerson(int id);
    Person getPerson(String name);
    void addPerson(int id, Person person);
    boolean editPerson(int id,Person oldPerson, Person newPerson);
    boolean deletePerson(int id);

}
