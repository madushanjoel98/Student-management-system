/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.extra.uploads;

import com.sm.extra.file.File_locations;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author madushan
 */
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Image_uploader {
    
    public void upload(String perameter,String file_name,HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalStateException, ServletException{
        Part filePart=request.getPart("file");
      
         String fileName = filePart.getName();
         System.out.println("com.sm.extra.uploads.Image_uploader.upload()"+fileName);
         
    for (Part part : request.getParts()) {
      part.write(File_locations.getUPLOAD_DIR() + fileName);
    }
        System.out.println("com.sm.extra.uploads.Image_uploader.upload():The file uploaded sucessfully");
    response.getWriter().print("The file uploaded sucessfully.");
  }

    
    
}
