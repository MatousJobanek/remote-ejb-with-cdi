/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.remote.ejb.with.cdi.server.side.injection;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.weld.remote.ejb.with.cdi.server.side.CalculatorStatelessRemote;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.ArithmeticOperations;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Advanced;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Basic;

/**
 * @author mjobanek
 */
@Stateless
@Remote(CalculatorStatelessRemote.class)
public class InjectedCalculatorStatelessRemoteImpl implements CalculatorStatelessRemote {

    @Inject
    @Basic
    private ArithmeticOperations basicOperations;

    @Inject
    @Advanced
    private ArithmeticOperations advancedOperations;

    public int add(int a, int b) {
        return basicOperations.add(a, b);
    }

    public int subtract(int a, int b) {
        return basicOperations.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return advancedOperations.multiply(a, b);
    }

    public double divide(double a, double b) {
        return advancedOperations.divide(a, b);
    }

}
