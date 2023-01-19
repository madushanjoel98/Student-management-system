/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.dao;

import com.sm.models.StudentM;
import com.sm.sql.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.rmi.runtime.Log;

/**
 *
 * @author madushan
 */
public class StudentDAO {
    SQLConnection sqlc= SQLConnection.getInstance();
private int LAST_ID;
    //student_id, first_name, lastname, dob, address, image_namel, joindate, mobile_no, nic
    public boolean insert(StudentM student) {
Connection connection =sqlc.getConnection();
        String query = "Insert into student_mangment.student (first_name, lastname, dob, address, image_namel, mobile_no, nic,gender,email) VALUES(?,?,?,?,?,?,?,?,?); ";
        try {

            boolean updator = false;
           ResultSet rs=null;     
            PreparedStatement statement = null;
            statement = (PreparedStatement) connection.prepareCall(query);
            statement.setString(1, student.getFirst_name());
            statement.setString(2, student.getLast_name());
            java.sql.Date sqlDate = java.sql.Date.valueOf(student.getDOB()); //new java.sql.Date(dob.getDate());
            statement.setDate(3, sqlDate);
            //  statement.setString(3, student.getDOB());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getImage_location());
            statement.setString(6, student.getMobile_no());
            statement.setString(7, student.getNIC());
            statement.setString(8, student.getGender());
            statement.setString(9, student.getEmail());
           statement.executeUpdate();
            
    rs = statement.getGeneratedKeys();
    if(rs.next()){
    this.LAST_ID=rs.getInt(1);
    }
            updator = true;

            System.out.println("Reg");

            return updator;
        } catch (Exception sq) {

            System.out.println("com.sm.dao.StudentDAO.insert():" + sq.getMessage());
            return false;
        }
    }

    public StudentM selectstudent(int id) {
StudentM student=null;
       
        Connection conn = null;
        conn = sqlc.getConnection();
        try{
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.student where student_id="+id+";";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//student_id, first_name, lastname, dob, address, image_namel, joindate, mobile_no, nic, gender, email
        while (rs.next()) {
             student = new StudentM(rs.getInt("student_id"), rs.getString("first_name"),
                    rs.getString("lastname"),
                    rs.getDate("dob").toString(),
                    rs.getString("image_namel"),
                    rs.getString("address"),
                    rs.getString("mobile_no"), rs.getString("nic"),
                    rs.getString("gender"), rs.getString("email"));

        }
        }catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
            System.out.println("Error:"+e.getSQLState());
            student=null;
        }
        return student;

    }
 public List<StudentM >studentList() throws SQLException {
StudentM student=null;
        List<StudentM> liste = new ArrayList<>();
        Connection conn = null;
        conn = sqlc.getConnection();
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.student;";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//student_id, first_name, lastname, dob, address, image_namel, joindate, mobile_no, nic, gender, email
        while (rs.next()) {
             student = new StudentM(rs.getInt("student_id"), rs.getString("first_name"),
                    rs.getString("lastname"),
                    rs.getDate("dob").toString(),
                    rs.getString("image_namel"),
                    rs.getString("address"),
                    rs.getString("mobile_no"), rs.getString("nic"),
                    rs.getString("gender"), rs.getString("email"));
            liste.add(student);

        }

        return liste;

    }
 public List<StudentM >studentListSearch(String searchText)  {
StudentM student=null;
        List<StudentM> liste = new ArrayList<>();
        Connection conn = null;
        conn = sqlc.getConnection();
        ResultSet rs = null;
         try {
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.student where student_id='"+searchText+"' or concat(first_name,' ',lastname) like '%"+searchText+"%';";

        System.out.println("Query" + query);

       
            statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
       
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//student_id, first_name, lastname, dob, address, image_namel, joindate, mobile_no, nic, gender, email
        while (rs.next()) {
             student = new StudentM(rs.getInt("student_id"), rs.getString("first_name"),
                    rs.getString("lastname"),
                    rs.getDate("dob").toString(),
                    rs.getString("image_namel"),
                    rs.getString("address"),
                    rs.getString("mobile_no"), rs.getString("nic"),
                    rs.getString("gender"), rs.getString("email"));
            
            liste.add(student);

        }
 } catch (SQLException ex) {
             System.out.println("err:"+ex.getMessage());
        }
        return liste;

    }
    
public boolean update(StudentM student) {
Connection connection =sqlc.getConnection();
        String query = "UPDATE student_mangment.student set first_name=?, lastname=?,"
                + " dob=?, address=?, image_namel=?, mobile_no=?, nic=?,gender=?,"
                + "email=? where student_id="+student.getSTUDENT_ID()+" ";
        try {

            boolean updator = false;
           ResultSet rs=null;     
            PreparedStatement statement = null;
            statement = (PreparedStatement) connection.prepareCall(query);
            statement.setString(1, student.getFirst_name());
            statement.setString(2, student.getLast_name());
            java.sql.Date sqlDate = java.sql.Date.valueOf(student.getDOB()); //new java.sql.Date(dob.getDate());
            statement.setDate(3, sqlDate);
            //  statement.setString(3, student.getDOB());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getImage_location());
            statement.setString(6, student.getMobile_no());
            statement.setString(7, student.getNIC());
            statement.setString(8, student.getGender());
            statement.setString(9, student.getEmail());
           statement.executeUpdate();
            
    rs = statement.getGeneratedKeys();
    if(rs.next()){
    this.LAST_ID=rs.getInt(1);
    }
            updator = true;

            System.out.println("Reg");

            return updator;
        } catch (Exception sq) {

            System.out.println("com.sm.dao.StudentDAO.insert():" + sq.getMessage());
            return false;
        }
    }
    

    public int getLAST_ID() {
        return LAST_ID;
    }

}
