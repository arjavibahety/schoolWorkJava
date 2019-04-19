package cs2030.simulator;

import cs2030.simulator.RandomGenerator;
import java.util.function.Supplier;
import java.util.PriorityQueue;
import cs2030.simulator.Sequence;

public class Event {
    public static final int ARRIVES = 1;
    public static final int SERVED = 2;
    public static final int LEAVES = 3;
    public static final int DONE = 4;
    public static final int WAITS = 5;

    public static Supplier<Double> serviceStream;
    public static Supplier<Double> randomRestStream;
    public static Supplier<Double> restPeriodStream;
    public static Supplier<Double> customerTypeStream;

    public static PriorityQueue<Sequence> sequence = new PriorityQueue<>();

    public Customer cs;
    public double serviceTime;
    public double prevServiceTime;
    public double prevTime;
    public static double timeKeeper = 0;
    public static double totalWaitTime = 0;

    /**
     * The main parent class of all the various events.
     *
     * @param cs refers to the customer on which the event will be performed.
     */

    public Event(Customer cs) {
        this.cs = cs;
    }

    public Customer getCustomer() {
        return cs;
    }

    public Event getNextEvent() {
        return null;
    }

    public int getStatus() {
        return 0;
    }

    public int getServerId() {
        return 0;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public static void setServiceTimeStream(Supplier<Double> stream) {
        serviceStream = stream;
    }

    public static PriorityQueue<Sequence> getSequence() {
        return sequence;
    }

    public static void setRandomRestStream(Supplier<Double> stream) {
        randomRestStream = stream;
    }

    public static void setRestPeriodStream(Supplier<Double> stream) {
        restPeriodStream = stream;
    }

    public static void setCustomerTypeStream(Supplier<Double> stream) {
        customerTypeStream = stream;
    }

}
