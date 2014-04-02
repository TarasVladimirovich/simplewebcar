package org.tarascar.webapp.models;

public enum Age {

    NEW, MIDDLE, OLD;

    public static Age fromValue(int age) {
        if (age < 1) {
            return NEW;
        }
        if (age <= 5) {
            return MIDDLE;
        }
        return OLD;
    }

}
