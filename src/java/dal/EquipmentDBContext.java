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
import model.Equipment;

/**
 *
 * @author Administrator
 */
public class EquipmentDBContext extends DBContext {

    public ArrayList<Equipment> getListEquipment() {
        ArrayList<Equipment> equipments = new ArrayList<>();
        try {
            String sql = "SELECT [eid]\n"
                    + "      ,[ename]\n"
                    + "      ,[source]\n"
                    + "      ,[status]\n"
                    + "      ,[eprice]\n"
                    + "      ,[inputday]\n"
                    + "  FROM [Equipment]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Equipment equipment = new Equipment();
                equipment.setEid(rs.getInt("eid"));
                equipment.setEname(rs.getString("ename"));
                equipment.setSource(rs.getString("source"));
                equipment.setStatus(rs.getBoolean("status"));
                equipment.setEprice(rs.getFloat("eprice"));
                equipment.setInputday(rs.getDate("inputday"));
                equipments.add(equipment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipments;
    }

    public void InsertEquipment(Equipment e) {
        String sql = "INSERT INTO [Equipment]\n"
                + "           ([eid]\n"
                + "           ,[ename]\n"
                + "           ,[source]\n"
                + "           ,[status]\n"
                + "           ,[eprice]\n"
                + "           ,[inputday])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,convert(date, GETDATE()))";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            
            stm.setInt(1, e.getEid());
            stm.setString(2, e.getEname());
            stm.setBoolean(4, e.isStatus());
            stm.setFloat(5, e.getEprice());
            stm.setString(3, e.getSource());
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

    public void deleteEquipment(int eid) {
        String sql = "DELETE FROM [Equipment]\n"
                + "      WHERE eid = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, eid);
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
