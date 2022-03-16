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
import model.Patient;
import model.Service;
import model.Treatment;

/**
 *
 * @author Administrator
 */
public class PatientDBContext extends DBContext {

    public ArrayList<Patient> getListPatient() {
        ArrayList<Patient> patients = new ArrayList<>();
        try {
            String sql = "SELECT [pid]\n"
                    + "      ,[pname]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[job]\n"
                    + "      ,[address]\n"
                    + "      ,[phone]\n"
                    + "      ,[cmnd]\n"
                    + "      ,[dayadd]\n"
                    + "      ,[reason]\n"
                    + "  FROM [Patient]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPid(rs.getInt("pid"));
                patient.setPname(rs.getString("pname"));
                patient.setGender(rs.getBoolean("gender"));
                patient.setDob(rs.getDate("dob"));
                patient.setJob(rs.getString("job"));
                patient.setAddress(rs.getString("address"));
                patient.setPhone(rs.getString("phone"));
                patient.setCMND(rs.getString("cmnd"));
                patient.setDayAdd(rs.getDate("dayadd"));
                patient.setReason(rs.getString("reason"));
                patients.add(patient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patients;
    }

    public Patient getPatientByID(int pid) {
        try {
            String sql = "SELECT "
                    + "      [pname]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[job]\n"
                    + "      ,[address]\n"
                    + "      ,[phone]\n"
                    + "      ,[cmnd]\n"
                    + "      ,[dayadd]\n"
                    + "      ,[reason]\n"
                    + "  FROM [Patient]\n"
                    + "  WHERE pid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPid(rs.getInt("pid"));
                patient.setPname(rs.getString("pname"));
                patient.setGender(rs.getBoolean("gender"));
                patient.setDob(rs.getDate("dob"));
                patient.setJob(rs.getString("job"));
                patient.setAddress(rs.getString("address"));
                patient.setPhone(rs.getString("phone"));
                patient.setCMND(rs.getString("cmnd"));
                patient.setDayAdd(rs.getDate("dayadd"));
                patient.setReason(rs.getString("reason"));
                ArrayList<Service> services = new ServiceDBContext().getServiceByPid(pid);
                patient.setServices(services);
                Treatment t = new TreatmentDBContext().getTreatmentByPid(pid);
                patient.setTreatment(t);
                return patient;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void InsertPatient(Patient p) {
        String sql = "INSERT INTO [Patient]\n"
                + "           ([pid]\n"
                + "           ,[pname]\n"
                + "           ,[gender]\n"
                + "           ,[dob]\n"
                + "           ,[job]\n"
                + "           ,[address]\n"
                + "           ,[phone]\n"
                + "           ,[cmnd]\n"
                + "           ,[dayadd]\n"
                + "           ,[reason])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
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
            stm.setInt(1, p.getPid());
            stm.setString(2, p.getPname());
            stm.setBoolean(3, p.isGender());
            stm.setDate(4, p.getDob());
            stm.setString(5, p.getJob());
            stm.setString(6, p.getAddress());
            stm.setString(7, p.getPhone());
            stm.setString(8, p.getCMND());
            stm.setString(9, p.getReason());
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

    public void deletePatient(int pid) {
        String sql = "DELETE FROM [Patient]\n"
                + "      WHERE pid = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
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
