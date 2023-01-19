/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.dao;

import com.sm.models.Batch;
import com.sm.models.StudentM;
import com.sm.sql.SQLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author madushan
 */
public class BatchDAO {

    private final Connection connection = SQLConnection.getInstance().getConnection();

    public boolean insert(Batch batch) throws SQLException {
        boolean updator = false;
//batch_id, course_id, start_date, close_date, end_date, Batch name, branch_id
        String query = "Insert into student_mangment.batch(course_id,branch_id, start_date, close_date, end_date,Batch_name)"
                + " VALUES(?,?,?,?,?,?); ";
        try {

            ResultSet rs = null;
            PreparedStatement statement = null;
            statement = (PreparedStatement) connection.prepareStatement(query);
            statement.setInt(1, batch.getCourse_ID());
            statement.setInt(2, batch.getBranch_id());
            statement.setDate(3, Date.valueOf(batch.getBatch_start()));
            statement.setDate(4, Date.valueOf(batch.getBatch_close_date()));
            statement.setDate(5, Date.valueOf(batch.getBatch_END_DATE()));
            statement.setString(6, batch.getBatch_name());
            statement.executeUpdate();
            updator = true;

            return updator;

        } catch (SQLException sq) {

            System.out.println("com.sm.dao.StudentDAO.insert():" + sq.getMessage());
            return false;
        } finally {
            connection.close();
        }

    }

    public List<Batch> BatchBy(int course_id,int branchID) throws SQLException {
      
        List<Batch> liste = new ArrayList<>();
        Connection conn = null;
        conn = connection;
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.batch where branch_id="+branchID+" and course_id="+course_id+" and close_date > date(now());";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//batch_id, Batch_name, branch_id, course_id, start_date, close_date, end_date
        while (rs.next()) {
    Batch batch=new Batch(rs.getInt("batch_id"), rs.getInt("course_id"),
            rs.getInt("branch_id"), rs.getDate("start_date").toString(), 
            rs.getDate("close_date").toString(), rs.getDate("end_date").toString(), 
            rs.getString("Batch_name"));
            liste.add(batch);

        }

        return liste;

    }
     
    public Batch BatchByID(int batch_ID) throws SQLException {
      
         Batch batch=null;
        Connection conn = null;
        conn = connection;
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.batch where batch_id="+batch_ID+";";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//batch_id, Batch_name, branch_id, course_id, start_date, close_date, end_date
        while (rs.next()) {
     batch=new Batch(rs.getInt("batch_id"), rs.getInt("course_id"),
            rs.getInt("branch_id"), rs.getDate("start_date").toString(), 
            rs.getDate("close_date").toString(), rs.getDate("end_date").toString(), 
            rs.getString("Batch_name"));
          

        }

        return batch;

    }

    public boolean batchClosedayVALIDATION(int batchID){
    boolean catcher=false;
    try {
    Connection conn = null;
        conn = connection;
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.batch where batch_id="+batchID+" and close_date < date(now());";

        System.out.println("Query" + query);

        
            statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//batch_id, Batch_name, branch_id, course_id, start_date, close_date, end_date
        if (rs.next()) {
     catcher=true;

        }

     } catch (SQLException ex) {
           catcher=false;
        }
    
    return catcher;
    
    }

}
