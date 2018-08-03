package com.packagedelivery.model;

public class PickupVehicle extends TransportationVehicle {

    public PickupVehicle(int maxPackeges) {
        super(maxPackeges);
    }

    @Override
    public String toString() {
        return "PickupVehicle{} " + super.toString();
    }
}


