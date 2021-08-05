public class Customer {
    private String name;
    private String birthday;
    private String address;
    private String img;

    public Customer() {
    }

    public Customer(String name, String birthday, String address, String img) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getImg() {
        return img;
    }
}
