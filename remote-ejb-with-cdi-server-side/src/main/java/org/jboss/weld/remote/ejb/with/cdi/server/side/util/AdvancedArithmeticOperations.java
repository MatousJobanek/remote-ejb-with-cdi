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
package org.jboss.weld.remote.ejb.with.cdi.server.side.util;

import javax.enterprise.context.RequestScoped;

/**
 * @author Matous Jobanek <mjobanek@redhat.com>
 */
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
