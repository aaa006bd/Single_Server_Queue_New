package singleServer;

/**
 * Created by My PC on 5/9/2016.
 */
public class Event implements Comparable {

    private double eventTime;
    private int type = -1;

    public static int ARRIVAL_EVENT = 1;
    public static int DEPARTURE_EVENT = 2;

    public Event(double eventTime, int type) {
        this.eventTime = eventTime;
        this.type = type;
    }

    public double getEventTime() {
        return eventTime;
    }

    public void setEventTime(double eventTime) {
        this.eventTime = eventTime;
    }

    public int getType() {
        return type;
    }

    @Override
    public int compareTo(Object o) {

        Event e = (Event) o;

        if (eventTime < e.getEventTime()){
            return -1;
        }else if (eventTime > e.getEventTime()){
            return 1;
        }else {
            return 0;
        }
    }
}
