package com.packagedelivery.model;

public class TransportVehicle extends TransportationVehicle {

    public TransportVehicle(int maxPackages) {
        super(maxPackages);
    }

    @Override
    public String toString() {
        return "TransportVehicle{} " + super.toString();
    }
}
