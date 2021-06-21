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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.Database;
import model.LichChieu;

/**
 *
 * @author Trung
 */
public class LichChieuController {

    private Connection con;
    private List<LichChieu> listLichChieu;
    Database db = new Database();

    public LichChieuController() {
        listLichChieu = new LinkedList<LichChieu>();
        System.out.println("Chay constructor LichChieu");
    }

    public List<LichChieu> layDanhSachLichChieu() throws SQLException {
        System.out.println("Lay danh sach lich chieu");
        listLichChieu.clear();
        String sql = "select * from LichChieu order by maLichChieu";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maLichChieu = rs.getInt(1);
                Date ngayChieu = rs.getDate(2);
                Time gioChieu = rs.getTime(3);
                int giaVe = rs.getInt(4);
                int thoiLuong = rs.getInt(5);
                int maRap = rs.getInt(6);
                String maHeThongRap = rs.getString(7);
                String maCumRap = rs.getString(8);
                int maPhim = rs.getInt(9);
                LichChieu lichchieu = new LichChieu(maLichChieu, ngayChieu, gioChieu, giaVe, thoiLuong, maRap, maHeThongRap, maCumRap, maPhim);
                listLichChieu.add(lichchieu);
            }
            return Collections.unmodifiableList(listLichChieu);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public Object[] getThongTinLichChieu(int maLichChieuArg) throws SQLException {
        System.out.println("Lay thong tin lich chieu");
        String sql = "select * from LichChieu where maLichChieu = ?";
        System.out.println(maLichChieuArg);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] o = new Object[9];
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, maLichChieuArg);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                o[0] = rs.getInt(1);
                o[1] = rs.getDate(2);
                o[2] = rs.getTime(3);
                o[3] = rs.getInt(4);
                o[4] = rs.getInt(5);
                o[5] = rs.getInt(6);
                o[6] = rs.getString(7);
                o[7] = rs.getString(8);
                o[8] = rs.getInt(9);
            }
            return o;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class
                    .getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public Object[] getThongTinPhongChieu(int maLichChieuArg) throws SQLException {
        System.out.println("Lay thong tin phong chieulich chieu");
        String sql1 = "select giaVe, maRap from LichChieu where maLichChieu = ?";
        String sql2 = "select tenRap from Rap where maRap = ?";
        System.out.println(maLichChieuArg);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] o = new Object[3];
        try {
            connect();
            ps = con.prepareStatement(sql1);
            ps.setInt(1, maLichChieuArg);
            rs = ps.executeQuery();
            while (rs.next()) {
                o[0] = rs.getInt(1);
                o[1] = rs.getInt(2);
            }
            ps = con.prepareStatement(sql2);
            ps.setInt(1, (int) o[1]);
            rs = ps.executeQuery();
            while (rs.next()) {
                o[2] = rs.getString(1);
            }
            return o;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class
                    .getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public void suaThongTinLichChieu(int maLichChieuArg, Object[] o) throws SQLException {
        System.out.println("Sua thong tin lich chieu");
        String sql = "update LichChieu "
                + "set ngayChieu = ?, "
                + "gioChieu = ?, "
                + "giaVe = ?, "
                + "thoiLuong  = ?, "
                + "maRap = ?, "
                + "maPhim = ? "
                + "where maLichChieu = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setDate(col++, (Date) o[1]);
            ps.setTime(col++, (Time) o[2]);
            ps.setInt(col++, Integer.parseInt((String) o[3]));
            ps.setInt(col++, (int) o[5]);
            ps.setInt(col++, (int) o[4]);
            ps.setInt(col++, (int) o[0]);
            ps.setInt(col++, maLichChieuArg);
            ps.executeUpdate();
            con.commit();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class
                    .getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }
    }

    public void themLichChieu(Object[] o) throws SQLException {
        System.out.println("Them Lich Chieu");
        String sql = "insert into LichChieu(ngayChieu, gioChieu, giaVe, thoiLuong, maRap, maHeThongRap, maCumRap, maPhim) values(?, ?, ?, ?, ? ,?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setDate(col++, (Date) o[1]);
            ps.setTime(col++, (Time) o[2]);
            ps.setInt(col++, Integer.parseInt((String) o[3]));
            ps.setInt(col++, (int) o[5]);
            ps.setInt(col++, (int) o[4]);
            ps.setString(col++, "BHDStar");
            ps.setString(col++, "bhd-hvt");
            ps.setInt(col++, (int) o[0]);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class.getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }

    }

    public void xoaLichChieu(int maLichChieuArg, int index) throws SQLException {
        System.out.println("Xoa lich chieu");
        String sql = "Delete from LichChieu where maLichChieu = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            ps.setInt(1, maLichChieuArg);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class
                    .getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }
    }

    public List<String> layLichChieuTheoNgayCuaPhim(int maPhim) throws SQLException {
        System.out.println("Lay lich chieu theo ngay cua phim");
        String sql = "select ngayChieu from LichChieu where maPhim = ?";
        System.out.println(maPhim);
        SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> ngayChieuList = new ArrayList<>();
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, maPhim);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ngayChieu = DateFormatter.format(rs.getDate(1));
                ngayChieuList.add(ngayChieu);
            }
            List<String> uniqueNgayChieuList = ngayChieuList.stream().distinct().collect(Collectors.toList());
            return uniqueNgayChieuList;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class
                    .getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public List<String> layLichChieuTheoGioCuaPhim(int maPhim, String ngayChieu) throws SQLException, ParseException {
        System.out.println("Lay lich chieu theo gio cua phim");
        String sql = "select maLichChieu, gioChieu from LichChieu where maPhim = ? and ngayChieu like ?";
        System.out.println(maPhim);
        PreparedStatement ps = null;
        ResultSet rs = null;
        SimpleDateFormat fm1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat fm2 = new SimpleDateFormat("yyyy-MM-dd");
        List<String> gioChieuList = new ArrayList<>();
        try {
            connect();
            ps = con.prepareStatement(sql);
            Date stringToDate = new Date(fm1.parse(ngayChieu).getTime());
            ps.setInt(1, maPhim);
            ps.setString(2, "%" + fm2.format(stringToDate) + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int maLichChieu = rs.getInt(1);
                String gioChieu = rs.getString(2);
                gioChieuList.add(maLichChieu + " - " + gioChieu);
            }
            return gioChieuList;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LichChieuController.class
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
