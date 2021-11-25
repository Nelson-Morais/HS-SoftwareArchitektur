package org.swa.id;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;


@ApplicationScoped
@Team
public class IdGeneratorTeam implements IdGeneration{

    private static final AtomicInteger uniqueID = new AtomicInteger();

    @Override
    public int generateId() {
        return uniqueID.incrementAndGet();
    }


}
