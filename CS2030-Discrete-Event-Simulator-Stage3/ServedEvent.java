package cs2030.simulator;

public class ServedEvent extends Event {

    private static int noServed;
    Server s;

    /**
     * Manages the serving event.
     * 
     * @param cs refers to the customer who is being served.
     * @param s refers to the serving who will be serving the particular customer.
     */

    public ServedEvent(Customer cs, Server s) {
        super(cs);
        this.s = s;
        noServed++;
        sequence.add(new Sequence(cs.getTime(), toString(), cs.getId(), SERVED));
    }

    /**
     * Returns the next event in the sequence.
     * @return Return the DoneEvent.
     */

    public Event getNextEvent() {
        serviceTime = serviceStream.get();
        timeKeeper = cs.getTime() + serviceTime;
        prevServiceTime = serviceTime;
        s.setNextServeTime(timeKeeper);
        cs.setTime(timeKeeper);
        return new DoneEvent(cs, s);
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
    
    @Override
    public String toString() {
        String toPrint = cs + " served by " + s.getName();

        return toPrint;
    }
}
