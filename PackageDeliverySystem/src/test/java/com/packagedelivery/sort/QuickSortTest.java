package com.packagedelivery.sort;

import com.packagedelivery.model.Address;
import com.packagedelivery.model.Destination;
import com.packagedelivery.model.Package;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void quicksortIntegers() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        QuickSort<Integer> quickSort = new QuickSort<>(comparator);
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(1);
        integers.add(5);
        integers.add(7);
        integers.add(3);
        integers.add(9);
        integers.add(2);
        List<Integer> sortedIntegers = quickSort.quicksort(integers);
        assertEquals(1, sortedIntegers.get(0).longValue());
        assertEquals(10, sortedIntegers.get(integers.size() - 1).longValue());

    }

    @Test
    public void quicksortPackages() {
        Comparator<Package> comparator = new Comparator<Package>() {
            @Override
            public int compare(Package p1, Package p2) {
                String destinationCity1 = getDestinationCity(p1);
                String destinationCity2 = getDestinationCity(p2);
                if (destinationCity1 != null) {

                    return destinationCity1.compareTo(destinationCity2);
                } else if (destinationCity2 != null) {
                    return -1;
                }
                return 0;
            }

            private String getDestinationCity(Package p) {
                if (p.getDestination() != null) {
                    Address address = p.getDestination().getAddress();
                    if (address != null) {
                        String city = address.getCity();
                        if (city != null) {
                            return city;
                        }
                    }
                }
                return null;
            }
        };
        QuickSort<Package> quickSort = new QuickSort<>(comparator);
        List<Package> packages = new ArrayList<>();
        Address address = new Address("Country", "City", "Street", "ZipCode");
        Destination destination = new Destination("Name", address, "Phone");
        Package p = new Package("P1", null, destination);

        Address address2 = new Address("Country2", "City2", "Street2", "ZipCode2");
        Destination destination2 = new Destination("Name2", address2, "Phone2");
        Package p2 = new Package("P2", null, destination2);


        Address address3 = new Address("Country3", "City3", "Street3", "ZipCode3");
        Destination destination3 = new Destination("Name3", address3, "Phone3");
        Package p3 = new Package("P3", null, destination3);

        packages.add(p2);
        packages.add(p);
        packages.add(p3);

        List<Package> sortedPackages = quickSort.quicksort(packages);
        assertEquals(p, sortedPackages.get(0));
        assertEquals(p3, sortedPackages.get(packages.size() - 1));

    }
}