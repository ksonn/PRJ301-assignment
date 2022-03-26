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
import model.Treatment;

/**
 *
 * @author Administrator
 */
public class TreatmentDBContext extends DBContext {

    public ArrayList<Treatment> getTreatmentByPid(int pid) {
        ArrayList<Treatment> list = new ArrayList<>();
        try {
            String sql = "SELECT [tid]\n"
                    + "      ,[doctor]\n"
                    + "      ,[diagnose]\n"
                    + "      ,[solution]\n"
                    + "  FROM [Treatment]";
            if (pid > 0) {
                sql += " WHERE tid = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (pid > 0) {
                stm.setInt(1, pid);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Treatment t = new Treatment();
                t.setTid(rs.getInt("tid"));
                t.setDoctor(rs.getString("doctor"));
                t.setDiagnose(rs.getString("diagnose"));
                t.setSolution(rs.getString("solution"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreatmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void InsertTreatment(Treatment t) {
        String sql = "INSERT INTO [Treatment]\n"
                + "           ([tid]\n"
                + "           ,[doctor]\n"
                + "           ,[diagnose]\n"
                + "           ,[solution])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, t.getTid());
            stm.setString(2, t.getDoctor());
            stm.setString(3, t.getDiagnose());
            stm.setString(4, t.getSolution());
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

    public void UpdateTreatment(Treatment t) {
        String sql = "UPDATE [Treatment]\n"
                + "   SET \n"
                + "      [doctor] = ?\n"
                + "      ,[diagnose] = ?\n"
                + "      ,[solution] = ?\n"
                + " WHERE [tid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(4, t.getTid());
            stm.setString(1, t.getDoctor());
            stm.setString(2, t.getDiagnose());
            stm.setString(3, t.getSolution());
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

    public ArrayList<Treatment> getListTreatment() {
        ArrayList<Treatment> treatments = new ArrayList<>();
        try {
            String sql = "SELECT [tid]\n"
                    + "      ,[doctor]\n"
                    + "      ,[diagnose]\n"
                    + "      ,[solution]\n"
                    + "  FROM [Treatment]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Treatment t = new Treatment();
                t.setTid(rs.getInt("tid"));
                t.setDoctor(rs.getString("doctor"));
                t.setDiagnose(rs.getString("diagnose"));
                t.setSolution(rs.getString("solution"));
                treatments.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreatmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return treatments;
    }

    public void deteleTreat(int tid) {
        String sql = "DELETE FROM [Treatment]\n"
                + "      WHERE tid = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, tid);
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
