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
package org.jboss.weld.remote.ejb.with.cdi.server.side.event.transaction;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.enterprise.event.Event;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

import org.jboss.weld.remote.ejb.with.cdi.server.side.TransactionalEventStatelessRemote;

/**
 * @author Matous Jobanek <mjobanek@redhat.com>
 */
@Remote(TransactionalEventStatelessRemote.class)
@TransactionManagement
// (TransactionManagementType.BEAN)
@Stateless
public class TransactionalEventStatelessRemoteImpl implements TransactionalEventStatelessRemote {

    // @Resource
    // private UserTransaction userTransaction;

    @Inject
    private Event<EventInTransaction> event;

    @Inject
    private ObserveTransactionalEvent observer;

    public void fireInTransaction() throws Exception {
        // userTransaction.begin();
        event.fire(new EventInTransactionImpl());
        // userTransaction.commit();
    }

    public void fireAndFailInTransaction() throws Exception {
        // userTransaction.begin();
        event.fire(new EventInTransactionImpl());
        // userTransaction.rollback();
    }

    public List<TransactionPhase> getRanPhasesList() {
        return observer.getRanPhases();
    }

}
