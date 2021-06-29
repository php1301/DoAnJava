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
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Database;
import model.Ve;

/**
 *
 * @author Admin
 */
public class VeController {

    private Connection con;
    private List<Ve> listVe;
    Database db = new Database();

    public VeController() {
        listVe = new LinkedList<Ve>();
        System.out.println("Chay constructor Ve");
    }

    public List<Ve> layDanhSachVe() throws SQLException {
        System.out.println("Lay danh sach ve");
        listVe.clear();
        String sql = "select * from Ve order by maVe";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maVe = rs.getInt(1);
                Date ngayDat = rs.getDate(2);
                int giaVe = rs.getInt(3);
                int maLichChieu = rs.getInt(4);
                int taiKhoan = rs.getInt(5);
                Ve v = new Ve(maVe, ngayDat, giaVe, maLichChieu, taiKhoan);
                listVe.add(v);
            }
            return Collections.unmodifiableList(listVe);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public List<Ve> layDanhSachVeCuaKhachHang(int maKH) throws SQLException {
        System.out.println("Lay danh sach ve cua Khach Hang " + maKH);
        listVe.clear();
        String sql = "select * from Ve where taiKhoan = ? order by maVe";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maVe = rs.getInt(1);
                Date ngayDat = rs.getDate(2);
                int giaVe = rs.getInt(3);
                int maLichChieu = rs.getInt(4);
                int taiKhoan = rs.getInt(5);
                Ve v = new Ve(maVe, ngayDat, giaVe, maLichChieu, taiKhoan);
                listVe.add(v);
            }
            return Collections.unmodifiableList(listVe);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public void datVe(Object[] o, ArrayList<Integer> maGhe) throws SQLException {
        System.out.println("Dat ve");
        listVe.clear();
        String sql1 = "INSERT INTO Ve(giaVe, maLichChieu, taiKhoan) values(?, ?, ?)";
        String sql2 = "INSERT INTO GheDaDat(maGhe, maLichChieu) values(?, ?)";
        String sql3 = "INSERT INTO DatVe (maVe, maGhe) values (?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setInt(col++, Integer.parseInt((String) o[0]));
            ps.setInt(col++, (int) o[1]);
            ps.setInt(col++, Integer.parseInt((String) o[2]));
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                ps = con.prepareStatement(sql2);
                for (int g : maGhe) {
                    ps.setInt(1, g);
                    ps.setInt(2, (int) o[1]);
                    ps.executeUpdate();
                }
                ps = con.prepareStatement(sql3);
                for (int g : maGhe) {
                    ps.setInt(1, generatedKeys.getInt(1));
                    ps.setInt(2, g);
                    ps.executeUpdate();
                }
            } else {
                throw new SQLException("Creating Ve failed, no ID obtained.");
            }
            con.commit();
        } catch (NumberFormatException | SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class.getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
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
            System.out.println("Da connect LichChieu");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS LichChieu");
            } catch (SQLException e) {
                Logger.getLogger(LichChieuController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS LichChieu");
            } catch (SQLException e) {
                Logger.getLogger(LichChieuController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn LichChieu");
            } catch (SQLException e) {
                Logger.getLogger(LichChieuController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
