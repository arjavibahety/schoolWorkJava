package cs2030.simulator;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.function.Supplier;
import cs2030.simulator.ArrivalEvent;
import cs2030.simulator.Server;
import cs2030.simulator.Sequence;
import cs2030.simulator.RandomGenerator;
import cs2030.simulator.Event;

public class EventSimulator {

    public static final int ARRIVES = 1;
    public static int noLeft = 0;

    /**
     * Manages all the severs and assigns customers to their respective servers.
     */

    public static void simulate() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Server> servers = new ArrayList<>();
        ArrayList<SelfCheckout> selfCheckOuts = new ArrayList<>();
        PriorityQueue<Event> events = new PriorityQueue<>(new EventComparator());

        int seedValue = scanner.nextInt();
        int noOfServers = scanner.nextInt();
        int noOfSelfCheckoutCounters = scanner.nextInt();
        int queueLength = scanner.nextInt();
        int noOfCustomers = scanner.nextInt();
        double arrivalRate = scanner.nextDouble();
        double serviceRate = scanner.nextDouble();
        double restingRate = scanner.nextDouble();
        double restingProb = scanner.nextDouble();
        double greedyProb = scanner.nextDouble();

        RandomGenerator rg = new RandomGenerator(seedValue, arrivalRate, serviceRate, restingRate);

        Supplier<Double> arrivalTimeStream = () -> rg.genInterArrivalTime();
        Supplier<Double> serviceTimeStream = () -> rg.genServiceTime();
        Supplier<Double> randomRestStream = () -> rg.genRandomRest();
        Supplier<Double> restPeriodStream = () -> rg.genRestPeriod();
        Supplier<Double> customerTypeStream = () -> rg.genCustomerType();

        Event.setServiceTimeStream(serviceTimeStream);
        Event.setRestPeriodStream(restPeriodStream);
        Event.setRandomRestStream(randomRestStream);
        Event.setCustomerTypeStream(customerTypeStream);

        for (int i = 1; i <= noOfServers; i++) {
            servers.add(new Server(i));
        }

        for (int i = noOfServers + 1; i <= noOfServers + noOfSelfCheckoutCounters; i++) {
            selfCheckOuts.add(new SelfCheckout(i));
        }

        Server.setRestingProb(restingProb);

        int i = 1;
        double time = 0.0;
        int counter = 0;

        while (counter < noOfCustomers) {

            if (greedyProb > customerTypeStream.get()) {
                ArrivalEvent e1 = new ArrivalEvent(new GreedyCustomer(time, i), 
                    servers, queueLength, selfCheckOuts);
                events.add(e1);
            } else {
                ArrivalEvent e1 = new ArrivalEvent(new Customer(time, i), 
                    servers, queueLength, selfCheckOuts);
                events.add(e1);
            }

            time += arrivalTimeStream.get();
            i++;
            counter++;
        }

        while (!events.isEmpty()) {
            Event e1 = events.poll();
            Event next = e1.getNextEvent();
            if (next != null) {
                events.add(next);
            }
        }

        PriorityQueue<Sequence> sequence = Event.getSequence();

        while (!sequence.isEmpty()) {
            String sp = sequence.poll().getSentence();
            System.out.println(sp);
        }

        System.out.println(Server.getStats());

    }
}
