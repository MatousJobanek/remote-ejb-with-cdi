package org.jboss.weld.remote.ejb.with.cdi.server.side.util;

import javax.enterprise.context.RequestScoped;

import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Basic;

@RequestScoped
@Basic
public class BasicArithmeticOperations implements ArithmeticOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        throw new UnsupportedOperationException("multiply");
    }

    public double divide(double a, double b) {
        throw new UnsupportedOperationException("divide");
    }

}
