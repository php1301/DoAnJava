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
import model.CumRap;
import model.Database;

/**
 *
 * @author Trung
 */
public class CumRapController {
    private Connection con;
    private List<CumRap> listCumRap;
    Database db = new Database();

    public CumRapController() {
        listCumRap = new LinkedList<CumRap>();
        System.out.println("Chay constructor CumRap");
    }
    
    public List<CumRap> layDanhSachCumRap() throws SQLException {
        System.out.println("Lay danh sach cum rap");
        listCumRap.clear();
        String sql = "select * from CumRap order by maCumRap";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maCumRap = rs.getString(1);
                String tenCumRap = rs.getString(2);
                String thongTin = rs.getString(3);
                String maHeThongRap = rs.getString(4);
                CumRap cumrap = new CumRap(maCumRap, tenCumRap, thongTin, maHeThongRap);
                listCumRap.add(cumrap);
            }
            return Collections.unmodifiableList(listCumRap);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CumRapController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }
    
    public Object[] getThongTinCumRap(String maCumRapArg) throws SQLException {
        System.out.println("Lay thong tin cum rap");
        String sql = "select * from CumRap where maCumRap = ?";
        System.out.println(maCumRapArg);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] o = new Object[4];
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, maCumRapArg);
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
            Logger.getLogger(CumRapController.class
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
            System.out.println("Da connect CumRap");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CumRapController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS CumRap");
            } catch (SQLException e) {
                Logger.getLogger(CumRapController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS CumRap");
            } catch (SQLException e) {
                Logger.getLogger(CumRapController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn CumRap");
            } catch (SQLException e) {
                Logger.getLogger(CumRapController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
