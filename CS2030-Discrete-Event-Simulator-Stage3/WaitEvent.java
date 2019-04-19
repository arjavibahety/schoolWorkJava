package cs2030.simulator;

public class WaitEvent extends Event {
    Server s;

    /**
     * Manages the waiting event.
     * 
     * @param cs refers to the customer who is waiting.
     * @param s refers to the serving who will be serving the particular customer.
     */

    public WaitEvent(Customer cs, Server s) {
        super(cs);
        this.s = s;
        sequence.add(new Sequence(cs.getTime(), toString(), cs.getId(), WAITS));
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

    public Server getServer() {
        return s;
    }

    @Override
    public String toString() {
        String toPrint = cs + " waits to be served by " + s.getName();
        return toPrint;
    }

}
