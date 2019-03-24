package cs2030.simulator;

public class DoneEvent extends Event {
    Server s;
    
    /**
     * Manages the done event.
     * @param time refers to the time at which the event is done.
     * @param id refers to the customer id.
     * @param s refers to the serving who will be serving the particular customer.
     */

    public DoneEvent(double time, int id, Server s) {
        super(time, id);
        this.s = s;
        s.setIsWaiting(false);
        s.setNextServeTime(time - prevServiceTime);
    }

    public int getStatus() {
        return DONE;
    }

    public int getServerId() {
        return s.getId();
    }

}
