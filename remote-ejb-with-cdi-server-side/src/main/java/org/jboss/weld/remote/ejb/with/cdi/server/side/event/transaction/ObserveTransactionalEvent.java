package org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction;

import static javax.enterprise.event.TransactionPhase.AFTER_COMPLETION;
import static javax.enterprise.event.TransactionPhase.AFTER_FAILURE;
import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;
import static javax.enterprise.event.TransactionPhase.BEFORE_COMPLETION;
import static javax.enterprise.event.TransactionPhase.IN_PROGRESS;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;

@ApplicationScoped
public class ObserveTransactionalEvent {

    private List<TransactionPhase> ranPhases = new ArrayList<TransactionPhase>();

    public void observeEvent(@Observes EventInTransaction event) {
        System.err.println("EventInTransaction event fired");
    }

    public void inProgressMemoryEvent(@Observes(during = IN_PROGRESS) EventInTransaction event) {
        System.err.println("EventInTransaction IN_PROGRESS");
        ranPhases.add(IN_PROGRESS);
    }

    public void afterCompletitionMemoryEvent(@Observes(during = AFTER_COMPLETION) EventInTransaction event) {
        System.err.println("EventInTransaction AFTER_COMPLETION");
        ranPhases.add(AFTER_COMPLETION);
    }

    public void afterFailureMemoryEvent(@Observes(during = AFTER_FAILURE) EventInTransaction event) {
        System.err.println("EventInTransaction AFTER_FAILURE");
        ranPhases.add(AFTER_FAILURE);
    }

    public void afterSuccessMemoryEvent(@Observes(during = AFTER_SUCCESS) EventInTransaction event) {
        System.err.println("EventInTransaction AFTER_SUCCESS");
        ranPhases.add(AFTER_SUCCESS);
    }

    public void beforeCompletitionMemoryEvent(@Observes(during = BEFORE_COMPLETION) EventInTransaction event) {
        System.err.println("EventInTransaction BEFORE_COMPLETION");
        ranPhases.add(BEFORE_COMPLETION);
    }

//
//


    public void inProgressMemoryEvent(@Observes(during = IN_PROGRESS) TransactionalEventStatelessRemote event) {
        System.err.println("TransactionalEventStatelessRemote IN_PROGRESS");
        ranPhases.add(IN_PROGRESS);
    }

    public void afterCompletitionMemoryEvent(@Observes(during = AFTER_COMPLETION) TransactionalEventStatelessRemote event) {
        System.err.println("TransactionalEventStatelessRemote AFTER_COMPLETION");
        ranPhases.add(AFTER_COMPLETION);
    }

    public void afterFailureMemoryEvent(@Observes(during = AFTER_FAILURE) TransactionalEventStatelessRemote event) {
        System.err.println("TransactionalEventStatelessRemote AFTER_FAILURE");
        ranPhases.add(AFTER_FAILURE);
    }

    public void afterSuccessMemoryEvent(@Observes(during = AFTER_SUCCESS) TransactionalEventStatelessRemote event) {
        System.err.println("TransactionalEventStatelessRemote AFTER_SUCCESS");
        ranPhases.add(AFTER_SUCCESS);
    }

    public void beforeCompletitionMemoryEvent(@Observes(during = BEFORE_COMPLETION) TransactionalEventStatelessRemote event) {
        System.err.println("TransactionalEventStatelessRemote BEFORE_COMPLETION");
        ranPhases.add(BEFORE_COMPLETION);
    }

    public List<TransactionPhase> getRanPhases() {
        return ranPhases;
    }
}
