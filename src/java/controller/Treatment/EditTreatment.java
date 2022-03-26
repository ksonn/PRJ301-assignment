/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Treatment;

import dal.TreatmentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Treatment;

/**
 *
 * @author Administrator
 */
public class EditTreatment extends HttpServlet {

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

        String pid = request.getParameter("pid");
        if (pid == null || pid.length() == 0) {
            int tid = Integer.parseInt(request.getParameter("tid"));
//            tid = tid == null? 1:tid;
            TreatmentDBContext db = new TreatmentDBContext();
            ArrayList<Treatment> list = db.getTreatmentByPid(tid);
            request.setAttribute("list", list);
            request.getRequestDispatcher("../view/clinic/treatment/edit.jsp").forward(request, response);
        }
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
        request.setCharacterEncoding("utf-8");
        int tid = Integer.parseInt(request.getParameter("tid"));
        String doctor = request.getParameter("doctor");
        String diagnose = request.getParameter("diagnose");
        String solution = request.getParameter("solution");
        Treatment treatment = new Treatment();
        treatment.setTid(tid);
        treatment.setDoctor(doctor);
        treatment.setDiagnose(diagnose);
        treatment.setSolution(solution);
        TreatmentDBContext db = new TreatmentDBContext();
        db.UpdateTreatment(treatment);
        response.sendRedirect("search");
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
