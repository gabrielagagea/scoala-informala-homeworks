package com.packagedelivery.model;

public abstract class TransportationVehicle {
    private int maxPackages;

    public int getMaxPackages() {
        return maxPackages;
    }
}

class PickupVehicle extends TransportationVehicle{

}
class DeliveryVehicle extends TransportationVehicle{

}
class TransportVehicle extends TransportationVehicle{
    
}


