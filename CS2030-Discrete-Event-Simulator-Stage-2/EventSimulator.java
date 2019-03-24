package cs2030.simulator;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.function.Supplier;
import cs2030.simulator.ArrivalEvent;
import cs2030.simulator.Server;
import cs2030.simulator.Sequence;
import cs2030.simulator.RandomGenerator;

public class EventSimulator {

    public static final int ARRIVES = 1;
    public static int noLeft = 0;

    /**
     * Manages all the severs and assigns customers to their respective servers.
     */

    public static void simulate() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Server> servers = new ArrayList<>();
        PriorityQueue<Event> events = new PriorityQueue<>(new EventComparator());

        
        int seedValue = scanner.nextInt();
        int noOfServers = scanner.nextInt();
        int noOfCustomers = scanner.nextInt();
        double arrivalRate = scanner.nextDouble();
        double serviceRate = scanner.nextDouble();

        RandomGenerator rg = new RandomGenerator(seedValue, arrivalRate, 
            serviceRate, 1.0);

        Supplier<Double> arrivalTimeStream = () -> rg.genInterArrivalTime();
        Supplier<Double> serviceTimeStream = () -> rg.genServiceTime();
        Event.setServiceTimeStream(serviceTimeStream);

        for (int i = 1; i <= noOfServers; i++) {
            servers.add(new Server(i));    
        }

        int i = 1;
        double time = 0.0;
        int counter = 0;

        while (counter < noOfCustomers) {
            ArrivalEvent e1 = new ArrivalEvent(time, i, servers);
            events.add(e1);
            time += arrivalTimeStream.get();
            i++;
            counter++;  
           
        }

        PriorityQueue<Sequence> sequence = new PriorityQueue<>();


        while (!events.isEmpty()) {
            Event e1 = events.poll();
            String toPrint = "";

            if (e1 instanceof ArrivalEvent) {
                toPrint = String.format("%.3f", e1.getTime()) + " " + 
                    e1.getId() + " arrives";
                events.add(e1.getNextEvent());

            } else if (e1 instanceof WaitEvent) {
               
                toPrint = String.format("%.3f", e1.getTime()) + " " + 
                    e1.getId() + " waits to be served by " + e1.getServerId();
                
                events.add(e1.getNextEvent());
                
            } else if (e1 instanceof ServedEvent) {
                
                toPrint = String.format("%.3f", e1.getTime()) + " " + e1.getId()
                    + " served by " + e1.getServerId();    

                events.add(e1.getNextEvent());
                

            } else if (e1 instanceof DoneEvent) {
                toPrint = String.format("%.3f", e1.getTime()) + " " + e1.getId() 
                    + " done serving by " + e1.getServerId();

            } else if (e1 instanceof LeaveEvent) {
                toPrint = String.format("%.3f", e1.getTime()) + " " + e1.getId() 
                    + " leaves";
            }

            sequence.add(new Sequence(e1.getTime(), toPrint, e1.getId(), e1.getStatus()));
        }


        while (!sequence.isEmpty()) {
            String sp = sequence.poll().getSentence();
            System.out.println(sp);
        }

        System.out.println(Server.getStats());

    }
}
