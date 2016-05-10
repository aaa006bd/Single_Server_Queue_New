package singleServer;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by My PC on 5/9/2016.
 */
public class SingleServerQueue {

    public SimulationClock simulationClock;

    private int numberOfArrivals,numberOfDepartures;
    private double totalWaitingTime, avgWaitingTime;
    private int maxNumberOfCustomers;
    private int customerProcessed;
    private int totalCustomerInWaitingQueue=0;

    private LinkedList<Customer> customerQueue;// FIFO

    private PriorityQueue<Event> events;// list of triggering event

    public SingleServerQueue(int maxNumberOfCustomers) {
        this.maxNumberOfCustomers = maxNumberOfCustomers;
    }

    private void initialize(){
        customerQueue = new LinkedList<>();// FIFO
        events = new PriorityQueue<>();// list of triggering event
        simulationClock = new SimulationClock(0);
        scheduleArrival();
    }

    public void simulate(){

        initialize();

        while (numberOfDepartures<maxNumberOfCustomers-1){
            Event event = events.poll();
            simulationClock.setTime(event.getEventTime());
            if (event.getType() == Event.ARRIVAL_EVENT){
                processArrival();
            }else {
                processDeparture();
            }
        }
        System.out.println("average waiting time: "+totalWaitingTime/maxNumberOfCustomers);
        System.out.println("total waiting time: "+totalWaitingTime);
        System.out.println("total customer in the waiting Queue: "+(totalWaitingTime/simulationClock.getTime()));

    }


    private void processArrival(){
        numberOfArrivals ++ ;
        customerQueue.add(new Customer(simulationClock.getTime()));
        if (customerQueue.size() == 1){
            scheduleDeparture();
        }
        scheduleArrival();

    }

    private void processDeparture(){
        numberOfDepartures++;
        Customer presentCustomer = customerQueue.poll();

        if(customerQueue.size()>0){
            Customer firstCustomerInQueue = customerQueue.getFirst();
            double waitingTime = simulationClock.getTime()-firstCustomerInQueue.getArrivalTime();
            System.out.println("waiting time for customer "+numberOfDepartures+": "+waitingTime);
            totalWaitingTime +=waitingTime;//waiting time for this customer
            scheduleDeparture();
        }

    }

    private void scheduleArrival() {
        double nextArrivalTime = simulationClock.getTime() + getRandomInterArrivalTime();
        System.out.println("arrival:"+nextArrivalTime);
        events.add(new Event(nextArrivalTime,Event.ARRIVAL_EVENT));
    }

    private void scheduleDeparture(){
        double nextDepartureTime = simulationClock.getTime() + getRandomServiceTime();
        System.out.println("departure:"+nextDepartureTime);
        events.add(new Event(nextDepartureTime,Event.DEPARTURE_EVENT));
    }

    private double getRandomServiceTime() {
        return 10;
    }

    private double getRandomInterArrivalTime() {
        return 5;
    }


}
