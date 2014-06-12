package org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.enterprise.event.Event;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;

//@RemoteHome(TransactionalEventStatelessHomeRemote.class)
@Remote(TransactionalEventStatelessRemote.class)
@TransactionManagement//(TransactionManagementType.BEAN)
@Stateless
public class TransactionalEventStatelessRemoteImpl implements TransactionalEventStatelessRemote {

//    @Resource
//    private UserTransaction userTransaction;

    @Inject
    private Event<EventInTransaction> event;

    @Inject
    private ObserveTransactionalEvent observer;

    public void fireInTransaction() throws Exception {
//        userTransaction.begin();
        event.fire(new EventInTransactionImpl());
//        userTransaction.commit();
    }

    public void fireAndFailInTransaction() throws Exception {
//        userTransaction.begin();
        event.fire(new EventInTransactionImpl());
//        userTransaction.rollback();
    }

    public List<TransactionPhase> getRanPhasesList(){
        return observer.getRanPhases();
    }

//    public void throwException() throws Exception {
//        throw new
//    }


}
