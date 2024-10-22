






public class Employee {

    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double totalPay;
    private double regularPay;
    private double overtimePay;


    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay() {
        return totalPay = regularPay + overtimePay;
    }

    public double getRegularPay() {
        return payRate * regularPay;
    }

    public double getOvertimePay() {
        return (payRate*1.5) * overtimePay;
    }

}
