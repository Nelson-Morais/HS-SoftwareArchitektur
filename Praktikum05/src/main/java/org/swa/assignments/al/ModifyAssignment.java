package org.swa.assignments.al;

import org.swa.boundary.entity.AssignmentDTO;

public interface ModifyAssignment {

    void editAssignment(AssignmentDTO assignmentDTO);
    boolean deleteAssignment(int id);

}
