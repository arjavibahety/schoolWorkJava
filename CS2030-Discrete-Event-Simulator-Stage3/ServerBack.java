package cs2030.simulator;

import cs2030.simulator.Event;
import cs2030.simulator.ServedEvent;
import cs2030.simulator.WaitEvent;
import cs2030.simulator.Server;

public class ServerBack extends Event {
    Server s;

    /** 
     * Manages the ServerBack event.
     *
     * @param cs refers to the customer who was last served by the server.
     * @param s refers to the server which is done resting.
     */

    public ServerBack(Customer cs, Server s) {
        super(new Customer(cs.getTime(), -1));
        this.s = s;
        s.setResting(false);
        sequence.add(new Sequence(cs.getTime(), toString(), -1, 6));
    }

    /**
     * Returns the next event in sequence. 
     * If the server has customers waiting in the queue then it will return the
     * ServedEvent and attend to the customer.
     * Else it will return null.
     * @return Returns the next event.
     */
    
    public Event getNextEvent() {
        if (!s.getQueue().isEmpty()) {
            WaitEvent we = s.removeHead();
            totalWaitTime += s.getNextServeTime() - we.getCustomer().getTime();
            timeKeeper += prevServiceTime;
            Customer nextCs =  we.getCustomer();
            nextCs.setTime(s.getNextServeTime());
            ServedEvent se = new ServedEvent(nextCs, we.getServer());
            return se;
        }

        return null;
    }

    @Override
    public String toString() {
        String toPrint = String.format("%.3f", cs.getTime()) + " server " + s.getId() + " back";
        return toPrint;
    }
}
