package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class ETLPipeline {

    public static void main(String[] args) {
        // Relative file paths according to technical contract
        String inputPath = "data/employees.csv";
        String outputPath = "data/transformed_employees.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.err.println("Error: Input file not found at relative path " + inputPath);
            return;
        }

        // Ensure target output directory exists
        File outputFile = new File(outputPath);
        if (outputFile.getParentFile() != null) {
            outputFile.getParentFile().mkdirs();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Read header row (do not count as a data row read or transformed)
            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.err.println("Error: Input file is empty.");
                return;
            }

            // Write CSV output header
            writer.write("EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus");
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                // Split fields by comma (use -1 limit to keep trailing empty strings)
                String[] fields = line.split(",", -1);

                // Row skipping rule: must contain exactly 5 comma-separated fields
                if (fields.length != 5) {
                    rowsSkipped++;
                    continue;
                }

                // Step 1: Trim whitespace around every field
                String idStr = fields[0].trim();
                String nameStr = fields[1].trim();
                String deptStr = fields[2].trim();
                String hoursStr = fields[3].trim();
                String rateStr = fields[4].trim();

                // Step 2: Validate numeric values
                int employeeID;
                double hoursWorked;
                double hourlyRate;

                try {
                    employeeID = Integer.parseInt(idStr);
                    hoursWorked = Double.parseDouble(hoursStr);
                    hourlyRate = Double.parseDouble(rateStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }

                // Validate non-negative numbers
                if (hoursWorked < 0 || hourlyRate < 0) {
                    rowsSkipped++;
                    continue;
                }

                // Transformations
                String upperName = nameStr.toUpperCase();

                // Step 3: Base Pay & Overtime Calculation (using unrounded rates)
                double grossPayUnrounded;
                if (hoursWorked <= 40.00) {
                    grossPayUnrounded = hoursWorked * hourlyRate;
                } else {
                    double overtimeHours = hoursWorked - 40.00;
                    grossPayUnrounded = (40.00 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
                }

                // Step 4: IT Department 5% Bonus (applied after overtime)
                if ("IT".equals(deptStr)) {
                    grossPayUnrounded = grossPayUnrounded * 1.05;
                }

                // Step 5: Round GrossPay using RoundingMode.HALF_UP
                BigDecimal grossPayBD = BigDecimal.valueOf(grossPayUnrounded)
                        .setScale(2, RoundingMode.HALF_UP);
                double roundedGrossPay = grossPayBD.doubleValue();

                // Step 6: Determine PayLevel using final rounded GrossPay
                String payLevel;
                if (roundedGrossPay < 500.00) {
                    payLevel = "Low";
                } else if (roundedGrossPay < 1000.00) {
                    payLevel = "Standard";
                } else if (roundedGrossPay < 2000.00) {
                    payLevel = "High";
                } else {
                    payLevel = "Executive";
                }

                // Step 7: Determine EmploymentStatus using HoursWorked
                String employmentStatus;
                if (hoursWorked < 30.00) {
                    employmentStatus = "Part-Time";
                } else {
                    employmentStatus = "Full-Time";
                }

                // Format numeric outputs to exactly 2 decimal places
                String formattedHours = String.format(Locale.US, "%.2f", hoursWorked);
                String formattedRate = String.format(Locale.US, "%.2f", hourlyRate);
                String formattedGross = String.format(Locale.US, "%.2f", grossPayBD);

                // Construct output row
                String outputLine = String.format(Locale.US, "%d,%s,%s,%s,%s,%s,%s,%s",
                        employeeID, upperName, deptStr, formattedHours, formattedRate, formattedGross, payLevel, employmentStatus);

                writer.write(outputLine);
                writer.newLine();

                rowsTransformed++;
            }

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            return;
        }

        // Print Run Summary to Console
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + outputPath);
    }
}
