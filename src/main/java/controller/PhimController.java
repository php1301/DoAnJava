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
import java.util.Collections;
import model.Database;
import model.Phim;

/**
 *
 * @author Admin
 */
public class PhimController {

    private Connection con;
    private List<Phim> listPhim;
    Database db = new Database();

    public PhimController() {
        listPhim = new LinkedList<Phim>();
        System.out.println("Chay constructor Phim");
    }

    public List<Phim> getPhim() throws SQLException {
        System.out.println("Lay danh sach phim");
        listPhim.clear();
        String sql = "select * from phim order by maPhim";
        try {
            // String LEES_SPELERS_SQL = "SELECT ... WHERE Spel_Naam = ?";
//PreparedStatement prepStmt = con.prepareStatement(LEES_SPELERS_SQL);
//prepStmt.setString(1, naam); 
//
//ResultSet rs = prepStmt.executeQuery();
            System.out.println(con);
            PreparedStatement getPhimSql = con.prepareStatement(sql);
            ResultSet rs = getPhimSql.executeQuery();
            while (rs.next()) {
                int maPhim = rs.getInt(1);
                String tenPhim = rs.getString(2);
                String trailer = rs.getString(3);
                String hinhAnh = rs.getString(4);
                String moTa = rs.getString(5);
                Date ngayKhoiChieu = rs.getDate(6);
                int danhGia = rs.getInt(7);
                String biDanh = rs.getString(8);
                boolean daXoa = rs.getBoolean(9);
                Phim phim = new Phim(maPhim, tenPhim, trailer, hinhAnh, moTa, ngayKhoiChieu, danhGia, biDanh, daXoa);
                listPhim.add(phim);
                System.out.println(phim);
            }
            rs.close();
            getPhimSql.close();
            return Collections.unmodifiableList(listPhim);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            return null;
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
