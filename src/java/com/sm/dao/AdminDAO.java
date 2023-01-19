/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.dao;

import com.sm.models.AdminModel;
import com.sm.models.StudentM;
import com.sm.security.SHA_Encrpytion;
import com.sm.sql.SQLConnection;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author madushan
 */
public class AdminDAO {

    SQLConnection sqlc = SQLConnection.getInstance();

    public AdminModel login(String email, String password) {

        AdminModel admin = null;

        Connection conn = null;
        conn = sqlc.getConnection();
        try {
            password=SHA_Encrpytion.SHA_256gen(password);
            ResultSet rs = null;
            PreparedStatement statement = null;

            String query = "SELECT * FROM student_mangment.admin where email='"+email+"' and pasword='"+password+"';";

            System.out.println("Query" + query);

            statement = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query);
            // statement.setString(1, name);
            rs = statement.executeQuery(query);
//id_admin, emp_no, email, pasword, type, branch_id
            if (rs.next()) {
          admin=new AdminModel(rs.getInt("id_admin"), rs.getInt("emp_no"), rs.getInt("branch_id"),
                  0, rs.getString("email"), null);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
           // System.out.println("Error:" + e.());
            return null;
        } 
        return admin;

    }

}
