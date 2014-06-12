package org.jboss.weld.remote.ejb.with.cdi.server.test;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;
import org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction.EventInTransaction;
import org.jboss.weld.remote.ejb.with.cdi.test.Utils;

@Path("/test")
@RequestScoped
public class TestEventInTransactionBean {


    @Inject
    StatelessBeanForTransaction beanForTransaction;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String runMainTestSuite() throws Exception{

//        ArquillianTest arquillianTest = new ArquillianTest();
//        arquillianTest.testSipleEjb();
//        arquillianTest.testEjbWithInjections();
//        arquillianTest.testEjbWithEvents();
        beanForTransaction.testTransactionalEvents();

        Utils.getContext().close();
        return "OK";
    }

    @Inject
    private TransactionalEventStatelessRemote transactions;

    @Inject
    private EventInTransaction eventInTransaction;

    @Inject
    private Event<EventInTransaction> event;

//    @Resource
//    private EJBContext context;



}
