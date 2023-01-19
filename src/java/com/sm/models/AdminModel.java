/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.models;

/**
 *
 * @author madushan
 */
public class AdminModel {
   private int id_admin, emp_no,branch_id,type;
  private String email, pasword; 

    public AdminModel(int id_admin, int emp_no, int branch_id, int type, String email, String pasword) {
        this.id_admin = id_admin;
        this.emp_no = emp_no;
        this.branch_id = branch_id;
        this.type = type;
        this.email = email;
        this.pasword = pasword;
    }

    public AdminModel() {
    }

    public AdminModel(String email, String pasword) {
        this.email = email;
        this.pasword = pasword;
    }

    
    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
  
  
  
}
