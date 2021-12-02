package org.swa.assignments.bl;

import org.swa.boundary.entity.AssignmentDTO;

import java.util.Collection;

public interface AssignmentCatalog {
    Collection<AssignmentEntity> getAssignments();
    AssignmentEntity getAssignment(long id);
    void presistAssignment(AssignmentEntity assignmentEntity);
    boolean deleteAssignmen(long id);

}
