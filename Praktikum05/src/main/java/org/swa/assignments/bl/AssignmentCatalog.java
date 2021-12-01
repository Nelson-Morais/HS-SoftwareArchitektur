package org.swa.assignments.bl;

import org.swa.boundary.entity.AssignmentDTO;

public interface AssignmentCatalog {

    AssignmentEntity getAssignment(int id);
    void createAssignment(AssignmentEntity assignmentEntity);
    void editAssignment(AssignmentEntity assignmentEntity);
    void deleteAssignmen(int id);

}
