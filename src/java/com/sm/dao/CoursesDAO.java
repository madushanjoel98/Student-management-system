/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.dao;

import com.sm.models.Branch;
import com.sm.models.Courses;
import com.sm.sql.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madushan
 */
public class CoursesDAO {

    private SQLConnection sqlcon = SQLConnection.getInstance();

    public List<Courses> branchlist() throws SQLException {

        List<Courses> liste = new ArrayList<>();
        Connection conn = null;
        conn = sqlcon.getConnection();
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.courses;";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//course_id, course_name, description, price
        while (rs.next()) {
            Courses courses = new Courses(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("description"), rs.getDouble("price"));
            liste.add(courses);

        }

        return liste;

    }

    public Courses selectCourseByID(int course_id) throws SQLException {

        Courses courses = null;
        Connection conn = null;
        conn = sqlcon.getConnection();
        ResultSet rs = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.courses where course_id=" + course_id + ";";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//course_id, course_name, description, price
        while (rs.next()) {
            courses = new Courses(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("description"), rs.getDouble("price"));

        }

        return courses;

    }
}
