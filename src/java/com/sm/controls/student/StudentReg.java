/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.sm.controls.student;

import com.sm.dao.StudentDAO;
import com.sm.extra.uploads.Image_uploader;
import com.sm.models.StudentM;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;

/**
 *
 * @author madushan
 */

@WebServlet(name = "student-reg", urlPatterns = {"/student-reg"})
@MultipartConfig(
fileSizeThreshold = 1024*1024,
maxFileSize = 1024*1024*1000, maxRequestSize = 1024*1024*1000
)
public class StudentReg extends HttpServlet {
public static ArrayList<StudentM> arraystudent=new ArrayList<>();
   private StudentDAO dAO=new StudentDAO();
   private Image_uploader uploader=new Image_uploader();
   private final long serial=1l;
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
            out.println("<title>Servlet StudentReg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentReg at " + request.getContextPath() + "</h1>");
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
       request.getRequestDispatcher("StudentReg.jsp").forward(request,response);
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
         PrintWriter out = response.getWriter();
          response.setContentType("text/html;charset=UTF-8");
         
      String lastname=  request.getParameter("lname");
        String firstname=  request.getParameter("fname");
        String DOB=  request.getParameter("dob");
        String email=  request.getParameter("email");
         String address=  request.getParameter("address");
         String mobile_no=  request.getParameter("mobi");
        String NIC=request.getParameter("nic");
        String gender=request.getParameter("gender");
     
        
       // String image_location=  request.getParameter("file");
  
         StudentM student=new StudentM(firstname, lastname, DOB, null, address, mobile_no, NIC, gender,email);
       
         if(dAO.insert(student)){
             response.sendRedirect(request.getContextPath()+"/student-reg?messag="+dAO.getLAST_ID()+"");
             request.getSession().setAttribute("su", "Student("+student.getFirst_name()+") Registered");
                  request.getSession().setAttribute("ID", ""+dAO.getLAST_ID()+"");
         }else{
             
             // uploader.delete_uploadfiel();
             request.getSession().setAttribute("error", "invalids register");
             response.sendRedirect(request.getContextPath()+"/student-reg?messag=2");
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

    private void processFormField(FileItem item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
