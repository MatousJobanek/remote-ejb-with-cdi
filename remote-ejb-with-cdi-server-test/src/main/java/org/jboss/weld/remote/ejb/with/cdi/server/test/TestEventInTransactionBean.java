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
package org.jboss.weld.remote.ejb.with.cdi.server.test;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;
import org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction.EventInTransaction;
import org.jboss.weld.remote.ejb.with.cdi.test.Utils;

/**
 * @author Matous Jobanek <mjobanek@redhat.com>
 */
@Path("/test")
@RequestScoped
public class TestEventInTransactionBean {


    @Inject
    StatelessBeanForTransaction beanForTransaction;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String runMainTestSuite() throws Exception{

//        ArquillianTest arquillianTest = new ArquillianTest();
//        arquillianTest.testSipleEjb();
//        arquillianTest.testEjbWithInjections();
//        arquillianTest.testEjbWithEvents();
        beanForTransaction.testTransactionalEvents();

        Utils.getContext().close();
        return "OK";
    }

    @Inject
    private TransactionalEventStatelessRemote transactions;

    @Inject
    private EventInTransaction eventInTransaction;

    @Inject
    private Event<EventInTransaction> event;

//    @Resource
//    private EJBContext context;



}
