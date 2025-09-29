package hotel_booking_system.main;

import dao.*;
import java.util.*;

public class HotelBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        RoomDAO roomDAO = new RoomDAO();
        BookingDAO bookingDAO = new BookingDAO();

        while (true) {
            System.out.println("\n--- Hotel Booking System ---");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Add Room");
            System.out.println("4. View Available Rooms");
            System.out.println("5. Create Booking");
            System.out.println("6. View All Bookings");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    userDAO.addUser(name, email);
                    break;

                case 2:
                    System.out.println("Users: " + userDAO.getAllUsers());
                    break;

                case 3:
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    roomDAO.addRoom(type, price, true);
                    break;

                case 4:
                    System.out.println("Available Rooms: " + roomDAO.getAvailableRooms());
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    System.out.print("Enter Room ID: ");
                    int roomId = sc.nextInt();
                    bookingDAO.createBooking(userId, roomId);
                    break;

                case 6:
                    System.out.println("Bookings: " + bookingDAO.getAllBookings());
                    break;

                case 7:
                    System.out.print("Enter Booking ID to cancel: ");
                    int bookingId = sc.nextInt();
                    bookingDAO.cancelBooking(bookingId);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
