package hotel_booking_system.models;

public class RoomBooking {
    private User user;
    private Room room;
    private String startDate;
    private String endDate;

    public RoomBooking(User user, Room room, String startDate, String endDate) {
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double calculateTotalPrice() {
        return room.getPrice() * 2; // Hardcoded 2-day stay for simplicity
    }

    @Override
    public String toString() {
        return "Booking Confirmed!\nUser: " + user.getName() + "\nRoom ID: " +
                room.getRoomId() + "\nStay Dates: " + startDate + " - " + endDate +
                "\nTotal Price: ₹" + calculateTotalPrice();
    }
}
