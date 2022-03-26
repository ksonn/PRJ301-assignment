/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipment;

import dal.EquipmentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Equipment;

/**
 *
 * @author Administrator
 */
public class InsertEquipment extends HttpServlet {


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
        request.getRequestDispatcher("../view/clinic/equipment/addequip.jsp").forward(request, response);
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
        int eid = Integer.parseInt(request.getParameter("eid"));
        String ename_raw = request.getParameter("ename");
        String source_raw = request.getParameter("source");
        String status_raw = request.getParameter("status");
        String eprice_raw = request.getParameter("eprice");
        
        String ename = URLDecoder.decode(ename_raw, "UTF-8");
        String source = URLDecoder.decode(source_raw, "UTF-8");
        boolean status = status_raw.equals("good");
        float eprice = Float.parseFloat(eprice_raw);
        Equipment e = new Equipment();
        e.setEid(eid);
        e.setEname(ename);
        e.setEprice(eprice);
        e.setSource(source);
        e.setStatus(status);
        EquipmentDBContext db = new EquipmentDBContext();
        db.InsertEquipment(e);
        response.sendRedirect("list");
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
