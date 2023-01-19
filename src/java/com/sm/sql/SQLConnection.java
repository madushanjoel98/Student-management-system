/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author madushan
 */
public class SQLConnection {
     private static SQLConnection dbconnection;
 private Connection connection;
	private static  final String username="root";
        private static  final String password="1234";
 private SQLConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	String url="jdbc:mysql://localhost:3306/student_mangment";
	try {
		//NX2mD5RD2waHg8v
		connection=DriverManager.getConnection(url,username,password);
		
	} catch (SQLException e) {
            
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public static SQLConnection getInstance()  {
		
		if(dbconnection==null) {
			dbconnection=new SQLConnection();
		}
		return dbconnection;
	}
	
	public Connection getConnection() {
		
		return connection;
	}
        
        public void close(){
         try {
             connection.close();
         } catch (SQLException ex) {
             Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
}
