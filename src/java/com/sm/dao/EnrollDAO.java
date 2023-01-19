/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.dao;

import com.sm.models.Batch;
import com.sm.models.Enroll;
import com.sm.models.StudentM;
import com.sm.sql.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madushan
 */
public class EnrollDAO {

    private final Connection connection = SQLConnection.getInstance().getConnection();

    //enroll_id, batch_id, student_id, course_id, enroll_date
    public boolean insert(Enroll student)  {

        String query = "Insert into student_mangment.enroll (batch_id, student_id, course_id) VALUES(?,?,?); ";
        try {

            boolean updator = false;
            ResultSet rs = null;
            PreparedStatement statement = null;
            statement = (PreparedStatement) connection.prepareStatement(query);
            statement.setInt(1, student.getBatch_ID());
            statement.setInt(2, student.getStudent_ID());
             statement.setInt(3, student.getCourse_ID());
           
            //  statement.setString(3, student.getDOB());
            
            statement.executeUpdate();
            updator = true;

            System.out.println("Enrolled");

            return updator;
        } catch (SQLException sq) {

            System.out.println("com.sm.dao.StudentDAO.insert():" + sq.getMessage());
            return false;
        } finally {
            //  connection.close();
        }
    }

    public StudentM selectstudent(int id) throws SQLException {
StudentM student=null;
        List<StudentM> liste = new ArrayList<>();
        Connection conn = null;
        conn = connection;
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
            liste.add(student);

        }

        return student;

    }
  public List<Enroll> selecteEnrolledCoursesBYStudent(int student_ID) throws SQLException {
      
        List<Enroll> liste = new ArrayList<>();
        Connection conn = null;
        conn = connection;
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.enroll where student_id="+student_ID+";";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//enroll_id, batch_id, student_id, course_id, enroll_date
        while (rs.next()) {
            Enroll enroll=new Enroll(rs.getInt("enroll_id"), rs.getInt("student_id"),  rs.getInt("batch_id"), rs.getInt("course_id"),  rs.getDate("enroll_date").toString());
          
                    
                    
            liste.add(enroll);

        }

        return liste;

    }
    
    public boolean update() {
        throw new UnsupportedOperationException("Not supbjeported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

       public boolean deleteBYid(int enrollID)  {

        String query = "delete FROM student_mangment.enroll where enroll_id="+enrollID+"; ";
        try {
            System.out.println("deleteQuery:"+query);
            boolean updator = false;
            ResultSet rs = null;       
            PreparedStatement pstatements=null;
          pstatements = (PreparedStatement) connection.prepareStatement(query);
         int i=pstatements.executeUpdate();
            
             if(i>0){
               updator = true;
                    System.out.println("Enroll deleted");
             } 
             
            //  statement.setString(3, student.getDOB());         
         
            return updator;
        } catch (SQLException sq) {

            System.out.println("Enroll delete Error:" + sq.getMessage());
            return false;
        } finally {
            //  connection.close();
        }
    }

}
