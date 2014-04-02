package org.tarascar.webapp.service;

import org.tarascar.webapp.models.Car;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class CSVWriter {

    public static void writeFile(String filePath, Set<Car> set) throws IOException {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile());
            try {
                for (Car car : set) {
                    printWriter.print(car.toString());
                }
            } finally {
                printWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


