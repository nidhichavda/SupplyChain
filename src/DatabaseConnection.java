package com.example.supplychain;

import java.sql.*;

//for more detail watch major project lec 2 time: 1:20
public class DatabaseConnection {
    private static final String databaseurl ="jdbc:mysql://localhost:3006/supplychain";
    private static final String userName="root";
    private static final String password="Nidhi@123";

    public Statement getStatement(){
        Connection conn;
        Statement statement = null;
        try{
            conn = DriverManager.getConnection(databaseurl,userName, password);
            statement = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        return statement;
    }


    public ResultSet getQueryTable(String query)
            // resultset return a tabel as the name suggest
            //if query runs successfully then it will return tabel
    {
        Statement statement = getStatement();//getstatement return statement above function.
        try{
            return statement.executeQuery(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpadateQuery(String query)

    {
        Statement statement = getStatement();
        try{
            return statement.executeUpdate(query);

        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
//    public static void main(String[] args) {
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        ResultSet rs = databaseConnection.getQueryTable("SELECT email, first_name FROM CUSTOMER");
//        try{
//            while(rs.next()){
//                System.out.println(rs.getString("email")+" "+ rs.getString("first_name"));
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}

