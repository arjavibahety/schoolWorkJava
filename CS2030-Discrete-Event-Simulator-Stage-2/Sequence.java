package cs2030.simulator;

import java.util.PriorityQueue;

public class Sequence implements Comparable<Sequence> {
    private double time;
    private String command;
    private int id;
    private int status;

    /**
     * Manages the list of service outputs by the server. 
     * This list is sorted in ascending order based on customer ID, status 
     * and time.
     * @param time refers to the time the particular action will happen to the customer.
     * @param command refers to the string of action the server does to the customer.
     * @param id refers to the customer id.
     * @param status refers to the numeric value of the action the server does to the customer.
     */

    public Sequence(double time, String command, int id, int status) {
        this.time = time;  
        this.command = command;
        this.id = id;
        this.status = status;
    }    

    public int getId() {
        return id;    
    }

    public int getStatus() {
        return status;    
    }

    public double getTime() {
        return time;    
    }

    public String getSentence() {
        return command;    
    }

    /**
     * Manages the sorting order of the priority queue.
     * The strings of actions will be stored in a priority queue and sorted
     * based on the customer id, time and what action is being perfomed.
     */

    public int compareTo(Sequence seq) {
        if (this.getTime() >= seq.getTime()) {
            if (this.getTime() == seq.getTime()) {
                if (this.getId() >= seq.getId()) {
                    if (this.getId() == seq.getId()) {
                        if (this.getStatus() > seq.getStatus()) {
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
