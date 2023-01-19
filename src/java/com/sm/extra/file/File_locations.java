/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.extra.file;

/**
 *
 * @author madushan
 */
public class File_locations {
 private static String UPLOAD_DIR = "G:\\Madushan\\document\\java project\\Check\\web\\files\\";
private static String PROFILE_PIC_DIR="G:\\Madushan\\document\\java project\\StudentManagment\\web\\propic\\";

    public static String getPROFILE_PIC_DIR() {
        return PROFILE_PIC_DIR;
    }

    public static void setPROFILE_PIC_DIR(String PROFILE_PIC_DIR) {
        File_locations.PROFILE_PIC_DIR = PROFILE_PIC_DIR;
    }


    public static String getUPLOAD_DIR() {
        return UPLOAD_DIR;
    }

    public static void setUPLOAD_DIR(String UPLOAD_DIR) {
        File_locations.UPLOAD_DIR = UPLOAD_DIR;
    }
 
 
}
