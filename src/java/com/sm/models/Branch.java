/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.models;

/**
 *
 * @author madushan
 */
public class Branch {
   private long branch_id;
  private  String branch_location,  name;
public Branch(){}

    public Branch(long branch_id, String branch_location, String name) {
        this.branch_id = branch_id;
        this.branch_location = branch_location;
        this.name = name;
    }


  
  
    public long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(long branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_location() {
        return branch_location;
    }

    public void setBranch_location(String branch_location) {
        this.branch_location = branch_location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
  
}
