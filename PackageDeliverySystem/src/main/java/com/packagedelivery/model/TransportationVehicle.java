package com.packagedelivery.model;

/**I made an abstract class TransportationVehicle with the attribute maxPackages
 * and a method for sorting the packages. I have 3 classes that extends this class.
 *
 */
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


