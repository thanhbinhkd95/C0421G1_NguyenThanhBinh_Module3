package model.bean;

public class Customer {
    private int id;
    private String code;
    private int customerTypeId;
    private String name;
    private String birthday;
    private int gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;
    private String customerType;
    private int contractId;
    private int contractDetailId;
    private String attachService;
    private double totalMoney;

    public Customer() {
    }

    public Customer(int id, String code, int customerTypeId, String name, String birthday, int gender, String idCard, String phone, String email, String address, String customerType) {
        this.id = id;
        this.code = code;
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Customer(String code, int customerTypeId, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        this.code = code;
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, String code, int customerTypeId, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        this.id = id;
        this.code = code;
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, String code, String name, String idCard, String address, int contractId, int contractDetailId, String attachService, double totalMoney) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.idCard = idCard;
        this.address = address;
        this.contractId = contractId;
        this.contractDetailId = contractDetailId;
        this.attachService = attachService;
        this.totalMoney = totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getAttachService() {
        return attachService;
    }

    public void setAttachService(String attachService) {
        this.attachService = attachService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
