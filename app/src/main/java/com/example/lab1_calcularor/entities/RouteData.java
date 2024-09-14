package com.example.lab1_calcularor.entities;

import java.io.Serializable;

public class RouteData implements Serializable {
    private String streetFrom;
    private String streetTo;
    private String houseFrom;
    private String houseTo;
    private String flatFrom;
    private String flatTo;

    public RouteData(String streetFrom, String streetTo, String houseFrom, String houseTo, String flatFrom, String flatTo) {
        this.streetFrom = streetFrom;
        this.streetTo = streetTo;
        this.houseFrom = houseFrom;
        this.houseTo = houseTo;
        this.flatFrom = flatFrom;
        this.flatTo = flatTo;
    }

    public String getStreetFrom() {
        return streetFrom;
    }

    public String getStreetTo() {
        return streetTo;
    }

    public String getHouseFrom() {
        return houseFrom;
    }

    public String getHouseTo() {
        return houseTo;
    }

    public String getFlatFrom() {
        return flatFrom;
    }

    public String getFlatTo() {
        return flatTo;
    }

    public void setStreetFrom(String streetFrom) {
        this.streetFrom = streetFrom;
    }

    public void setStreetTo(String streetTo) {
        this.streetTo = streetTo;
    }

    public void setHouseFrom(String houseFrom) {
        this.houseFrom = houseFrom;
    }

    public void setHouseTo(String houseTo) {
        this.houseTo = houseTo;
    }

    public void setFlatFrom(String flatFrom) {
        this.flatFrom = flatFrom;
    }

    public void setFlatTo(String flatTo) {
        this.flatTo = flatTo;
    }

    @Override
    public String toString() {
        return  "streetFrom='" + streetFrom + '\n' +
                "streetTo='" + streetTo + '\n' +
                "houseFrom='" + houseFrom + '\n' +
                "houseTo='" + houseTo + '\n' +
                "flatFrom='" + flatFrom + '\n' +
                "flatTo='" + flatTo;
    }
}
