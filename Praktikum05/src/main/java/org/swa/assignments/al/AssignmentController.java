package org.swa.assignments.al;

import org.swa.boundary.entity.AssignmentDTO;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AssignmentController implements AddAssignment, ListAssignment, ModifyAssignment{


    @Override
    public void createAssignment(AssignmentDTO assignmentDTO) {

    }

    @Override
    public void getAssignment(int id) {

    }

    @Override
    public void editAssignment(AssignmentDTO assignmentDTO) {

    }

    @Override
    public boolean deleteAssignment(int id) {
        return false;
    }
}
