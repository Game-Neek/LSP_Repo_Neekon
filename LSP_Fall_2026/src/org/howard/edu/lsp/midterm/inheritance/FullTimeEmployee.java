package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a full-time employee in the payroll system.
 * Full-time employees receive standard pay for up to 40 hours,
 * and time-and-a-half (1.5x) for any overtime hours worked beyond 40.
 * 
 * @author Malik John
 */
public class FullTimeEmployee extends Employee {

    /**
     * Constructs a FullTimeEmployee with the specified hours worked and hourly rate.
     *
     * @param hoursWorked the number of hours the employee worked
     * @param hourlyRate  the employee's standard hourly pay rate
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates the pay for a full-time employee.
     * Includes standard pay for the first 40 hours and 1.5x overtime pay
     * for any hours exceeding 40.
     *
     * @return the total calculated pay
     */
    @Override
    public double calculatePay() {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyRate;
        } else {
            double standardPay = 40 * hourlyRate;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * (hourlyRate * 1.5);
            return standardPay + overtimePay;
        }
    }
}