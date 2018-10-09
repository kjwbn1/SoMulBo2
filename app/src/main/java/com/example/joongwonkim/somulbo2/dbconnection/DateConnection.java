package com.example.joongwonkim.somulbo2.dbconnection;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.joongwonkim.somulbo2.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DateConnection {


//    Connection conn = null;
//    Statement stmt = null;
//
//    public void run() {
//
//        try {
//            Class.forName("com.mariadb.jdbc.Driver");
//
//            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root");
//            stmt = conn.createStatement();
//
//            String sql = "CREATE TABLE REGISTRATION "
//                    + "(id INTEGER not NULL, "
//                    + " first VARCHAR(255), "
//                    + " last VARCHAR(255), "
//                    + " age INTEGER, "
//                    + " PRIMARY KEY ( id ))";
//
//
//            stmt.executeUpdate(sql);
//        } catch (SQLException se) {
//
//            se.printStackTrace();
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }// do nothing
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//
////        }
//    }


}


