package org.swa.al;

import org.swa.boundary.entity.PersonDTO;

public interface PersonsList {

    PersonDTO getPeople();
    PersonDTO getPerson(int id);
    PersonDTO getPerson(String name);

}
