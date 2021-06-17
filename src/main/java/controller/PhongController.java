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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
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
        listPhong.clear();
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

    public void themPhong(String tenPhong) throws SQLException {
        System.out.println("Them Phong chieu");
        String sql = "insert into Rap(tenRap, soGhe, maCumRap) values(?, 120, 'bhd-hvt')";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setString(col++, tenPhong);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                taoGheChoPhongChieu(generatedKeys.getInt(1), con);
            } else {
                throw new SQLException("Creating Phong failed, no ID obtained.");
            }
            con.commit();
        } catch (SQLException e) {
            Logger.getLogger(PhongController.class.getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }
    }

    public void xoaPhong(int maPhong) throws SQLException {
        System.out.println("Xoa Phong chieu");
        String sql = "Delete from Rap where maRap = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setInt(col++, maPhong);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            Logger.getLogger(PhongController.class.getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }
    }

    private void taoGheChoPhongChieu(int maPhongChieu, Connection conn) throws SQLException {
        System.out.println("Tao ghe cho phong chieu");
        String sql = "insert into Ghe(tenGhe, stt, maLoaiGhe, maRap) values(?, ?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> alpha = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        try {
            ps = conn.prepareStatement(sql);
            int stt = 1;
            for (String al : alpha) {
                for (int i = 1; i <= 12; i++) {
                    int col = 1;
                    ps.setString(col++, al + i);
                    ps.setInt(col++, stt);
                    ps.setInt(col++, randomInt());
                    ps.setInt(col++, maPhongChieu);
                    ps.executeUpdate();
                    stt++;
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(PhongController.class.getName()).log(Level.SEVERE, null, e);
            throw new SQLException();
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

    public int randomInt() {
        Random rn = new Random();
        int range = 2 - 1 + 1;
        int randomNum = rn.nextInt(range) + 1;
        return randomNum;
    }
}
