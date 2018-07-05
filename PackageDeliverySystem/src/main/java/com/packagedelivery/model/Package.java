package com.packagedelivery.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Public class Package. The class has a trackingId, sender and destination attribute
 */

public class Package {
    private String trackingId;
    private Sender sender;
    private Destination destination;
    private Route route;

    public Package(String trackingId, Sender sender, Destination destination) {
        this.trackingId = trackingId;
        this.sender = sender;
        this.destination = destination;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}


