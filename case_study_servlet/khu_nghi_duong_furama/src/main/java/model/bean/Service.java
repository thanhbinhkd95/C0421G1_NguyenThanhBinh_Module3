package model.bean;

public class Service {
    private int id;
    private String code;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private int rentTypeId;
    private String rentType;
    private int serviceTypeId;
    private String serviceType;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberFloor;

    public Service() {
    }

    public Service(int id, String code, String name, int area, double cost, int maxPeople, int rentTypeId, String rentType, int serviceTypeId, String serviceType, String standardRoom, String description, double poolArea, int numberFloor) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.rentType = rentType;
        this.serviceTypeId = serviceTypeId;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Service(int id, String code, String name, int area, double cost, int maxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String description, double poolArea, int numberFloor) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Service(String code, String name, int area, double cost, int maxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String description, double poolArea, int numberFloor) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
}
