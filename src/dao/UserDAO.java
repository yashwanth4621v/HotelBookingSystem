package dao;

import utils.DBUtil;
import java.sql.*;
import java.util.*;

public class UserDAO {
    public void addUser(String name, String email) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO users(name,email) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("✅ User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllUsers() {
        List<String> users = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                users.add(rs.getInt("user_id") + " - " + rs.getString("name") + " (" + rs.getString("email") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
