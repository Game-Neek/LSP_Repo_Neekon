// File: src/org/howard/edu/lsp/assignment3/PayrollCalculator.java
package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayrollCalculator {

    public void calculatePayroll(Employee emp) {
        double hoursWorked = emp.getHoursWorked();
        double hourlyRate = emp.getHourlyRate();
        double grossPayUnrounded;

        // Base Pay & Overtime
        if (hoursWorked <= 40.00) {
            grossPayUnrounded = hoursWorked * hourlyRate;
        } else {
            double overtimeHours = hoursWorked - 40.00;
            grossPayUnrounded = (40.00 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
        }

        // IT Department 5% Bonus
        if ("IT".equals(emp.getDepartment())) {
            grossPayUnrounded *= 1.05;
        }

        // Round GrossPay
        BigDecimal grossPayBD = BigDecimal.valueOf(grossPayUnrounded).setScale(2, RoundingMode.HALF_UP);
        double roundedGrossPay = grossPayBD.doubleValue();
        emp.setGrossPay(roundedGrossPay);

        // Determine PayLevel
        if (roundedGrossPay < 500.00) {
            emp.setPayLevel("Low");
        } else if (roundedGrossPay < 1000.00) {
            emp.setPayLevel("Standard");
        } else if (roundedGrossPay < 2000.00) {
            emp.setPayLevel("High");
        } else {
            emp.setPayLevel("Executive");
        }

        // Determine EmploymentStatus
        if (hoursWorked < 30.00) {
            emp.setEmploymentStatus("Part-Time");
        } else {
            emp.setEmploymentStatus("Full-Time");
        }
    }
}