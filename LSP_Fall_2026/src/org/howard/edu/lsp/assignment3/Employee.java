
package org.howard.edu.lsp.assignment3;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double hoursWorked;
    private double hourlyRate;
    private double grossPay;
    private String payLevel;
    private String employmentStatus;

    public Employee(int id, String name, String department, double hoursWorked, double hourlyRate) {
        this.id = id;
        // Business rule from original script: uppercase names
        this.name = name.toUpperCase();
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getHoursWorked() { return hoursWorked; }
    public double getHourlyRate() { return hourlyRate; }
    
    public double getGrossPay() { return grossPay; }
    public void setGrossPay(double grossPay) { this.grossPay = grossPay; }
    
    public String getPayLevel() { return payLevel; }
    public void setPayLevel(String payLevel) { this.payLevel = payLevel; }
    
    public String getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; }
}