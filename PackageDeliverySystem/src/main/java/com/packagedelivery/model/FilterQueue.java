package com.packagedelivery.model;

import java.util.*;

/**
 * The class FilterQueue with deliveryQueue and transportQueue,
 * with a method that allow to addPackage
 */
public class FilterQueue extends Thread {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    private String town;
    private Queue<Package> deliveryQueue = new LinkedList<>();
    private Queue<Package> transportQueue = new LinkedList<>();
    Set<Package> packages = new HashSet<>();

    public FilterQueue(String town) {
        this.town = town;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 7; i++) {
            FilterQueue filterQueue = new FilterQueue("A" + i);
            Thread t = new Thread(filterQueue);
            t.start();
        }
    }

    public void addPackages(List<Package> packages) {

        this.packages.addAll(packages);
    }

    public void processPackages() {

    }

    public void createThread() {
        //sa creez un thread care in momentul in care s-au adaugat
        // pachete in FilterQueue sa le proceseze(adica sa apeleze metoda processPackages)
    }

    private void splitPackages(List<Package> sortedPackages) {
        for (Package p : sortedPackages) {
            if (p.getDestination().getAddress().getCity().equals(town)) {
                deliveryQueue.add(p);
            } else {
                transportQueue.add(p);
            }
        }
    }
}




