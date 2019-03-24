package cs2030.simulator;

public class WaitEvent extends Event {
    Server s;
    private static double totalWaitTime;

    /**
     * Manages the waiting event.
     * @param time refers to the time when the customer starts to wait.
     * @param id refers to the customer id.
     * @param s refers to the serving who will be serving the particular customer.
     */

    public WaitEvent(double time, int id, Server s) {
        super(time, id);
        totalWaitTime += s.getNextServeTime() - time;
        this.s = s;
    }
    
    /**
     * Returns the next event in the sequence: Served.
     */

    public Event getNextEvent() {
        timeKeeper += prevServiceTime;
        return new ServedEvent(s.getNextServeTime(), id, s);
    }

    public static double getTotalWaitTime() {
        return totalWaitTime;
    }

    public int getStatus() {
        return WAITS;
    }

    public int getServerId() {
        return s.getId();
    }

}
