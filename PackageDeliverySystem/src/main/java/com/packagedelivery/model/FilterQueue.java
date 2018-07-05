package com.packagedelivery.model;

import java.io.Serializable;
import java.util.*;

/**
 * The class FilterQueue with deliveryQueue and transportqueue,
 * with a method that allow to addPackage
 */
public class FilterQueue implements Serializable {

    private List<Package> packages = new ArrayList<>();
    private Queue<Package> deliveryQueue = new LinkedList<>();
    private Queue<Package> transportQueue = new LinkedList<>();

    public void addPackages(List<Package> packages) {
        this.packages.addAll(packages);
    }
}
