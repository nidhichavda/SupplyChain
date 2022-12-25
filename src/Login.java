package com.example.supplychain;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;

public class Login {

    private byte[] getSha(String input){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
 private String getEncryptedPassword(String password)
    {
        try {
            BigInteger number = new BigInteger(1, getSha(password));
            StringBuilder hexString = new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean customerLogin(String email, String password)
    {
        String query = String.format("SELECT * FROM customer WHERE email = '%s' AND password ='%s'", email, password );
        try {
            DatabaseConnection dbConn = new DatabaseConnection();
            ResultSet rs = dbConn.getQueryTable(query);
            if (rs.next()) {
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Login login = new Login();
//        System.out.println(login.getEncryptedPassword("abc123"));

    }
}
