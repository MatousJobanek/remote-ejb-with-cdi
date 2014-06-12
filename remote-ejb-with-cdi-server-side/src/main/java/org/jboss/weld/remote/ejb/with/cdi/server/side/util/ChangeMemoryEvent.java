package org.jboss.weld.remote.ejb.with.cdi.server.side.util;

public class ChangeMemoryEvent {

    private int difference;

    public ChangeMemoryEvent(int difference) {
        this.difference = difference;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

}
