package cs2030.simulator;

import java.util.Comparator; 

public class EventComparator implements Comparator<Event> {

    /**
     * Manages the sorting order of the priority queue.
     * The strings of actions will be stored in a priority queue and sorted
     * based on the customer id, time and what action is being perfomed.
     */

    public int compare(Event e1, Event e2) {
        if (e1.getTime() >= e2.getTime()) {
            if (e1.getTime() == e2.getTime()) {
                if (e1.getId() >= e2.getId()) {
                    if (e1.getId() == e2.getId()) {
                        if (e1.getStatus() > e2.getStatus()) {
                            return 1;   
                        } else {
                            return -1;    
                        }   
                    }
                    return 1;   
                } else {
                    return -1;    
                }    
            } else {
                return 1;
            }
        } else {
            return -1;    
        }   
    }
}
