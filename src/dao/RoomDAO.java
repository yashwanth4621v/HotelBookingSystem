package dao;

import utils.DBUtil;
import java.sql.*;
import java.util.*;

public class RoomDAO {
    public void addRoom(String type, double price, boolean available) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO rooms(type, price, available) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            ps.setDouble(2, price);
            ps.setBoolean(3, available);
            ps.executeUpdate();
            System.out.println("✅ Room added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAvailableRooms() {
        List<String> rooms = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM rooms WHERE available=true";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                rooms.add(rs.getInt("room_id") + " - " + rs.getString("type") + " - ₹" + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public void updateRoomAvailability(int roomId, boolean available) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "UPDATE rooms SET available=? WHERE room_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, available);
            ps.setInt(2, roomId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
