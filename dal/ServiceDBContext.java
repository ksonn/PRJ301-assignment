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
import model.Service;

/**
 *
 * @author Administrator
 */
public class ServiceDBContext extends DBContext {

    public ArrayList<Service> getServiceByPid(int pid) {
        ArrayList<Service> services = new ArrayList<>();
        try {
            String sql = "select s.* from Service s \n"
                    + "  join Patient_Service ps On s.sid = ps.sid\n"
                    + "  join Patient p on p.pid = ps.pid\n"
                    + "  where p.pid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Service s = new Service();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setPrice(rs.getDouble("price"));
                services.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return services;
    }

    public void insertService(Service service) {
        String sql = "INSERT INTO [Service]\n"
                + "           ([sid]\n"
                + "           ,[sname]\n"
                + "           ,[price])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, service.getSid());
            stm.setString(2, service.getSname());
            stm.setDouble(3, service.getPrice());
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

    public void updateService(Service service) {
        String sql = "UPDATE [Service]\n"
                + "   SET [sname] = ?\n"
                + "      ,[price] = ?\n"
                + " WHERE sid = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(3, service.getSid());
            stm.setString(1, service.getSname());
            stm.setDouble(2, service.getPrice());
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
