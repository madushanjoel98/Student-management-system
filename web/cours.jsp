<%-- 
    Document   : cours
    Created on : Nov 21, 2022, 12:33:35 PM
    Author     : madushan
--%>

<%@page import="com.sm.models.Batch"%>
<%@page import="com.sm.dao.BatchDAO"%>
<%@page import="com.sm.models.StudentM"%>
<%@page import="com.sm.dao.StudentDAO"%>
<%@page import="com.sm.models.Courses"%>
<%@page import="com.sm.dao.CoursesDAO"%>
<%@page import="com.sm.sql.SQLConnection"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="com.sm.dao.BranchDAO"%>
<%@page import="com.sm.models.Branch"%>
<%@page contentType="json" pageEncoding="UTF-8"%>
<%
    System.out.println("className.methodName()::Calling");
    BranchDAO bdao = new BranchDAO();
    CoursesDAO coursesDAO=new CoursesDAO();
    StudentDAO studentDAO=new StudentDAO();
    BatchDAO batchDAO=new BatchDAO();
     Gson json = new Gson();
    if (request.getParameter("action").equals("1")) {
        List<Branch> branchs = bdao.branchlist();
        System.out.println("className.methodName()"+branchs.isEmpty());
       
        String branch_list = json.toJson(branchs);

        // response.getWriter().write(branch_list);
        out.print(branch_list);
    }
    if(request.getParameter("action").equals("2")){
    List<Courses> courseses=coursesDAO.branchlist();
    
     String courselist = json.toJson(courseses);
       out.print(courselist);
    }
 if(request.getParameter("action").equals("3")&& request.getParameter("sid")!=null){
 int sid=Integer.parseInt(request.getParameter("sid"));
    StudentM students=studentDAO.selectstudent(sid);
    
     String courselist = json.toJson(students);
       out.print(courselist);
    }    
if(request.getParameter("action").equals("4")){
int cou_id=Integer.parseInt(request.getParameter("cr"));
int br_id=Integer.parseInt(request.getParameter("br"));
List<Batch> batchls=batchDAO.BatchBy(cou_id, br_id);
    
     String batchlist = json.toJson(batchls);
       out.print(batchlist);
    }
%>