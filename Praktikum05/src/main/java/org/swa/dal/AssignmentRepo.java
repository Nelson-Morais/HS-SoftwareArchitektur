package org.swa.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;
import org.swa.assignments.bl.AssignmentCatalog;
import org.swa.assignments.bl.AssignmentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class AssignmentRepo implements AssignmentCatalog, PanacheRepository<AssignmentEntity> {

    @Override
    public Collection<AssignmentEntity> getAssignments(){
        Log.info("AssignmentRepo getAssignments()");
        return listAll();
    }

    @Override
    public AssignmentEntity getAssignment(long id) {
        Log.info("AssignmentRepo getAssignment()");
        return findById(id);
    }


    @Transactional(Transactional.TxType.MANDATORY)
    @Override
    public void presistAssignment(@Observes AssignmentEntity assignmentEntity) {
        Log.info("AssignmentRepo presistAssignment()");
        persist(assignmentEntity);
    }

    @Transactional(Transactional.TxType.MANDATORY)
    @Override
    public boolean deleteAssignmen(long id) {
        Log.info("AssignmentRepo deleteAssignment()");
        return deleteById(id);
    }
}
