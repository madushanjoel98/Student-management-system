/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.extra.file;
import  java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author madushan
 */
public class Files_ident {
   private File file;
private String[] images_list={"jpg","png","gif","ttf","dng","JPEG","PNG","BIMP"};


    public Files_ident (File file) {
        this.file = file;
    }

    public String identy(){
  String fin=file.toString();
  int index=fin.lastIndexOf('.');
  if(index>0){
  
  String extention=fin.substring(index+1);
      List<String> imaList =new ArrayList<>(  Arrays.asList(images_list)) ;
      if(imaList.contains(extention)){
      return "img";
      }
  }
  return null;
    }
    
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
}
