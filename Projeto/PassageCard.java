public class PassageCard {

    private int id;
    private String name;
    private String email;
    private String phone;
    private double balance;

    public PassageCard(int id, String name, String email, String phone, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
