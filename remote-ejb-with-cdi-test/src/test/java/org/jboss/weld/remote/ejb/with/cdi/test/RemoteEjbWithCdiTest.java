package org.jboss.weld.remote.ejb.with.cdi.test;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;

public class RemoteEjbWithCdiTest {

    @Produces @Resource(lookup="ejb:/remote-ejb-with-cdi-server-side/TransactionalEventStatelessBean!org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote")
    TransactionalEventStatelessRemote transactionalEventStatelessRemote;

}
