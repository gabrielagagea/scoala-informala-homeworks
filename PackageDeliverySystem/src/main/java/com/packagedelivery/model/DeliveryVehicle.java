package com.packagedelivery.model;

public class DeliveryVehicle extends TransportationVehicle {

    public DeliveryVehicle(int maxPackages) {
        super(maxPackages);
    }

    @Override
    public String toString() {
        return "DeliveryVehicle{} " + super.toString();
    }
}