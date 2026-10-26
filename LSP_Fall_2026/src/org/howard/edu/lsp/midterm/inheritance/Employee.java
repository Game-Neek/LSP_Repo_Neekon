package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a generic employee in the payroll system.
 * This abstract class serves as the base for specific employee types,
 * maintaining shared data and defining the contract for pay calculation.
 * 
 * @author [Your Name Here]
 */
public abstract class Employee {
    protected double hoursWorked;
    protected double hourlyRate;

    /**
     * Constructs an Employee with the specified hours worked and hourly rate.
     *
     * @param hoursWorked the number of hours the employee worked (assumed nonnegative)
     * @param hourlyRate  the employee's hourly pay rate (assumed nonnegative)
     */
    public Employee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Gets the number of hours worked by the employee.
     *
     * @return the hours worked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Sets the number of hours worked by the employee.
     *
     * @param hoursWorked the hours worked to set
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Gets the hourly pay rate of the employee.
     *
     * @return the hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Sets the hourly pay rate of the employee.
     *
     * @param hourlyRate the hourly rate to set
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Calculates the total pay for the employee based on their specific
     * employment type rules.
     *
     * @return the calculated total pay
     */
    public abstract double calculatePay();
}