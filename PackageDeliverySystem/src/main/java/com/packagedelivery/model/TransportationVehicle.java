package com.packagedelivery.model;

import java.io.Serializable;
import java.util.*;

/**
 * I made an abstract class TransportationVehicle with the attribute maxPackages
 * and a method for sorting the packages. I have 3 classes that extends this class.
 */
public abstract class TransportationVehicle implements Serializable {
    private int maxPackages;
    private List<Package> packages = new ArrayList<>();

    public TransportationVehicle(int maxPackages)  {
        this.maxPackages = maxPackages;
    }
    public void addPackages(Set<Package> packages){
        this.packages.addAll(packages);
    }

    @Override
    public String toString() {
        return "TransportationVehicle{" +
                "maxPackages=" + maxPackages +
                ", packages=" + packages +
                '}';
    }

    public int getMaxPackages() {
        return maxPackages;
    }
}






