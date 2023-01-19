/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sm.interfaces;

import java.util.ArrayList;

/**
 *
 * @author madushan
 */
public interface CURD {
    
    public boolean insert(Object object);
    public boolean update();
    public ArrayList<Object> read_byID(int ID);
    public boolean delete_by_id(int ID);
    
}
