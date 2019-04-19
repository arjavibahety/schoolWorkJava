package cs2030.simulator;

public class LeaveEvent extends Event {

    private static int noLeft = 0;

    /**
     * Manages the leave event.
     * 
     * @param cs refers to the customer who leaves.
     */
    public LeaveEvent(Customer cs) {
        super(cs);
        noLeft++;
        sequence.add(new Sequence(cs.getTime(), toString(), cs.getId(), LEAVES));
    }

    public static int getNoLeft() {
        return noLeft;
    }

    public int getStatus() {
        return LEAVES;
    }

    @Override
    public String toString() {
        String toPrint = cs + " leaves";

        return toPrint;
    }
}
