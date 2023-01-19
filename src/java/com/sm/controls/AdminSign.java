package com.sm.controls;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.sm.dao.AdminDAO;
import com.sm.models.AdminModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author madushan
 */
@WebServlet(name = "Admin-si", urlPatterns = {"/Admin-si"})
public class AdminSign extends HttpServlet {
    AdminDAO adminDAO=new AdminDAO();
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
            out.println("<title>Servlet AdminSign</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminSign at " + request.getContextPath() + "</h1>");
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
       request.getRequestDispatcher("admin-si.jsp").forward(request,response);
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
        int action=Integer.parseInt( request.getParameter("action"));
        
        switch (action) {
            case 1:
                login(request, response);
                break;
                case 2:
                request.getSession().removeAttribute("admin");
                response.sendRedirect(request.getContextPath()+"/Admin-si");
                break;
            default:
                  response.sendRedirect(request.getContextPath()+"/Admin-si?err=2");
        }
        if(action==1){
        login(request, response);
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

   public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try{
       HttpSession session=request.getSession();
   String email=request.getParameter("email");
   String password=request.getParameter("password");
  if( adminDAO.login(email, password)!=null){
      AdminModel admin=adminDAO.login(email, password);
       session.setAttribute("admin", admin);
       response.sendRedirect(request.getContextPath()+"/Home?ad="+admin.getId_admin());
  }else{
  response.sendRedirect(request.getContextPath()+"/Admin-si?err=1");
  }
   
   }catch(Exception ex){
  
   }
   }
}
