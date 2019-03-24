package cs2030.simulator;

import cs2030.simulator.RandomGenerator;
import java.util.function.Supplier;

public class Event {
    public static final int ARRIVES = 1;
    public static final int SERVED = 2;
    public static final int LEAVES = 3;
    public static final int DONE = 4;
    public static final int WAITS = 5;
    
    public static Supplier<Double> serviceStream;

    double time;
    int id;
    double serviceTime;
    double prevServiceTime;
    double prevTime;
    public static double timeKeeper = 0;

    /**
     * The main parent class of all the various events.
     * @param time refers to the time at which the action happens.
     * @param id refers to the customer id.
     */

    public Event(double time, int id) {
        this.time = time;
        this.id = id;
    }

    public double getTime() {
        return time;    
    }

    public int getId() {
        return id;    
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

}
