package singleServer;

/**
 * Created by My PC on 5/9/2016.
 */
public class Customer {
    private double arrivalTime;

    public Customer(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
