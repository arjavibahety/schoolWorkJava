public class Cruise {
    private String _name;
    private String _time;

    public Cruise(String name, String time) {
        if(time.length() < 4) {
            int time_size = time.length();
            for(int i = 0; i < 4 - time_size; i++) {
                time = "0" + time;
            }
            _time = time;
        } else {
            _time = time;
        }
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public String getTime() {
        return _time;
    }

    public int getMinsTime() {
        int time = Integer.parseInt(getTime());
        int minutes = (((time / 100) * 60) + (time % 100)) + 30;
        return minutes;
    }

    public String getCruise() {
        return getName() + "@" + getTime();
    }
}
