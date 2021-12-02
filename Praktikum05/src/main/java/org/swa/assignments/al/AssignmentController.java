package org.swa.assignments.al;

import io.quarkus.logging.Log;
import org.swa.assignments.bl.AssignmentEntity;
import org.swa.boundary.entity.AssignmentDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class AssignmentController implements AddAssignment, ListAssignment, ModifyAssignment{


    @Inject
    AssignmentService assignmentService;



    @Override
    public Collection<AssignmentDTO> getAssignments() {
        Log.info("AssignmentService getAssignments()");
        return assignmentService.getAssignments();
    }

    @Override
    public void createAssignment(AssignmentDTO assignmentDTO) {
        Log.info("AssignmentService createAssignment()");
        assignmentService.createAssignment(assignmentDTO);
    }

    @Override
    public AssignmentDTO getAssignment(long id) {
        Log.info("AssignmentController getAssignment()");
       return assignmentService.getAssignment(id);
    }

    @Override
    public void editAssignment(AssignmentDTO assignmentDTO) {
        Log.info("AssignmentService editAssignments()");
        assignmentService.editAssignment(assignmentDTO);
    }

    @Override
    public boolean deleteAssignment(long id) {
        Log.info("AssignmentService deleteAssignments()");
        return assignmentService.deleteAssignment(id);
    }
}
