/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.dao;

import com.sm.models.Branch;
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
public class BranchDAO {

    private SQLConnection sqlcon = SQLConnection.getInstance();

    public List<Branch> branchlist() throws SQLException {

        List<Branch> liste = new ArrayList<>();
        Connection conn = null;
        conn = sqlcon.getConnection();
        boolean updator = false;
        ResultSet rs = null;
        String AuthKey = "";
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.branch;";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//branch_id, branch_location, name
        while (rs.next()) {
            Branch branch = new Branch(rs.getInt("branch_id"), rs.getString("branch_location"), rs.getString("name"));
            liste.add(branch);
            System.out.println("*" + AuthKey);
        }

        return liste;

    }

    public Branch selectBranchByID(int id) throws SQLException {

        Branch branch = null;
        Connection conn = null;
        conn = sqlcon.getConnection();
        boolean updator = false;
        ResultSet rs = null;
        String AuthKey = "";
        PreparedStatement statement = null;

        String query = "SELECT * FROM student_mangment.branch where branch_id=" + id + ";";

        System.out.println("Query" + query);

        statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
        // statement.setString(1, name);
        rs = statement.executeQuery(query);
//branch_id, branch_location, name
        while (rs.next()) {
            branch = new Branch(rs.getInt("branch_id"), rs.getString("branch_location"), rs.getString("name"));

            System.out.println("*" + AuthKey);
        }

        return branch;

    }

}
