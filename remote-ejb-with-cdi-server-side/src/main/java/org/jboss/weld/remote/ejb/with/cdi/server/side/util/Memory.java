package org.jboss.weld.remote.ejb.with.cdi.server.side.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Decrement;
import org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation.Increment;

@ApplicationScoped
public class Memory {

    private int number = 0;

    public void putInMemory(int number) {
        this.number = number;
    }

    public int getMemory() {
        return number;
    }

    public void incrementMemoryEvent(@Observes @Increment ChangeMemoryEvent event) {
        number += event.getDifference();
    }

    public void decrementMemoryEvent(@Observes @Decrement ChangeMemoryEvent event) {
        number -= event.getDifference();
    }

}
