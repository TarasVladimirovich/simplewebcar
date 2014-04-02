package org.tarascar.webapp.service;

import org.tarascar.webapp.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CSVFilePersonService {

    private final String resource;

    public CSVFilePersonService(String resource) {
        this.resource = resource;
    }

    public Set<User> getAll() {
        Set<User> persons = new HashSet<User>();
        InputStream resourceAsStream = this.getClass().getResourceAsStream(resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                User person = User.getBuilder()
                        .withLog(parts[0])
                        .withPass((parts[1]))
                        .build();
                persons.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}