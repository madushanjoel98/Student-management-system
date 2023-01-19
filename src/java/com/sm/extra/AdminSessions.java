/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.extra;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author madushan
 */
public class AdminSessions {
    
    
    public static void adminSessionValidatin(HttpSession session, HttpServletResponse response,HttpServletRequest request) throws IOException{
        if(session.getAttribute("admin")!=null){
             System.out.println("session has");
       response.sendRedirect(request.getContextPath()+"/Home");
        }else  if(session.getAttribute("admin")==null){
            System.out.println("no session");
                     response.sendRedirect(request.getContextPath()+"/Admin-si");
         
        }
    
    }
    
    public static void adminSessionValidatinForHome(HttpSession session, HttpServletResponse response,HttpServletRequest request) throws IOException{
        if(session.getAttribute("admin")==null){
           
                     response.sendRedirect(request.getContextPath()+"/Admin-si");
         
        }
    
    }
}
