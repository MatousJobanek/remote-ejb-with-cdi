package org.jboss.weld.remote.ejb.with.cdi.server.test;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;
import org.junit.Assert;

@Stateless
public class StatelessBeanForTransaction {


    @Inject
    private TransactionalEventStatelessRemote transactions;

    public void testTransactionalEvents() throws Exception {


//      TransactionalEventStatelessRemote transactions = (TransactionalEventStatelessRemote) Utils.lookupRemoteStatelessCalculator(
//          "TransactionalEventStatelessBean", TransactionalEventStatelessRemote.class.getName());

      Assert.assertNotNull(transactions);
      transactions.fireInTransaction();
      List<TransactionPhase> ranPhasesList = transactions.getRanPhasesList();
      System.err.println(ranPhasesList.size());

      transactions.fireAndFailInTransaction();
      System.err.println(transactions.getRanPhasesList());

      Thread.sleep(1000);

//      context.setRollbackOnly();

//      event.fire(eventInTransaction);
  }

}
