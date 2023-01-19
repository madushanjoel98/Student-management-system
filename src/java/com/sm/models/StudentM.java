/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.models;

import com.sm.security.SHA_Encrpytion;

/**
 *
 * @author madushan
 */
public class StudentM {
    private int STUDENT_ID;
    private String first_name;
    private String last_name;
    private String DOB;
    private String image_location;
    private String address;
    private String mobile_no;
    private String NIC;
    private String gender;
    private String email;
    public StudentM(){}

    public StudentM(int STUDENT_ID, String first_name, String last_name, String DOB, String image_location, String address, String mobile_no, String NIC, String gender, String email) {
        this.STUDENT_ID = STUDENT_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.image_location = image_location;
        this.address = address;
        this.mobile_no = mobile_no;
        this.NIC = NIC;
        this.gender = gender;
        this.email = email;
    }

    public StudentM(String first_name, String last_name, String DOB, String image_location, String address, String mobile_no, String NIC, String gender,String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.image_location = image_location;
        this.address = address;
        this.mobile_no = mobile_no;
        this.NIC = NIC;
        this.gender = gender;
        this.email=email;
    }

    public StudentM(int STUDENT_ID, String first_name, String last_name, String DOB, String address, String mobile_no, String NIC, String gender, String email) {
        this.STUDENT_ID = STUDENT_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.address = address;
        this.mobile_no = mobile_no;
        this.NIC = NIC;
        this.gender = gender;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   
  
    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
 
 

    public int getSTUDENT_ID() {
        return STUDENT_ID;
    }

    public void setSTUDENT_ID(int STUDENT_ID) {
        this.STUDENT_ID = STUDENT_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String lirst_name) {
        this.first_name = lirst_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getImage_location() {
        return image_location;
    }

    public void setImage_location(String image_location) {
        this.image_location = image_location;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    
    
   
    
}
