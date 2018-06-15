package com.packagedelivery.model;

/**
 * Class Contact has the atributs: name, adress and phone
 */
public class Contact {
    private String name;
    private Address address;
    private String phone;

//Methods for getting and setting: the name, adress and the phone number

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}
