package com.packagedelivery.model;

/**
 * Public class Package. The class has a trackingId, sender and destination attribute
 */

public class Package {
    private String trackingId;
    private Sender sender;
    private Destination destination;

//Methods for getting and setting the trackingId, sender and destination

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
}

