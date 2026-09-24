// File: src/org/howard/edu/lsp/assignment3/CSVReader.java
package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private int rowsRead = 0;
    private int rowsSkipped = 0;

    public List<Employee> readEmployees(String filepath) {
        List<Employee> employees = new ArrayList<>();
        File inputFile = new File(filepath);

        if (!inputFile.exists()) {
            System.err.println("Error: Input file not found at relative path " + filepath);
            return employees;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.err.println("Error: Input file is empty.");
                return employees;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",", -1);
                if (fields.length != 5) {
                    rowsSkipped++;
                    continue;
                }

                String idStr = fields[0].trim();
                String nameStr = fields[1].trim();
                String deptStr = fields[2].trim();
                String hoursStr = fields[3].trim();
                String rateStr = fields[4].trim();

                try {
                    int employeeID = Integer.parseInt(idStr);
                    double hoursWorked = Double.parseDouble(hoursStr);
                    double hourlyRate = Double.parseDouble(rateStr);

                    if (hoursWorked < 0 || hourlyRate < 0) {
                        rowsSkipped++;
                        continue;
                    }

                    employees.add(new Employee(employeeID, nameStr, deptStr, hoursWorked, hourlyRate));
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
        return employees;
    }

    public int getRowsRead() { return rowsRead; }
    public int getRowsSkipped() { return rowsSkipped; }
}