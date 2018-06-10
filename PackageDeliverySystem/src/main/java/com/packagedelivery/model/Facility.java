package com.packagedelivery.model;

import java.util.Set;

public class Facility {
    private Set<TransportationVehicle> transportationVehicle;
    private String town;

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
