package singleServer;

/**
 * Created by My PC on 5/9/2016.
 */
public class Customer {
    private double arrivalTime;
    private double serviceTime;

    public Customer(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Customer(double arrivalTime, double serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }
}
