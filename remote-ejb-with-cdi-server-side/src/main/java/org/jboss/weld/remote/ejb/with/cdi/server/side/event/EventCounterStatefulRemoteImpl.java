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
package org.jboss.weld.remote.ejb.with.cdi.server.side.event;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.weld.remote.ejb.with.cdi.server.side.CounterStatefulRemote;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.ChangeMemoryEvent;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.Memory;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Decrement;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Increment;

/**
 * @author Jaikiran Pai
 * @author mjobanek
 */
@Stateful
@Remote(CounterStatefulRemote.class)
public class EventCounterStatefulRemoteImpl implements CounterStatefulRemote {

    @Inject
    private Memory memory;

    @Inject
    @Increment
    private Event<ChangeMemoryEvent> incrementMemoryEvent;

    @Inject
    @Decrement
    private Event<ChangeMemoryEvent> decrementMemoryEvent;

    public void increment() {
        incrementMemoryEvent.fire(new ChangeMemoryEvent(1));
    }

    public void decrement() {
        decrementMemoryEvent.fire(new ChangeMemoryEvent(1));
    }

    public int getCount() {
        return memory.getMemory();
    }
}
