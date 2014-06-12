package org.jboss.weld.remote.ejb.with.cdi.server.side;

import java.util.List;

import javax.enterprise.event.TransactionPhase;

public interface TransactionalEventStatelessRemote {

    public void fireInTransaction() throws Exception;

    public void fireAndFailInTransaction() throws Exception;

    public List<TransactionPhase> getRanPhasesList();
}
