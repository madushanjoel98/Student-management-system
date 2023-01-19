/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test;

import com.google.gson.Gson;
import com.sm.dao.BatchDAO;
import com.sm.dao.BranchDAO;
import com.sm.models.Batch;
import com.sm.models.Branch;
import com.sm.models.Enroll;
import java.lang.annotation.Annotation;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.management.Query;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;

/**
 *
 * @author madushan
 */
@ServiceMode
public class Test implements ServiceMode {

    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, InterruptedException {
        Gson json=new Gson();
      
       Batch batch=new Batch(0, 2, 2, "2020-06-06", "2020-07-05", "2021-12-06", "Test");
       BatchDAO batchDAO=new BatchDAO();
       batchDAO.insert(batch);
     

      
        

    }

    public void run() {
        System.out.println("com.test.Test.run()");
    }

    @Override
    public Service.Mode value() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
