package org.jboss.weld.remote.ejb.with.cdi.server.side.util;

import javax.enterprise.inject.Produces;

import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Advanced;

public class BeanProducer {

    @Produces
    @Advanced
    public ArithmeticOperations getArithmeticOperations(){
        return new AdvancedArithmeticOperations();
    }

}
