/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.PatientController;

import dal.AppointmentDBContext;
import dal.PatientDBContext;
import dal.Patient_ServiceDBContext;
import dal.ServiceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Appointment;
import model.Patient;
import model.Service;

/**
 *
 * @author Administrator
 */
public class AddPatient extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Service> services = new ServiceDBContext().getListService();
        request.setAttribute("services", services);
        request.getRequestDispatcher("../view/clinic/patient/addpatient.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String id_raw = request.getParameter("pid");
        String name_raw = request.getParameter("pname");
        String dob_raw = request.getParameter("dob");
        String gender_raw = request.getParameter("gender");
        String job_raw = request.getParameter("job");
        String address_raw = request.getParameter("address");
        String phone_raw = request.getParameter("phone");
        String cmnd_raw = request.getParameter("cmnd");
        String reason_raw = request.getParameter("reason");
        String sid_raw = request.getParameter("sid");
        String sname_raw = request.getParameter("sname");
        String price_raw = request.getParameter("price");

        String address = URLDecoder.decode(address_raw, "UTF-8");
        String reason = URLDecoder.decode(reason_raw, "UTF-8");
        String name = URLDecoder.decode(name_raw, "UTF-8");
        String job = URLDecoder.decode(job_raw, "UTF-8");
        boolean gender = gender_raw.equals("male");
        Date dob = Date.valueOf(dob_raw);
        int pid = Integer.parseInt(id_raw);
        int sid = Integer.parseInt(sid_raw);
        double price = Double.parseDouble(price_raw);
        String sname = URLDecoder.decode(sname_raw, "UTF-8");
        Patient p = new Patient();
        p.setPid(pid);
        p.setPname(name);
        p.setGender(gender);
        p.setDob(dob);
        p.setJob(job);
        p.setAddress(address);
        p.setCMND(cmnd_raw);
        p.setPhone(phone_raw);
        p.setReason(reason);
        ArrayList<Service> services = new ArrayList<>();
        Service s = new Service();
        s.setSid(sid);
        s.setSname(sname);
        s.setPrice(price);
        services.add(s);
        p.setServices(services);
        new Patient_ServiceDBContext().insertServicesByPid(pid, services);
        PatientDBContext db = new PatientDBContext();
        db.InsertPatient(p);
        response.sendRedirect("../home");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
