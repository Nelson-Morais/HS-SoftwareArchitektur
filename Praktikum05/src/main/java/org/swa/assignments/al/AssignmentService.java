package org.swa.assignments.al;

import io.quarkus.logging.Log;
import org.swa.assignments.bl.AssignmentEntity;
import org.swa.boundary.entity.AssignmentDTO;
import org.swa.dal.AssignmentRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class AssignmentService {

    @Inject
    Event<AssignmentEntity> assignmentEntityEvent;

    @Inject
    AssignmentRepo assignmentRepo;


    public Collection<AssignmentDTO> getAssignments(){
        List<AssignmentDTO> assignments = new ArrayList<>();
        for(AssignmentEntity el : assignmentRepo.getAssignments()){
            assignments.add(AssignmentDTO.AssignmentDTOConverter.toDTO(el));
        }
        return assignments;
    }

    @Transactional
    public void createAssignment(AssignmentDTO assignmentDTO) {
        AssignmentEntity assignmentEntity = AssignmentDTO.AssignmentDTOConverter.toAssignment(assignmentDTO);
        Log.info(assignmentEntity.getDescription());
        assignmentEntityEvent.fire(assignmentEntity);
    }


    public AssignmentDTO getAssignment(long id) {
        Log.info("AssignmentService getAssignment()");
        if(assignmentRepo.getAssignment(id) != null){
            return AssignmentDTO.AssignmentDTOConverter.toDTO(assignmentRepo.getAssignment(id));
        }
        return null;
    }

    @Transactional
    public void editAssignment(AssignmentDTO assignmentDTO) {

        AssignmentEntity assignmentEntity = assignmentRepo.getAssignment(assignmentDTO.getId());
        if(!assignmentEntity.getDescription().equals(assignmentDTO.getDescription())){
            assignmentEntity.setDescription(assignmentDTO.getDescription());

        }
        if(assignmentEntity.getShip() != assignmentDTO.getShip()){
            assignmentEntity.setShip(assignmentDTO.getShip());
        }
        assignmentEntityEvent.fire(assignmentEntity);
    }

    @Transactional
    public boolean deleteAssignment(long id) {
        return assignmentRepo.deleteAssignmen(id);
    }
}
