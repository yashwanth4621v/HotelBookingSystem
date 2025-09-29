package dao;

import utils.DBUtil;
import java.sql.*;
import java.util.*;

public class BookingDAO {
    public void createBooking(int userId, int roomId) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO bookings(user_id, room_id, booking_date) VALUES(?,?,CURDATE())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, roomId);
            ps.executeUpdate();

            // Mark room unavailable
            new RoomDAO().updateRoomAvailability(roomId, false);

            System.out.println("✅ Booking created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBookings() {
        List<String> bookings = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT b.booking_id, u.name, r.type, b.booking_date " +
                         "FROM bookings b JOIN users u ON b.user_id=u.user_id " +
                         "JOIN rooms r ON b.room_id=r.room_id";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bookings.add("Booking #" + rs.getInt("booking_id") +
                             " | User: " + rs.getString("name") +
                             " | Room: " + rs.getString("type") +
                             " | Date: " + rs.getDate("booking_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public void cancelBooking(int bookingId) {
        try (Connection conn = DBUtil.getConnection()) {
            String getRoom = "SELECT room_id FROM bookings WHERE booking_id=?";
            PreparedStatement ps1 = conn.prepareStatement(getRoom);
            ps1.setInt(1, bookingId);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                int roomId = rs.getInt("room_id");

                // Delete booking
                String sql = "DELETE FROM bookings WHERE booking_id=?";
                PreparedStatement ps2 = conn.prepareStatement(sql);
                ps2.setInt(1, bookingId);
                ps2.executeUpdate();

                // Set room available again
                new RoomDAO().updateRoomAvailability(roomId, true);

                System.out.println("✅ Booking cancelled successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
