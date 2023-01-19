/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test;

import com.sm.jp.models.Student;
import com.sm.models.StudentM;
import com.sm.security.SHA_Encrpytion;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author madushan
 */
public class Bclass {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentManagmentPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
       String pass="123456";
       pass=SHA_Encrpytion.SHA_256gen(pass);
        System.out.println(pass);
    }
    
    
}
