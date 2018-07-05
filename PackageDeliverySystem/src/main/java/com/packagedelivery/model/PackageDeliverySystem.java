package com.packagedelivery.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Class PackageDeliverySystem with the attributes: administrators, packages, facilities and filterQueue
 */
public class PackageDeliverySystem {

    private Set<User> administators = new HashSet<>();
    private Set<Package> packages = new HashSet<>();
    private Set<Facility> facilities = new HashSet<>();
    private FilterQueue filterQueue = new FilterQueue();

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    private Set<Route> routes = new HashSet<>();

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

    private Package getPackageByTrackingId(String trackingId) {
        for (Package p : packages) {
            if (p.getTrackingId().equals(trackingId)) {
                return p;
            }
        }

        return null;
    }

    public void pickupPackage(String trackingId) throws Exception {

        Package p = getPackageByTrackingId(trackingId);
        if (p == null) {
            throw new PackageDeliveryException("Invalid tracking Id");
        }
        Route packageRoute = p.getRoute();
        if(!routes.contains(packageRoute)){
            throw new PackageDeliveryException("Invalid package route");
        }
    }

    public void addFacility(String town, Set<TransportationVehicle> transportationVehicles) {

    }

    public void removeFacility(String town) {

    }

}
