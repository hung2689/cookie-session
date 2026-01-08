/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Login;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class LoginDAO extends DBContext {

    private final String GET_LOGIN_SQL = "SELECT [id]\n"
            + "      ,[username]\n"
            + "      ,[password]\n"
            + "  FROM [dbo].[login]";

    public List<Login> getListLogin() {
        List<Login> kq = new ArrayList<>();
        try (PreparedStatement stm = c.prepareStatement(GET_LOGIN_SQL)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Login l = new Login(rs.getString("id"), rs.getString("username"), rs.getString("password"));
                kq.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
}
