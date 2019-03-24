import java.util.*;

public class BigCruise extends Cruise {
    private String _name;
    private String _time;

    public BigCruise(String name, String time) {
        super(name, time);
    }

    @Override
        public int getMinsTime() {
            int time = Integer.parseInt(getTime());
            int minutes = (((time / 100) * 60) + (time % 100)) + 60;
            return minutes;
        }

}
