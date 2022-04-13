//package com.company.DataExtract;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DataExtract {
//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://192.168.207.128/test?user=admin&password=********");
//            stmt = conn.createStatement();
//            String query = "INSERT INTO test" + "VALUES('dasd','asdasd',1,'adad')";
//            stmt.executeUpdate(query);
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            if (stmt != null) {
//                try {
//                    conn.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//        }
//        System.out.println("ALL done");
//    }
//}
