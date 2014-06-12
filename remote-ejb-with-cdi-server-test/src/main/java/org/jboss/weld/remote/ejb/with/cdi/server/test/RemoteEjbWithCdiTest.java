package org.jboss.weld.remote.ejb.with.cdi.server.test;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;
import org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction.EventInTransaction;


public class RemoteEjbWithCdiTest {

    // @EJB(lookup="java:global/remote-ejb-with-cdi-server-side/TransactionalEventStatelessBean!org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction.TransactionalEventStatelessRemote")

    @Produces
    @Resource(lookup="ejb:/remote-ejb-with-cdi-server-side/TransactionalEventStatelessRemoteImpl!org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote")
//    @EJB(lookup = "corbaname:iiop:localhost:3528#remote-ejb-with-cdi-server-side/transactionalEventStatelessRemoteImpl")
    TransactionalEventStatelessRemote transactionalEventStatelessRemote;

    @Produces
    @Resource(lookup="ejb:/remote-ejb-with-cdi-server-side/EventInTransactionImpl!org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction.EventInTransaction")
    EventInTransaction eventInTransaction;

    // @Produces
    // TransactionalEventStatelessRemote transactionalEventStatelessRemote = (TransactionalEventStatelessRemote)
    // Utils.lookupRemoteStatelessCalculator(
    // "TransactionalEventStatelessBean", TransactionalEventStatelessRemote.class.getName());

    // @Produces
    // @EJB(lookup="ejb:/remote-ejb-with-cdi-server-side/TransactionalEventStatelessBean!org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction.TransactionalEventStatelessRemote")
    // @Produces
//    public TransactionalEventStatelessRemote transactionalEventStatelessRemote() throws Exception {
//        TransactionalEventStatelessRemote transactions = (TransactionalEventStatelessRemote) Utils
//            .lookupRemoteStatelessCalculator(
//                "TransactionalEventStatelessRemoteImpl", TransactionalEventStatelessRemote.class.getName());
//        return transactions;
//    }

}
