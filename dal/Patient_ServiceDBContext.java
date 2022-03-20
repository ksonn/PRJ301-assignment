/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Service;

/**
 *
 * @author Administrator
 */
public class Patient_ServiceDBContext extends DBContext {

    public void insertServicesByPid(int pid, ArrayList<Service> services) {
        String sql = "INSERT INTO [Patient_Service]\n"
                + "           ([pid]\n"
                + "           ,[sid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            for (Service service : services) {
                stm.setInt(1, pid);
                stm.setInt(2, service.getSid());
                stm.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient_ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
