package com.packagedelivery.model;

/**
 * The public class User with id and name. They can see details regarding packages.
 * They can be simple users or administrators
 */
public class User {

    // Users are different. They have id and name attribute

    private String id;
    private String name;

    // Methods for getting and setting the id and the name

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
