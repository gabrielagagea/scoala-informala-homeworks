package com.packagedelivery.model;

import java.util.Set;

/**
 * Class PackageDeliverySystem with the attributes: administrators, packages, facilities and filterQueue
 */
public class PackageDeliverySystem {

    private Set<User> administators;
    private Set<Package> packages;
    private Set<Facility> facilities;
    private FilterQueue filterQueue;

//Methods for setting or getting the administrators, packages, facilities and filterQueue

    public Set<User> getAdministators() {
        return administators;
    }

    public void setAdministators(Set<User> administators) {
        this.administators = administators;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }

    public FilterQueue getFilterQueue() {
        return filterQueue;
    }

    public void setFilterQueue(FilterQueue filterQueue) {
        this.filterQueue = filterQueue;
    }

    public TrackingInfo getTrackingInfo(String trackingId) {

        return null;
    }

    public void pickupPackage(String trackingId) {

    }

    public void addFacility(String town, Set<TransportationVehicle> transportationVehicles) {

    }

    public void removeFacility(String town) {

    }

}
