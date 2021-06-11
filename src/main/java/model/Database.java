/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import java.sql.Connection;

public class Database {

    private Connection con;

    public Database() {
//		people = new LinkedList<Person>();
    }

    public void connect() throws Exception {
        if (con != null) {
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }
    }

//    public void disconnect() {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                System.out.println("Can't close connection");
//            }
//        }
//    }
}
