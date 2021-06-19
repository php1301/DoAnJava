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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Database;
import model.HeThongRap;

/**
 *
 * @author Trung
 */
public class HeThongRapController {
    private Connection con;
    private List<HeThongRap> listHeThongRap;
    Database db = new Database();

    public HeThongRapController() {
        listHeThongRap = new LinkedList<HeThongRap>();
        System.out.println("Chay constructor HeThongRap");
    }
    
    public List<HeThongRap> layDanhSachHeThongRap() throws SQLException {
        System.out.println("Lay danh sach he thong rap");
        listHeThongRap.clear();
        String sql = "select * from HeThongRap order by maHeThongRap";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maHeThongRap = rs.getString(1);
                String tenHeThongRap = rs.getString(2);
                String biDanh = rs.getString(3);
                String logo = rs.getString(4);
                HeThongRap hethongrap = new HeThongRap(maHeThongRap, tenHeThongRap, biDanh, logo);
                listHeThongRap.add(hethongrap);
            }
            return Collections.unmodifiableList(listHeThongRap);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(HeThongRapController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }
    
    public Object[] getThongTinHeThongRap(String maHeThongRapArg) throws SQLException {
        System.out.println("Lay thong tin he thong rap");
        String sql = "select * from HeThongRap where maHeThongRap = ?";
        System.out.println(maHeThongRapArg);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] o = new Object[4];
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, maHeThongRapArg);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
                o[0] = rs.getString(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
            }
            return o;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(HeThongRapController.class
                    .getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
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
            System.out.println("Da connect HeThongRap");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(HeThongRapController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS HeThongRap");
            } catch (SQLException e) {
                Logger.getLogger(HeThongRapController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS HeThongRap");
            } catch (SQLException e) {
                Logger.getLogger(HeThongRapController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn HeThongRap");
            } catch (SQLException e) {
                Logger.getLogger(HeThongRapController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
