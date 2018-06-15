package com.packagedelivery.model;

/**
 * We have public class Address with attributes: country, city, street and zipCode.
 * We can identify the contact and the destination
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipCode;
    //Methods for getting and setting the country, the city, the street and the zipCode.
    // Not sure yet which one will be use

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
