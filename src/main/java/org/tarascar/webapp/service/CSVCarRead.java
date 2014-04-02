package org.tarascar.webapp.service;

import org.tarascar.webapp.models.Brand;
import org.tarascar.webapp.models.Car;
import org.tarascar.webapp.models.CarType;
import org.tarascar.webapp.models.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CSVCarRead {

    private final String resource;

    public CSVCarRead(String resource) {
        this.resource = resource;
    }

    public Set<Car> getAll() {
        Set<Car> cars = new HashSet<Car>();
        InputStream resourceAsStream = this.getClass().getResourceAsStream(resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                Car car = Car.getBuilder()
                        .setBrand(Brand.valueOf(parts[0]))
                        .setCarType(CarType.valueOf(parts[1]))
                        .setColor(Color.valueOf(parts[2]))
                        .setAge(Integer.parseInt(parts[3]))
                        .setbodyNumber(Integer.parseInt(parts[4]))
                        .build();
                cars.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}