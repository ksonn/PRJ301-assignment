/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Appointment;

import dal.AppointmentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Appointment;

/**
 *
 * @author Administrator
 */
public class GetAppointment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/appointment.jsp").forward(request, response);
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
        String name_raw = request.getParameter("hname");
        String dob_raw = request.getParameter("hdob");
        String gender_raw = request.getParameter("hgender");
        String address_raw = request.getParameter("haddress");
        String phone_raw = request.getParameter("hphone");
        String email_raw = request.getParameter("email");
        String note_raw = request.getParameter("note");
        
        String name = URLDecoder.decode(name_raw, "UTF-8");
        String address = URLDecoder.decode(address_raw, "UTF-8");
        String note = URLDecoder.decode(note_raw, "UTF-8");
        boolean gender = gender_raw.equals("male");
        Date dob = Date.valueOf(dob_raw);
        Appointment a = new Appointment();
        a.setHname(name);
        a.setHdob(dob);
        a.setHgender(gender);
        a.setHaddress(address);
        a.setHphone(phone_raw);
        a.setEmail(email_raw);
        a.setNote(note);
        AppointmentDBContext db = new AppointmentDBContext();
        db.InsertAppointment(a);
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
