package org.swa.assignments.al;

import org.swa.assignments.bl.AssignmentEntity;
import org.swa.boundary.entity.AssignmentDTO;

import java.util.Collection;

public interface ListAssignment {

    Collection<AssignmentDTO> getAssignments();
    AssignmentDTO getAssignment(long id);
}
