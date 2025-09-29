package hotel_booking_system.models;

public class User {
    private String userId;
    private String name;
    private String contact;

    public User(String userId, String name, String contact) {
        this.userId = userId;
        this.name = name;
        this.contact = contact;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
