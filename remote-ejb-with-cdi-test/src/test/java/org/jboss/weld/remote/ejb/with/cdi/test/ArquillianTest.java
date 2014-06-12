package org.jboss.weld.remote.ejb.with.cdi.test;

import java.util.List;

import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.naming.NamingException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.weld.remote.ejb.with.cdi.server.side.CalculatorStatelessRemote;
import org.jboss.weld.remote.ejb.with.cdi.server.side.CounterStatefulRemote;
import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@RunAsClient
public class ArquillianTest {

    protected static final String CONTAINER1 = "container1";
    protected static final String CONTAINER2 = "container2";
    protected static final String DEPLOYMENT1 = "dep.container1";
    protected static final String DEPLOYMENT2 = "dep.container2";

    @Deployment(name = DEPLOYMENT1, testable=false)
    @TargetsContainer(CONTAINER1)
    public static WebArchive createDeployment() {
        return Deployments.getWar();
    }

//    @Deployment(name = DEPLOYMENT2, managed=false, testable=true)
//    @TargetsContainer(CONTAINER2)
//    public static WebArchive createTestDeployment2() {
//       return ShrinkWrap.create(null);
//    }

//    @Inject
//    private TransactionalEventStatelessRemote transactionalEventStatelessRemote;

    @Test
    public void testSipleEjb() throws Exception {

        testStatelessBasicCalculator("CalculatorStatelessRemoteImpl");
        testStatefulCounter("CounterStatefulRemoteImpl");

    }

    @Test
    public void testEjbWithInjections() throws Exception {

        testStatelessBasicCalculator("InjectedCalculatorStatelessRemoteImpl");
        testStatefulCounter("InjectedCounterStatefulRemoteImpl");
        testStatelessAdvancedCalculator("InjectedCalculatorStatelessRemoteImpl");

    }

    @Test
    public void testEjbWithEvents() throws Exception {

        testStatefulCounter("EventCounterStatefulRemoteImpl");

    }

    @Test
    public void testTransactionalEvents() throws Exception {

        TransactionalEventStatelessRemote transactions = (TransactionalEventStatelessRemote) Utils.lookupRemoteStatelessCalculator(
            "TransactionalEventStatelessRemoteImpl", TransactionalEventStatelessRemote.class.getName());

        transactions.fireInTransaction();
        List<TransactionPhase> ranPhasesList = transactions.getRanPhasesList();
        System.err.println(ranPhasesList);

        transactions.fireAndFailInTransaction();
        System.err.println(transactions.getRanPhasesList());
    }

    @Test
    public void testRemoteTestServer() throws NamingException{
//        new HttpGet("127.0.0.1:18080/remote-ejb-with-cdi-server-test/test");
        Utils.getContext().close();
    }

    private void testStatelessBasicCalculator(String beanName) throws NamingException {

        CalculatorStatelessRemote statelessCalculator = (CalculatorStatelessRemote) Utils.lookupRemoteStatelessCalculator(beanName,
            CalculatorStatelessRemote.class.getName());

        // invoke adding on the remote calculator
        int a = 204;
        int b = 340;
        System.out.println("Adding " + a + " and " + b + " via the remote stateless calculator deployed on the server");
        int sum = statelessCalculator.add(a, b);
        System.out.println("Remote calculator returned sum = " + sum);
        Assert.assertEquals(a + b, sum);

        // invoke subtracting on the remote calculator
        int num1 = 3434;
        int num2 = 2332;
        System.out.println("Subtracting " + num2 + " from " + num1
            + " via the remote stateless calculator deployed on the server");
        int difference = statelessCalculator.subtract(num1, num2);
        System.out.println("Remote calculator returned difference = " + difference);
        Assert.assertEquals(num1 - num2, difference);

    }

    private void testStatelessAdvancedCalculator(String beanName) throws NamingException {

        CalculatorStatelessRemote statelessCalculator = (CalculatorStatelessRemote) Utils.lookupRemoteStatelessCalculator(beanName,
            CalculatorStatelessRemote.class.getName());

        // invoke multiplication on the remote calculator
        int a = 23;
        int b = 141;
        System.out.println("Multiplication " + a + " by " + b + " via the remote stateless calculator deployed on the server");
        int sum = statelessCalculator.multiply(a, b);
        System.out.println("Remote calculator returned multiple = " + sum);
        Assert.assertEquals(a * b, sum);

        // invoke division on the remote calculator
        double num1 = 3434;
        double num2 = 25;
        System.out.println("Division " + num2 + " by " + num1
            + " via the remote stateless calculator deployed on the server");
        double rate = statelessCalculator.divide(num1, num2);
        System.out.println("Remote calculator returned rate = " + rate);
        Assert.assertEquals(num1 / num2, rate, 0.001);

    }

    private void testStatefulCounter(String beanName) throws Exception {

        CounterStatefulRemote statefulCounter = Utils.lookupRemoteStatefulCounter(beanName);

        int startingValue = statefulCounter.getCount();

        // invoke incrementing on the remote counter bean
        final int INC_NUM_TIMES = 6;
        final int DEC_NUM_TIMES = 1;
        System.out.println("Counter will now be incremented " + INC_NUM_TIMES + " times");
        for (int i = 1; i <= INC_NUM_TIMES; i++) {
            statefulCounter.increment();
            Assert.assertEquals(i + startingValue, statefulCounter.getCount());
        }

        // invoke decrementing on the remote counter bean
        System.out.println("Counter will now be decremented " + DEC_NUM_TIMES + " times");
        for (int i = 1; i <= DEC_NUM_TIMES; i++) {
            statefulCounter.decrement();
            Assert.assertEquals(INC_NUM_TIMES - i + startingValue, statefulCounter.getCount());
        }
    }



}
