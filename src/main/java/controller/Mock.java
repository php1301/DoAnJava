///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import java.sql.PreparedStatement;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.Normalizer;
//import java.text.Normalizer.Form;
//import java.util.Collections;
//import java.util.Locale;
//import java.util.regex.Pattern;
//import model.Database;
//import model.Ghe;
//
///**
// *
// * @author Admin
// */
//public class GheController {
//
//    private Connection con;
//    private List<Ghe> listGhe;
//    Database db = new Database();
//
//    public GheController() {
//        listGhe = new LinkedList<Ghe>();
//        System.out.println("Chay constructor Ghe");
//    }
//
//
//    public void connect() throws SQLException {
//        try {
//            db.connect();
////            String url = "jdbc:mysql://localhost:3306/doanjavalb";
//            String remoteUrl = "jdbc:mysql://103.97.125.254:3306/doanjava_v1";
//            con = DriverManager.getConnection(remoteUrl, "doanjava", "a2DpigCp7PDOyGk");
//
////            String remoteUrl = "jdbc:mysql://remotemysql.com:3306/Rv7rkcnTMx";
////            con = DriverManager.getConnection(remoteUrl, "Rv7rkcnTMx", "ZJ0Pp56kEi");
//            System.out.println("Connected " + con);
//            System.out.println("Da connect");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            Logger.getLogger(GheController.class
//                    .getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    public void disconnect(ResultSet rs, PreparedStatement ps) {
//        if (rs != null) {
//            try {
//                rs.close();
//                System.out.println("close RS");
//            } catch (SQLException e) {
//                Logger.getLogger(GheController.class
//                        .getName()).log(Level.SEVERE, null, e);
//            }
//        }
//        if (ps != null) {
//            try {
//                ps.close();
//                System.out.println("close PS");
//            } catch (SQLException e) {
//                Logger.getLogger(GheController.class
//                        .getName()).log(Level.SEVERE, null, e);
//            }
//        }
//        if (con != null) {
//            try {
//                con.close();
//                System.out.println("close Conn");
//            } catch (SQLException e) {
//                Logger.getLogger(GheController.class
//                        .getName()).log(Level.SEVERE, null, e);
//            }
//        }
//    }
//}
