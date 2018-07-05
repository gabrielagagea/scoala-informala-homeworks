package com.packagedelivery.model;

import java.util.LinkedList;
import java.util.List;

public class Route {
    private List<String> towns = new LinkedList<>();

    public String getDestination() {
        int townsNo = towns.size();
        return towns.get(townsNo - 1);
    }
}
