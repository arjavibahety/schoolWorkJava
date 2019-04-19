package cs2030.simulator;

import cs2030.simulator.Server;
import cs2030.simulator.Event;

public class ServerRest extends Event {
    Server s;
    double returnTime;

    /**
     * Manages the ServerRest event.
     *
     * @param cs refers to the customer who was last served by the server.
     * @param s refers to the server going to rest.
     * @param returnTime refers to the time the server will be done resting.
     */

    public ServerRest(Customer cs, Server s, double returnTime) {
        super(new Customer(cs.getTime(), -1));
        this.s = s;
        this.returnTime = returnTime;
        s.setResting(true);
        sequence.add(new Sequence(cs.getTime(), toString(), 1000000000, 6));
    }


    /**
     * Returns the next event in the sequence.
     * @return Returns the ServerBack event.
     */

    public Event getNextEvent() {
        return new ServerBack(new Customer(returnTime, -1), s);
    }

    @Override
    public String toString() {
        String toPrint = String.format("%.3f", cs.getTime()) + " server " + s.getId() + " rest";
        return toPrint;
    }
}
