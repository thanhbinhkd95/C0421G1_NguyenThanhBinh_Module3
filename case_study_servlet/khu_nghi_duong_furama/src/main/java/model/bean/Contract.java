package model.bean;

public class Contract {
    private int id;
    private String starDate;
    private String endDate;
    private double deposit;
    private double totalMoney;
    private int employeeId;
    private String employeeName;
    private int customerId;
    private String customerName;
    private int serviceId;
    private String serviceName;

    public Contract() {
    }

    public Contract(int id, String starDate, String endDate, double deposit, double totalMoney, int employeeId, String employeeName, int customerId, String customerName, int serviceId, String serviceName) {
        this.id = id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.customerId = customerId;
        this.customerName = customerName;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public Contract(String starDate, String endDate, double deposit, double totalMoney, int employeeId, int customerId, int serviceId) {
        this.starDate = starDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Contract(int id, String starDate, String endDate, double deposit, double totalMoney, int employeeId, int customerId, int serviceId) {
        this.id = id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

}
