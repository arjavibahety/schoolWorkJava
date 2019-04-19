package cs2030.simulator;

public class GreedyCustomer extends Customer {
    
    /**
     * Greedy Customer class.
     *
     * @param time refers to the time at which a certain action will be performed.
     * @param id refers to the customer id.
     */

    public GreedyCustomer(double time, int id) {
        super(time, id);
    }

    @Override
    public String toString() {
        return String.format("%.3f", getTime()) + " " + getId() + "(greedy)";
    }
}
