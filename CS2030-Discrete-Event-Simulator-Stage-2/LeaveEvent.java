package cs2030.simulator;

public class LeaveEvent extends Event {
    
    private static int noLeft = 0;

    /**
     * Manages the leave event.
     * @param time refers to the time at which the customer leaves.
     * @param id refers to the customer id.
     */
    public LeaveEvent(double time, int id) {
        super(time, id);
        noLeft++;
    }

    public static int getNoLeft() {
        return noLeft;
    }
    
    public int getStatus() {
        return LEAVES;
    }
}
