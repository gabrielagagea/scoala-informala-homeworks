package com.packagedelivery.model;

import java.util.HashSet;
import java.util.Set;

/**
 * The class Facility. we add town and transportationVehicle as attributes
 */
public class Facility {
    private Set<TransportationVehicle> transportationVehicle;
    private String town;

    public Facility(Set<TransportationVehicle> transportationVehicle, String town) {
        this.transportationVehicle = transportationVehicle;
        this.town = town;
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
