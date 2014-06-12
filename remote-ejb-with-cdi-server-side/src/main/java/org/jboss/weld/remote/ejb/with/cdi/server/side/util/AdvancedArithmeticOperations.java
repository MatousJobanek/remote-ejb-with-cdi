package org.jboss.weld.remote.ejb.with.cdi.server.side.util;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AdvancedArithmeticOperations implements ArithmeticOperations {

    public int add(int a, int b) {
        throw new UnsupportedOperationException("add");
    }

    public int subtract(int a, int b) {
        throw new UnsupportedOperationException("subtract");
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

}
