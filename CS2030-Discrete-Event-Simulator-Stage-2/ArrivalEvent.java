package cs2030.simulator;

import cs2030.simulator.Server;
import java.util.ArrayList;

public class ArrivalEvent extends Event {
    
    private ArrayList<Server> servers;

    /**
     * Manages the arrival event.
     * @param time refers to the time at which the customer arrives.
     * @param id refers to the customer id.
     * @param servers refers to the ArrayList of all the servers.
     */

    public ArrivalEvent(double time, int id, ArrayList<Server> servers) {
        super(time, id);    
        this.servers = servers;
    }

    /**
     * Determines the next event in sequence.
     * The customer will either need to wait or will be served immediately
     * @return Returns the next event.
     */

    public Event getNextEvent() {
        int size = servers.size();
        
        int i = 0;
        while (i < size) {
            Server s = servers.get(i);
            if (time >= s.getNextServeTime()) {
                ServedEvent next = new ServedEvent(this.time, this.id, s);
                s.setNextServeTime(time);
                return next;

            } 
            i++;
        }  
        
        i = 0;
        while (i < size) {
            Server s = servers.get(i);
            if (!s.getIsWaiting()) {
                s.setIsWaiting(true);;
                return new WaitEvent(this.time, this.id, s);
            }
            i++;
        }  
                
        return new LeaveEvent(this.time, this.id);
          
    
    }

    public int getStatus() {
        return ARRIVES;
    }
}
