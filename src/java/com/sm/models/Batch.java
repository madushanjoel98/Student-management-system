/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.models;

import com.sm.dao.BranchDAO;
import com.sm.dao.CoursesDAO;
import com.sm.dao.StudentDAO;
import java.sql.SQLException;

/**
 *
 * @author madushan
 */
public class Batch {

    private int Batch_NO;
    private int Course_ID;
    private int Branch_id;
    private String batch_name;
    private String batch_start;
    private String batch_close_date;
    private String batch_END_DATE;
    private Courses courses;
    private Branch branch;

    public Batch() throws SQLException {
    }

    public Batch(int Batch_NO, int Course_ID, int Branch_id, String batch_start, String batch_close_date, String batch_END_DATE,String batchname) throws SQLException {
        CoursesDAO cdao = new CoursesDAO();
        BranchDAO bdao = new BranchDAO();
        this.Batch_NO = Batch_NO;
        this.batch_name=batchname;
        this.Course_ID = Course_ID;
        this.Branch_id = Branch_id;
        this.batch_start = batch_start;
        this.batch_close_date = batch_close_date;
        this.batch_END_DATE = batch_END_DATE;
        this.courses = cdao.selectCourseByID(Course_ID);
        this.branch = bdao.selectBranchByID(Branch_id);
    }

    public Branch getBranch() {
        return branch;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public int getBatch_NO() {
        return Batch_NO;
    }

    public void setBatch_NO(int Batch_NO) {
        this.Batch_NO = Batch_NO;
    }

    public int getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(int Course_ID) {
        this.Course_ID = Course_ID;
    }

    public int getBranch_id() {
        return Branch_id;
    }

    public void setBranch_id(int Branch_id) {
        this.Branch_id = Branch_id;
    }

    public String getBatch_start() {
        return batch_start;
    }

    public void setBatch_start(String batch_start) {
        this.batch_start = batch_start;
    }

    public String getBatch_close_date() {
        return batch_close_date;
    }

    public void setBatch_close_date(String batch_close_date) {
        this.batch_close_date = batch_close_date;
    }

    public String getBatch_END_DATE() {
        return batch_END_DATE;
    }

    public void setBatch_END_DATE(String batch_END_DATE) {
        this.batch_END_DATE = batch_END_DATE;
    }

}
