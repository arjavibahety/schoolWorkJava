package cs2030.simulator;

import java.util.ArrayList;
import cs2030.simulator.Server;
import cs2030.simulator.SelfCheckout;
import cs2030.simulator.Sequence;
import cs2030.simulator.Customer;
import cs2030.simulator.GreedyCustomer;

public class ArrivalEvent extends Event {

    private ArrayList<Server> servers;
    private int queueLength;
    private ArrayList<SelfCheckout> selfCheckouts;

    /**
     * Manages the arrival event.
     * 
     * @param cs refers to the customer who has arrived.
     * @param servers refers to the ArrayList of all the servers.
     * @param queueLength refers to the maximum length of waiting queue.
     * @param selfCheckouts refers to theArrayList of self-checkout counters.
     */

    public ArrivalEvent(Customer cs, ArrayList<Server> servers, int queueLength,
            ArrayList<SelfCheckout> selfCheckouts) {
        super(cs);
        this.servers = servers;
        this.selfCheckouts = selfCheckouts;
        this.queueLength = queueLength;
        sequence.add(new Sequence(cs.getTime(), toString(), cs.getId(), ARRIVES));
    }

    /**
     * Determines the next event in sequence. 
     * The customer will either need to wait,
     * will be served immediately, or will leave.
     * If the server is not serving any customer, the arriving customer will be 
     * served immediately.
     * Else, the customer will join a queue. If the customer is a greedy customer, 
     * then he / she will join the queue with the shortest length.
     * If all the queues are full, the customer will leave.
     * @return Returns the next event.
     */

    public Event getNextEvent() {
        int size = servers.size();

        int i = 0;
        while (i < size) {
            Server s = servers.get(i);
            if (cs.getTime() >= s.getNextServeTime() && !s.isResting()) {
                ServedEvent next = new ServedEvent(cs, s);
                s.setNextServeTime(cs.getTime());
                return next;
            }
            i++;
        }

        size = selfCheckouts.size();

        i = 0;
        while (i < size) {
            SelfCheckout s = selfCheckouts.get(i);
            if (cs.getTime() >= s.getNextServeTime()) {
                ServedEvent next = new ServedEvent(cs, s);
                s.setNextServeTime(cs.getTime());
                return next;
            }
            i++;
        }

        if (cs instanceof GreedyCustomer) {
            Server shortest = servers.get(0);
            int shortestLength = shortest.getQueueLength();

            size = servers.size();

            i = 0;
            while (i < size) {
                Server s = servers.get(i);
                if (s.getQueueLength() < queueLength) {
                    if (shortestLength > s.getQueueLength()) {
                        shortestLength = s.getQueueLength();
                        shortest = s;
                    }
                }
                i++;
            }

            size = selfCheckouts.size();

            i = 0;
            while (i < size) {
                SelfCheckout s = selfCheckouts.get(i);
                if (s.getQueueLength() < queueLength) {
                    if (shortestLength > s.getQueueLength()) {
                        shortestLength = s.getQueueLength();
                        shortest = s;
                    }
                }
                i++;
            }

            if (shortest.getQueueLength() < queueLength) {
                WaitEvent wtEvent = new WaitEvent(cs, shortest);
                shortest.addToQueue(wtEvent);
                return wtEvent;
            }

        } else {

            size = servers.size();

            i = 0;
            while (i < size) {
                Server s = servers.get(i);
                if (s.getQueueLength() < queueLength) {
                    WaitEvent wtEvent = new WaitEvent(cs, s);
                    s.addToQueue(wtEvent);
                    return wtEvent;
                }
                i++;
            }

            size = selfCheckouts.size();

            i = 0;
            while (i < size) {
                SelfCheckout s = selfCheckouts.get(i);
                if (s.getQueueLength() < queueLength) {
                    WaitEvent wtEvent = new WaitEvent(cs, s);
                    s.addToQueue(wtEvent);
                    return wtEvent;
                }
                i++;
            }
        }

        return new LeaveEvent(cs);

    }

    @Override
    public String toString() {
        String toPrint = cs + " arrives";

        return toPrint;
    }

    public int getStatus() {
        return ARRIVES;
    }
}
