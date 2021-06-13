/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        System.out.println("Lay danh sach the loai");
        listTheLoai.clear();
        String sql = "select * from TheLoai order by maTheLoai";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
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
            disconnect(rs, ps, con);
        }
    }
    
    public void themTheLoaiChoPhim(int maPhim, int[] tl, Connection conn) throws SQLException {
        System.out.println("Them The Loai Cho Phim");
        String sql = "insert into PhimTheLoai(maPhim, maTheLoai) values(?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i : tl) {
                ps.setInt(1, maPhim);
                ps.setInt(2, i + 1);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
            throw new SQLException();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("close RS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("close PS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public int[] layTheLoaiCuaPhim(Connection conn, int maPhim) throws SQLException {
        System.out.println("Lay danh sach the loai cua phim " + maPhim);
        listTheLoai.clear();
        String sql = "select maTheLoai from PhimTheLoai where maPhim = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> selected;
        selected = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhim);
            rs = ps.executeQuery();
            while (rs.next()) {
                int tl = rs.getInt(1);
                selected.add(tl - 1);
            }
            int[] array = selected.stream().mapToInt(i -> i).toArray();
            return array;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("close RS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("close PS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public void capNhatTheLoaiCuaPhim(int maPhim, int[] tl, Connection conn) throws SQLException {
        System.out.println("Cap Nhat The Loai Cho Phim");
        String sqlDeleteOld = "Delete from PhimTheLoai where maPhim = ?";
        String sqlUpdateNew = "insert into PhimTheLoai(maPhim, maTheLoai) values(?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Delete old PhimTheLoai
            ps = conn.prepareStatement(sqlDeleteOld);
            ps.setInt(1, maPhim);
            ps.executeUpdate();
            ps = conn.prepareStatement(sqlUpdateNew);
            for (int i : tl) {
                ps.setInt(1, maPhim);
                ps.setInt(2, i + 1);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
            throw new SQLException();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("close RS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("close PS TheLoai");
                } catch (SQLException e) {
                    Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public void connect() throws SQLException {
        try {
            db.connect();
            String url = "jdbc:mysql://localhost:3306/doanjavalb";
            String remoteUrl = "jdbc:mysql://103.97.125.254:3306/doanjava_v1";
            con = DriverManager.getConnection(remoteUrl, "doanjava", "a2DpigCp7PDOyGk");
            System.out.println("Connected " + con);
            System.out.println("Da connect the loai");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void disconnect(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS TheLoai");
            } catch (SQLException e) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS TheLoai");
            } catch (SQLException e) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
                System.out.println("close Conn TheLoai");
            } catch (SQLException e) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
