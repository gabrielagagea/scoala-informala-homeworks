package com.packagedelivery.model;

/**
 * The public class TrackingInfo. The users can see the tracking id and details about the packages
 */
public class TrackingInfo {

    private String id;
    private String details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
