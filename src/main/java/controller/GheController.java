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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Collections;
import java.util.Locale;
import java.util.regex.Pattern;
import model.Database;
import model.Ghe;

/**
 *
 * @author Admin
 */
public class GheController {

    private Connection con;
    private List<Ghe> listGhe;
    Database db = new Database();

    public GheController() {
        listGhe = new LinkedList<Ghe>();
        System.out.println("Chay constructor Ghe");
    }

    public List<Ghe> layDanhSachGhe() throws SQLException {
        System.out.println("Lay danh sach phim");
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

    public void connect() throws SQLException {
        try {
            db.connect();
            String remoteUrl = "jdbc:mysql://103.97.125.254:3306/doanjava_v1";
            con = DriverManager.getConnection(remoteUrl, "doanjava", "a2DpigCp7PDOyGk");
            System.out.println("Connected " + con);
            System.out.println("Da connect");
        } catch (Exception e) {
            Logger.getLogger(GheController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS");
            } catch (SQLException e) {
                Logger.getLogger(GheController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS");
            } catch (SQLException e) {
                Logger.getLogger(GheController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn");
            } catch (SQLException e) {
                Logger.getLogger(GheController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
