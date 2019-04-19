package cs2030.simulator;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.PriorityQueue;
import cs2030.simulator.WaitEvent;

public class Server {
    private double serveTime = 0;
    private boolean isWaiting = false;
    private int id;
    private LinkedList<WaitEvent> inLine = new LinkedList<>();
    public static double restingRate;
    public static double restingProb;
    private boolean isResting = false;

    /**
     * Manages the various servers. Each server is uniquely identified by an ID.
     * 
     * @param id refers to the id of the server.
     */

    public Server(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return "server " + id;
    }

    public double getNextServeTime() {
        return serveTime;
    }

    public void setNextServeTime(double time) {
        serveTime = time;
    }

    public void setIsWaiting(boolean change) {
        isWaiting = change;
    }

    public int getQueueLength() {
        return inLine.size();
    }

    public void addToQueue(WaitEvent wt) {
        inLine.add(wt);
    }

    public WaitEvent removeHead() {
        return inLine.removeFirst();
    }

    public LinkedList<WaitEvent> getQueue() {
        return inLine;
    }

    public static void setRestingRate(double rr) {
        restingRate = rr;
    }

    public static void setRestingProb(double rp) {
        restingProb = rp;
    }

    public void setResting(boolean isResting) {
        this.isResting = isResting;
    }

    public boolean isResting() {
        return isResting;
    }

    /**
     * Calculates the various statistics and combines them into a string.
     * 
     * @return String of statistics.
     */

    public static String getStats() {
        double averageWaitTime = WaitEvent.getTotalWaitTime() / ServedEvent.getNoServed();
        averageWaitTime = Double.isNaN(averageWaitTime) ? 0 : averageWaitTime;
        return "[" + String.format("%.3f", averageWaitTime) + " " + ServedEvent.getNoServed() + " "
                + LeaveEvent.getNoLeft() + "]";
    }

}
