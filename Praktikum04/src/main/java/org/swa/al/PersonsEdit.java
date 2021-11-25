package org.swa.al;

import org.swa.boundary.entity.PersonDTO;

public interface PersonsEdit {

    PersonDTO editPerson(PersonDTO team);
    boolean deletePerson(int id);

}
