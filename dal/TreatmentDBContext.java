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
import model.Treatment;

/**
 *
 * @author Administrator
 */
public class TreatmentDBContext extends DBContext {

    public Treatment getTreatmentByPid(int pid) {
        try {
            String sql = "SELECT [tid]\n"
                    + "      ,[doctor]\n"
                    + "      ,[diagnose]\n"
                    + "      ,[solution]\n"
                    + "  FROM [Treatment] WHERE tid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Treatment t = new Treatment();
                t.setTid(pid);
                t.setDoctor(rs.getString("doctor"));
                t.setDiagnose(rs.getString("diagnose"));
                t.setSolution(rs.getString("solution"));
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreatmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
