/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.extra.uploads;

import com.sm.extra.file.File_locations;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author madushan
 */
public class Uploader {

    private static final long serialVersionUID = 205242440643911308L;
    public static String UPLOAD_DIR = File_locations.getPROFILE_PIC_DIR();
    public  String last_name_of_file = "";
public static ArrayList<String>uploaded_list=new ArrayList<>();
    public boolean FileUploader(String file_name, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            uploaded_list.removeAll(uploaded_list);
            if(request.getPart("file")==null){
            return false;
            }
            
            // gets absolute path of the web application
            String applicationPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String uploadFilePath = UPLOAD_DIR;

            // creates the save directory if it does not exists
            File fileSaveDir = new File(uploadFilePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdirs();

            }
            System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

            String fileName = null;
            //Get all the parts from request and write it to the file on server
            for (Part part : request.getParts()) {
               if(getFileName(part, file_name)==null){return false;}
                fileName = getFileName(part, file_name);
                uploaded_list.add(fileName);
                part.write(uploadFilePath + File.separator + fileName);

            }
            request.setAttribute("SUP", fileName + " File uploaded successfully!");
            response.getWriter().print(request.getAttribute("message"));
            this.last_name_of_file = fileName;
  request.setAttribute("UEE", null);
            return true;
        } catch (Exception se) {
            System.out.println("Error:" + se.getMessage());
            request.setAttribute("UEE", se.getMessage());

           throw  new RuntimeException(se.getMessage());

        }

    }

    private String getFileName(Part part, String file_name) {
        String fileString = "";
        if (part == null) {
            return null;
        }
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                fileString = token.substring(token.indexOf("=") + 2, token.length() - 1);
                if (fileString.equals("")){ return null;}
                fileString.replaceAll(" ", "");
                fileString =  file_name+fileString;
                return fileString;
            }
        }
        return null;
    }

public void delete_uploadfiel(){
File file=new File(UPLOAD_DIR+last_name_of_file);
file.delete();
}

}
