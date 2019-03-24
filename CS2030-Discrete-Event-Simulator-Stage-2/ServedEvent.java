package cs2030.simulator;

public class ServedEvent extends Event {

    private static int noServed;
    Server s;


    /**
     * Manages the serving event.
     * @param time refers to the time at which the customer will be served.
     * @param id refers to the customer id.
     * @param s refers to the serving who will be serving the particular customer.
     */

    public ServedEvent(double time, int id, Server s) {
        super(time, id);
        this.s = s;
        noServed++;
    }

    /**
     * Returns the next event in the sequence: Done.
     */
    public Event getNextEvent() {
        serviceTime = serviceStream.get();
        timeKeeper = time + serviceTime;
        prevServiceTime = serviceTime;
        return new DoneEvent(timeKeeper, id, s);
    }

    public int getStatus() {
        return SERVED;
    }

    public static int getNoServed() {
        return noServed;
    }

    public int getServerId() {
        return s.getId();
    }
}
