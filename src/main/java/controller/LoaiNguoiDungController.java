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
import model.LoaiNguoiDung;

/**
 *
 * @author Trung
 */
public class LoaiNguoiDungController {
    private Connection con;
    List<LoaiNguoiDung> listLoaiNguoiDung;
    Database db = new Database();
    
    public LoaiNguoiDungController() {
        listLoaiNguoiDung = new LinkedList<LoaiNguoiDung>();
        System.out.println("Chay constructor LoaiNguoiDung");
    }
    
    public List<LoaiNguoiDung> LayDanhSachLoaiNguoiDung() throws SQLException {
        System.out.println("Lay danh sach loai nguoi dung");
        listLoaiNguoiDung.clear();
        String sql = "select * from LoaiNguoiDung order by maLoaiNguoiDung";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
                connect();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {                
                int maLoaiNguoiDung = rs.getInt(1);
                String tenLoai = rs.getString(2);
                LoaiNguoiDung loainguoidung = new LoaiNguoiDung(maLoaiNguoiDung, tenLoai);
                listLoaiNguoiDung.add(loainguoidung);
            }
            return Collections.unmodifiableList(listLoaiNguoiDung);
        } catch (SQLException e) {
            Logger.getLogger(LoaiNguoiDungController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        finally {
            disconnect(rs, ps);
        }
    }
    
    public Object[] getThongTinLoaiNguoiDung(int maLoaiNguoiDungArg) throws SQLException {
        System.out.println("Lay thong tin loai nguoi dung");
        String sql = "select * from LoaiNguoiDung where maLoaiNguoiDung = ?";
        System.out.println(maLoaiNguoiDungArg);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] o = new Object[10];
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, maLoaiNguoiDungArg);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
            }
            return o;
        } catch (SQLException e) {
            Logger.getLogger(LoaiNguoiDungController.class
                    .getName()).log(Level.SEVERE, null, e);
            return null;
        }
        finally {
            disconnect(rs, ps);
        }
    }
    
    public void connect() throws SQLException {
        try {
            db.connect();
            String url = "jdbc:mysql://localhost:3306/doanjavalb";
            String remoteUrl = "jdbc:mysql://103.97.125.254:3306/doanjava_v1";
            con = DriverManager.getConnection(remoteUrl, "doanjava", "a2DpigCp7PDOyGk");
            System.out.println("Connected " + con);
            System.out.println("Da connect LoaiNguoiDung");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LoaiNguoiDungController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS LoaiNguoiDung");
            } catch (SQLException e) {
                Logger.getLogger(LoaiNguoiDungController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS LoaiNguoiDung");
            } catch (SQLException e) {
                Logger.getLogger(LoaiNguoiDungController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn LoaiNguoiDung");
            } catch (SQLException e) {
                Logger.getLogger(LoaiNguoiDungController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
