package org.jboss.weld.remote.ejb.with.cdi.test;



public class Main {


    public static void main(String[] args) throws Exception {

        ArquillianTest arquillianTest = new ArquillianTest();
        arquillianTest.testSipleEjb();
        arquillianTest.testEjbWithInjections();
        arquillianTest.testEjbWithEvents();
        arquillianTest.testTransactionalEvents();

    }

}
