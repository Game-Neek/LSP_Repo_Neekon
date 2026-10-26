package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a contractor in the payroll system.
 * Contractors receive a 15% premium on their base hourly rate
 * for all hours worked.
 * 
 * @author Malik John
 */
public class Contractor extends Employee {

    /**
     * Constructs a Contractor with the specified hours worked and hourly rate.
     *
     * @param hoursWorked the number of hours the contractor worked
     * @param hourlyRate  the contractor's base hourly rate
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates the pay for a contractor.
     * Contractors receive their base pay plus a 15% premium (1.15 multiplier).
     *
     * @return the total calculated pay including the premium
     */
    @Override
    public double calculatePay() {
        return hoursWorked * hourlyRate * 1.15;
    }
}