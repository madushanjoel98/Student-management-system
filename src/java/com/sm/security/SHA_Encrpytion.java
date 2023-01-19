/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.sm.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class SHA_Encrpytion {
    
    private String orginal_Text;
    
    private static SHA_Encrpytion obj;
    
    private SHA_Encrpytion() {
        
    }
    
    public static SHA_Encrpytion getInstance() {
        
        if (obj == null) {
            obj = new SHA_Encrpytion();
        }
        return obj;
    }

//SHA_256 genarater
    public String SHA_256(String text) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("sha-256");
        m.reset();
       // text = this.orginal_Text;
        m.update(text.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInteger = new BigInteger(1, digest);
        String hash = bigInteger.toString(16);
        
        return hash;
        
    }
public static String SHA_256gen(String text) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("sha-256");
        m.reset();
       // text = this.orginal_Text;
        m.update(text.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInteger = new BigInteger(1, digest);
        String hash = bigInteger.toString(16);
        
        return hash;
        
    }

    //SHA_256 Validator 
    public  Boolean SHA_256_valid(String pass, String SHA_256) throws NoSuchAlgorithmException {
        return SHA_256(pass).equals(SHA_256);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SHA_Encrpytion other = (SHA_Encrpytion) obj;
        return Objects.equals(this.orginal_Text, other.orginal_Text);
    }
    
}
