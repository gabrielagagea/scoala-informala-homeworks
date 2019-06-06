package com.packagedelivery.model;

/**
 * The public class TrackingInfo. The users can see the tracking id and details about the packages
 */
public class TrackingInfo {

    //attributes id and details for getting the TrackingInfo

    private String id;
    private String details;

// I have here lots of methods. I'm not sure jet which one will be use

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
