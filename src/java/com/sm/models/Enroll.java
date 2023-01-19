/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.models;

import com.sm.dao.BatchDAO;
import com.sm.dao.BranchDAO;
import com.sm.dao.CoursesDAO;
import com.sm.dao.StudentDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author madushan
 */
public class Enroll {
   //Coourse for student
    
    private int Enroll_ID;
   private int Student_ID;
   private int Batch_ID;
   private int Course_ID;
   private int Branch_id;
   private String Joindate;
   //entity
private StudentM student;
 private Batch batch;
private Courses courses;

    public Enroll() {
    }

   

    public Enroll(int Enroll_ID, int Student_ID, int Batch_ID, int Course_ID, String Joindate) throws SQLException {
         StudentDAO sdAO=new StudentDAO();
        BatchDAO batchDAO=new BatchDAO();
        this.Enroll_ID = Enroll_ID;
        this.Student_ID = Student_ID;
        this.Batch_ID = Batch_ID;
        this.Course_ID = Course_ID;
        this.Joindate = Joindate;
        this.batch=(Batch) batchDAO.BatchByID(Batch_ID);
        this.student=sdAO.selectstudent(Student_ID);
    }
    

    public Enroll(int Student_ID, int Batch_ID, int Course_ID, String Joindate) {
        
        this.Student_ID = Student_ID;
        this.Batch_ID = Batch_ID;
        this.Course_ID = Course_ID;
        this.Joindate = Joindate;
    }

    public int getBranch_id() {
        return Branch_id;
    }

    public void setBranch_id(int Branch_id) {
        this.Branch_id = Branch_id;
    }

    
    public Enroll(int Enroll_ID) {
        this.Enroll_ID = Enroll_ID;
    }

    public int getEnroll_ID() {
        return Enroll_ID;
    }

    public void setEnroll_ID(int Enroll_ID) {
        this.Enroll_ID = Enroll_ID;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public int getBatch_ID() {
        return Batch_ID;
    }

    public void setBatch_ID(int Batch_ID) {
        this.Batch_ID = Batch_ID;
    }

    public int getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(int Course_ID) {
        this.Course_ID = Course_ID;
    }

    public String getJoindate() {
        return Joindate;
    }

    public void setJoindate(String Joindate) {
        this.Joindate = Joindate;
    }

    public StudentM getStudent() {
        return student;
    }

    public void setStudent(StudentM student) {
        this.student = student;
    }


    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    


   
   
   
}
