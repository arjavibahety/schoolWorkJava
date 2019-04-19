package cs2030.simulator;

public class Customer {
    double time;
    int id;

    /**
     * Customer class.
     * 
     * @param time refers to the time at which a certain action will be performed.
     * @param id refers to the customer id.
     */

    public Customer(double time, int id) {
        this.time = time;
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("%.3f", getTime()) + " " + getId();
    }

}
