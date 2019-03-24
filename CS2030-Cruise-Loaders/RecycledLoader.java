import java.util.*;

public class RecycledLoader extends Loader {
    private int _loaderId = 0;
    private int _nextTime = 0;
    private ArrayList<Cruise> _cruiseList = new ArrayList<Cruise>();
    public RecycledLoader(int id) {
        super(id);
        _loaderId = id;
    }

    @Override
        public int getTimer() {
            return _nextTime + 60;
        }

    @Override
        public void loadShip(Cruise cr) {
            _cruiseList.add(cr);
            _nextTime = cr.getMinsTime() + 60;
        }

    @Override
        public void printLoader() {
            String line1 = "| Loader " + (_loaderId + 1) + " (recycled) serves:";
            int spaces = 35 - line1.length();
            char[] spaceAdd = new char[spaces];
            Arrays.fill(spaceAdd, ' ');
            System.out.print(line1);
            System.out.print(spaceAdd);
            System.out.println("|");
            for(int i = 0; i < _cruiseList.size(); i++) {
                System.out.println("|     " + _cruiseList.get(i).getCruise() + "                   |");
            }
            System.out.println("+==================================+");
        }
}
