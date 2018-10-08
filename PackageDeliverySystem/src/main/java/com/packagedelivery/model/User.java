package com.packagedelivery.model;

/**
 * The public class User with id and name. They can see details regarding packages.
 * They can be simple users or administrators
 */
public class User {

    private String id;
    private String name;

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
