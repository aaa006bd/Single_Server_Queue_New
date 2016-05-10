package singleServer;

import java.util.LinkedList;

/**
 * Created by My PC on 5/9/2016.
 */
public class TestSingleServer {
    public static void main(String[] args) {
        SingleServerQueue simulation = new SingleServerQueue(5);

        LinkedList<Integer> testList = new LinkedList<>();

        testList.add(10);

        simulation.simulate();
    }
}
