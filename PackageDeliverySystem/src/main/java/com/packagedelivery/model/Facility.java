package com.packagedelivery.model;

import java.util.Set;

/**
 * The class Facility. we add town and transportationVehicle as attributes
 */
public class Facility {
    private String town;
    private FilterQueue filterQueue;
    private Set<TransportationVehicle> transportationVehicle;

    public Facility(String town, Set<TransportationVehicle> transportationVehicle) {
        this.town = town;
        this.transportationVehicle = transportationVehicle;
        this.filterQueue = new FilterQueue(town);
    }

    public Set<TransportationVehicle> getTransportationVehicle() {
        return transportationVehicle;
    }

    public void setTransportationVehicle(Set<TransportationVehicle> transportationVehicle) {
        this.transportationVehicle = transportationVehicle;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
