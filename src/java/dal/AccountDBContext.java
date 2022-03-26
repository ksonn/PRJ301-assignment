/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Administrator
 */
public class AccountDBContext extends DBContext {

    public Account getAccount(String username, String pass) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[doctorname]\n"
                    + "  FROM [Account] Where username = ? AND password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setDoctorname(rs.getString("doctorname"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int checkRole(String username, String url) {
        try {
            String sql = "SELECT COUNT(*) as Total \n" +
                "	FROM Account a INNER JOIN Account Group ag ON a.username = ag.username\n" +
                "					INNER JOIN [Group] g ON ag.gid = g.gid\n" +
                "					INNER JOIN Access Rights ar ON ar.gid = g.gid\n" +
                "					INNER JOIN Feature f ON f.fid = ar.fid\n" +
                "	WHERE a.username = ? AND f.url = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2, url);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                return rs.getInt("Total");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
