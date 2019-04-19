package cs2030.simulator;

import cs2030.simulator.ServerRest;

public class DoneEvent extends Event {
    Server s;

    /**
     * Manages the done event.
     * 
     * @param cs refers to the customer on which the action will be performed.
     * @param s    refers to the serving who will be serving the particular
     *             customer.
     */

    public DoneEvent(Customer cs, Server s) {
        super(cs);
        this.s = s;
        s.setIsWaiting(false);
        sequence.add(new Sequence(cs.getTime(), toString(), cs.getId(), DONE));
    }

    public int getStatus() {
        return DONE;
    }

    public int getServerId() {
        return s.getId();
    }

    /**
     * Returns the next event.
     * The method will check whether the server will go to sleep after it has 
     * finished serving a customer. If so, then it will return a ServerRest event.
     * Else it will check whether there are any customers in the waiting queue and 
     * serve the first customer in the queue.
     * Else it will return null.
     * @return Returns the next event after the Done Event. 
     */
    public Event getNextEvent() {
        if (!(s instanceof SelfCheckout)) {
            double randomNo = randomRestStream.get();
            if (randomNo < Server.restingProb) {
                double randomRestPeriod = restPeriodStream.get();
                double returnTime = cs.getTime() + randomRestPeriod;
                s.setNextServeTime(returnTime);
                return new ServerRest(cs, s, returnTime);
            } else {

                if (!s.getQueue().isEmpty()) {
                    WaitEvent we = s.removeHead();
                    totalWaitTime += s.getNextServeTime() - we.getCustomer().getTime();
                    timeKeeper += prevServiceTime;
                    Customer nextCs = we.getCustomer();
                    nextCs.setTime(s.getNextServeTime());
                    ServedEvent se = new ServedEvent(nextCs, we.s);
                    return se;
                }

                return null;
            }
        } else {

            if (!s.getQueue().isEmpty()) {
                WaitEvent we = s.removeHead();
                totalWaitTime += s.getNextServeTime() - we.getCustomer().getTime();
                timeKeeper += prevServiceTime;
                Customer nextCs = we.getCustomer();
                nextCs.setTime(s.getNextServeTime());
                ServedEvent se = new ServedEvent(nextCs, we.s);
                return se;
            }

            return null;

        }

    }

    @Override
    public String toString() {
        String toPrint = cs + " done serving by " + s.getName();
        return toPrint;
    }

}
