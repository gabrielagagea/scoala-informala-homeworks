package com.packagedelivery.serializable;

import com.packagedelivery.model.*;
import com.packagedelivery.model.Package;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TransportationVehicleTest {

    private static final int PICKUP_VEHICLES_NO = 2;
    private static final int PICKUP_VEHICLE_MAX_PACKAGES = 20;
    private static final int DELIVERY_VEHICLES_NO = 3;
    private static final int DELIVERY_VEHICLE_MAX_PACKAGES = 50;
    private static final int TRANSPORT_VEHICLES_NO = 5;
    private static final int TRANSPORT_VEHICLE_MAX_PACKAGES = 100;
    private Set<TransportationVehicle> transportationVehicles = new LinkedHashSet<>();

    private static Set<PickupVehicle> createPickupVehicles() {
        Set<PickupVehicle> pickupVehicles = new LinkedHashSet<>();
        for (int i = 1; i <= PICKUP_VEHICLES_NO; i++) {
            PickupVehicle pickupVehicle = new PickupVehicle(PICKUP_VEHICLE_MAX_PACKAGES);
            Address address = new Address("Country" + i, "City" + i, "Street" + i, "ZipCode" + i);
            Sender sender = new Sender("S" + i, address, "Phone"+i);
            Set<Package> packages = new HashSet<>();
            Package p = new Package("P" + i, sender, null);
            packages.add(p);
            pickupVehicle.addPackages(packages);
            pickupVehicles.add(pickupVehicle);
        }
        return pickupVehicles;
    }

    private static Set<DeliveryVehicle> createDeliveryVehicles() {
        Set<DeliveryVehicle> deliveryVehicles = new LinkedHashSet<>();
        for (int i = 1; i <= DELIVERY_VEHICLES_NO; i++) {
            DeliveryVehicle deliveryVehicle = new DeliveryVehicle(DELIVERY_VEHICLE_MAX_PACKAGES);
            deliveryVehicles.add(deliveryVehicle);
        }
        return deliveryVehicles;
    }

    private static Set<TransportVehicle> createTrucks() {
        Set<TransportVehicle> trucks = new LinkedHashSet<>();
        for (int i = 1; i <= TRANSPORT_VEHICLES_NO; i++) {
            TransportVehicle transportVehicle = new TransportVehicle(TRANSPORT_VEHICLE_MAX_PACKAGES);
            trucks.add(transportVehicle);
        }
        return trucks;
    }

    @Before
    public void setUp() {
        Set<PickupVehicle> pickupVehicles = createPickupVehicles();
        transportationVehicles.addAll(pickupVehicles);
        Set<DeliveryVehicle> deliveryVehicles = createDeliveryVehicles();
        transportationVehicles.addAll(deliveryVehicles);
        Set<TransportVehicle> transportVehicles = createTrucks();
        transportationVehicles.addAll(transportVehicles);
    }

    @Test
    public void writeTransportationVehicles() {
        try {
            Writer writer = new FileWriter("transportation_vehicles.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (TransportationVehicle transportationVehicle : transportationVehicles) {
                bufferedWriter.write(transportationVehicle.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


