package cs2030.simulator;

public class SelfCheckout extends Server {

    public SelfCheckout(int id) {
        super(id);
    }

    public String getName() {
        return "self-check " + getId();
    }
}