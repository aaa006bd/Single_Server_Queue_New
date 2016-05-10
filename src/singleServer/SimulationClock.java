package singleServer;

/**
 * Created by My PC on 5/9/2016.
 */
public class SimulationClock {
    private double time;

    public SimulationClock(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
