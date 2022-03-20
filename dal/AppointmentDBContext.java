/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Appointment;

/**
 *
 * @author Administrator
 */
public class AppointmentDBContext extends DBContext {

    public ArrayList<Appointment> getListAppointment() {
        ArrayList<Appointment> list = new ArrayList<>();
        try {
            String sql = "SELECT [hname]\n"
                    + "      ,[hdob]\n"
                    + "      ,[hgender]\n"
                    + "      ,[haddress]\n"
                    + "      ,[hphone]\n"
                    + "      ,[email]\n"
                    + "      ,[daysend]\n"
                    + "      ,[note]\n"
                    + "  FROM [Appointment]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Appointment a = new Appointment();
                a.setHname(rs.getString("hname"));
                a.setHdob(rs.getDate("hdob"));
                a.setHgender(rs.getBoolean("hgender"));
                a.setHaddress(rs.getString("haddress"));
                a.setHphone(rs.getString("hphone"));
                a.setEmail(rs.getString("email"));
                a.setDaysend(rs.getDate("daysend"));
                a.setNote(rs.getString("note"));
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void InsertAppointment(Appointment a) {
        String sql = "INSERT INTO [Appointment]\n"
                + "           ([hname]\n"
                + "           ,[hdob]\n"
                + "           ,[hgender]\n"
                + "           ,[haddress]\n"
                + "           ,[hphone]\n"
                + "           ,[email]\n"
                + "           ,[daysend]\n"
                + "           ,[note])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,convert(date,GETDATE())\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, a.getHname());
            stm.setDate(2, a.getHdob());
            stm.setBoolean(3, a.isHgender());
            stm.setString(4, a.getHaddress());
            stm.setString(5, a.getHphone());
            stm.setString(6, a.getEmail());
            stm.setString(7, a.getNote());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void DeteleAppointment(String day) {
        String sql = "DELETE FROM [Appointment]\n"
                + "      WHERE hphone = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, day);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
