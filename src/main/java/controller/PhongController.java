/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import model.Database;
import model.Ghe;
import model.Phong;

/**
 *
 * @author Admin
 */
public class PhongController {

    private Connection con;
    private List<Ghe> listGhe;
    private List<Phong> listPhong;
    Database db = new Database();

    public PhongController() {
        listGhe = new LinkedList<Ghe>();
        listPhong = new LinkedList<Phong>();

        System.out.println("Chay constructor Phong");
    }

    public List<Ghe> layDanhSachGheCuaPhong() throws SQLException {
        System.out.println("Lay danh sach ghe cua phong");
        listGhe.clear();
        String sql = "select * from Ghe where maRap = 3 order by stt";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maGhe = rs.getInt(1);
                String tenGhe = rs.getString(2);
                int stt = rs.getInt(3);
                int maLoaiGhe = rs.getInt(4);
                int maRap = rs.getInt(5);
                Ghe g = new Ghe(maGhe, tenGhe, stt, maLoaiGhe, maRap);
                listGhe.add(g);
            }
            return Collections.unmodifiableList(listGhe);
        } catch (SQLException e) {
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public List<Phong> layDanhSachPhong() throws SQLException {
        System.out.println("Lay danh sach phong chieu");
        listGhe.clear();
        String sql = "select * from Rap where maCumRap = 'bhd-hvt' order by maRap";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maRap = rs.getInt(1);
                String tenRap = rs.getString(2);
                int soGhe = rs.getInt(3);
                String maCumRap = rs.getString(4);
                Phong p = new Phong(maRap, tenRap, soGhe, maCumRap);
                listPhong.add(p);
            }
            return Collections.unmodifiableList(listPhong);
        } catch (SQLException e) {
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public void connect() throws SQLException {
        try {
            db.connect();
            String remoteUrl = "jdbc:mysql://103.97.125.254:3306/doanjava_v1";
            con = DriverManager.getConnection(remoteUrl, "doanjava", "a2DpigCp7PDOyGk");
            System.out.println("Connected " + con);
            System.out.println("Da connect");
        } catch (Exception e) {
            Logger.getLogger(PhongController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS");
            } catch (SQLException e) {
                Logger.getLogger(PhongController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS");
            } catch (SQLException e) {
                Logger.getLogger(PhongController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn");
            } catch (SQLException e) {
                Logger.getLogger(PhongController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
