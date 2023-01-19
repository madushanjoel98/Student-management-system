/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.models;

/**
 *
 * @author madushan
 */
public class Courses {
    private int Course_ID;
     private String course_name;
private String description;
private double price;


    public Courses() {
    }

    public Courses(int Course_ID, String course_name, String description, double price) {
        this.Course_ID = Course_ID;
        this.course_name = course_name;
        this.description = description;
        this.price = price;
    }

  

    public Courses(int Course_ID) {
        this.Course_ID = Course_ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(int Course_ID) {
        this.Course_ID = Course_ID;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    
     
}
