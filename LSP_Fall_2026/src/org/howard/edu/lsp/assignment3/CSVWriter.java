// File: src/org/howard/edu/lsp/assignment3/CSVWriter.java
package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CSVWriter {
    private int rowsTransformed = 0;

    public void writeEmployees(String filepath, List<Employee> employees) {
        File outputFile = new File(filepath);
        if (outputFile.getParentFile() != null) {
            outputFile.getParentFile().mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus");
            writer.newLine();

            for (Employee emp : employees) {
                String formattedHours = String.format(Locale.US, "%.2f", emp.getHoursWorked());
                String formattedRate = String.format(Locale.US, "%.2f", emp.getHourlyRate());
                String formattedGross = String.format(Locale.US, "%.2f", emp.getGrossPay());

                String outputLine = String.format(Locale.US, "%d,%s,%s,%s,%s,%s,%s,%s",
                        emp.getId(),
                        emp.getName(),
                        emp.getDepartment(),
                        formattedHours,
                        formattedRate,
                        formattedGross,
                        emp.getPayLevel(),
                        emp.getEmploymentStatus());

                writer.write(outputLine);
                writer.newLine();
                rowsTransformed++;
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

    public int getRowsTransformed() { return rowsTransformed; }
}