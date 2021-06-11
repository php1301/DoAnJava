/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Database;
import model.TheLoai;

/**
 *
 * @author Admin
 */
public class TheLoaiController {

    private Connection con;
    private List<TheLoai> listTheLoai;
    Database db = new Database();

    public TheLoaiController() {
        listTheLoai = new LinkedList<TheLoai>();
        System.out.println("Chay constructor TheLoai");
    }

    public List<TheLoai> layDanhSachTheLoai() throws SQLException {
        System.out.println("Lay danh sach phim");
        listTheLoai.clear();
        String sql = "select * from TheLoai order by maTheLoai";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maTheLoai = rs.getInt(1);
                String tenTheLoai = rs.getString(2);
                TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
                listTheLoai.add(tl);
            }
            return Collections.unmodifiableList(listTheLoai);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("close RS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("close PS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("close Conn TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    public void connect() throws SQLException {
        try {
            db.connect();
            String url = "jdbc:mysql://localhost:3306/doanjavalb";
            con = DriverManager.getConnection(url, "admin2", "java123");
            System.out.println("Connected " + con);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect() {
        db.disconnect();
    }

}
