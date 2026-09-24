//Malik John LSP assignment3
package org.howard.edu.lsp.assignment3;

import java.util.List;

public class ETLPipeline {

    public static void main(String[] args) {
        String inputPath = "data/employees.csv";
        String outputPath = "data/transformed_employees.csv";

        // 1. Read Data
        CSVReader reader = new CSVReader();
        List<Employee> employees = reader.readEmployees(inputPath);

        // 2. Transform Data
        PayrollCalculator calculator = new PayrollCalculator();
        for (Employee emp : employees) {
            calculator.calculatePayroll(emp);
        }

        // 3. Load Data
        CSVWriter writer = new CSVWriter();
        writer.writeEmployees(outputPath, employees);

        // 4. Print Summary
        System.out.println("Rows read: " + reader.getRowsRead());
        System.out.println("Rows transformed: " + writer.getRowsTransformed());
        System.out.println("Rows skipped: " + reader.getRowsSkipped());
        System.out.println("Output file: " + outputPath);
    }
}