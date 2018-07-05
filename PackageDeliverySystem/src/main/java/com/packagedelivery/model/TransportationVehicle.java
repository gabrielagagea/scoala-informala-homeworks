package com.packagedelivery.model;

import java.util.ArrayList;
import java.util.List;

/**
 * I made an abstract class TransportationVehicle with the attribute maxPackages
 * and a method for sorting the packages. I have 3 classes that extends this class.
 */
public abstract class TransportationVehicle {
    private int maxPackages;
    private List<Package> packages = new ArrayList<>();

    public TransportationVehicle(int maxPackages, List<Package> packages) {
        this.maxPackages = maxPackages;
        this.packages = packages;
    }

    public int getMaxPackages() {
        return maxPackages;
    }
}

class PickupVehicle extends TransportationVehicle {

    public PickupVehicle(int maxPackages, List<Package> packages) {
        super(maxPackages, packages);
    }
}

class DeliveryVehicle extends TransportationVehicle {

    public DeliveryVehicle(int maxPackages, List<Package> packages) {
        super(maxPackages, packages);
    }
}

class TransportVehicle extends TransportationVehicle {

    public TransportVehicle(int maxPackages, List<Package> packages) {
        super(maxPackages, packages);
    }
}


