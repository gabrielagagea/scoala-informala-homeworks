package com.packagedelivery.serializable;

import com.packagedelivery.model.Address;
import com.packagedelivery.model.Destination;
import com.packagedelivery.model.Package;
import com.packagedelivery.model.Sender;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.Set;

public class PackagesSerializableTest {
    private static final int PACKAGES_NO = 10;
    private Set<Package> packages = new LinkedHashSet<>();

    private static Set<Package> createPackages() {
        Set<Package> packages = new LinkedHashSet<>();

        for (int i = 1; i <= PACKAGES_NO; i++) {
            Address a = new Address("Country" + i, "City" + i, "Street" + i, "ZipCode" + i);
            Sender s = new Sender("S" + i, a, "Phone" + i);
            Address a2 = new Address("Country2" + i, "City2" + i, "Street2" + i, "ZipCode2" + i);
            Destination d = new Destination("D" + i, a2, "Phone2" + i);
            Package p = new Package("Id" + i, s, d);
            packages.add(p);
        }
        return packages;
    }

    @Before
    public void setUp() {
        packages = createPackages();
    }

    @Test
    public void writePackages() {
        try {
            Writer writer = new FileWriter("packages.csv");
            BufferedWriter bf = new BufferedWriter(writer);
            for (Package p : packages) {
                bf.write(p.toString());
                bf.newLine();
            }
            bf.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
