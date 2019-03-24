package cs2030.simulator;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Server {
    private double serveTime = 0;
    private boolean isWaiting = false;
    private int id;

    /**
     * Manages the various servers.
     * Each server is uniquely identified by an ID.
     * @param id refers to the id of the server.
     */

    public Server(int id) {
        this.id = id; 
    }

    public int getId() {
        return id;    
    }

    public double getNextServeTime() {
        return serveTime;
    }

    public void setNextServeTime(double time) {
        serveTime = time;
    }

    public boolean getIsWaiting() {
        return isWaiting;
    }

    public void setIsWaiting(boolean change) {
        isWaiting = change;
    }
   
    /**
     * Calculates the various statistics and combines them into a string.
     * @return String of statistics.
     */

    public static String getStats() {
        return "[" + String.format("%.3f", 
            WaitEvent.getTotalWaitTime() / ServedEvent.getNoServed()) + " " + 
            ServedEvent.getNoServed() + " " + LeaveEvent.getNoLeft() + "]";
    }

}


