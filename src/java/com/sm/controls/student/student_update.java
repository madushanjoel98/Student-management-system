/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.sm.controls.student;

import com.sm.dao.StudentDAO;
import com.sm.models.StudentM;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author madushan
 */
@WebServlet(name = "su", urlPatterns = {"/su"})
public class student_update extends HttpServlet {
    private StudentDAO studentDAO=new StudentDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet student_update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet student_update at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        int action=Integer.valueOf(request.getParameter("action"));
        switch (action) {
            case 1:
                update(request, response);
                break;
            default:
               
        }
      
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

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
     if(request.getParameter("action")!=null){
      String lastname=  request.getParameter("lname");
        String firstname=  request.getParameter("fname");
        String DOB=  request.getParameter("dob");
        String email=  request.getParameter("email");
         String address=  request.getParameter("address");
         String mobile_no=  request.getParameter("mobi");
        String NIC=request.getParameter("nic");
        String gender=request.getParameter("gender");
        int sid=Integer.parseInt(request.getParameter("sid"));
        
         StudentM studentr=new StudentM(sid, firstname, lastname, 
                 DOB, address, mobile_no, NIC, gender, email);
     if(studentDAO.update(studentr)){
     response.sendRedirect(request.getContextPath()+"/student-view?msg=1&sid="+sid+"");
     }else{
     response.sendRedirect(request.getContextPath()+"/student-view?err=2&sid="+sid+"");
     }
     }
    }
}
