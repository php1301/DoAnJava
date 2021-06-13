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
import model.Phim;

/**
 *
 * @author Admin
 */
public class PhimController {

    private Connection con;
    private List<Phim> listPhim;
    Database db = new Database();
    TheLoaiController theLoaiController = new TheLoaiController();
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public PhimController() {
        listPhim = new LinkedList<Phim>();
        System.out.println("Chay constructor Phim");
    }

    public List<Phim> layDanhSachPhim() throws SQLException {
        System.out.println("Lay danh sach phim");
        listPhim.clear();
        String sql = "select * from Phim order by maPhim";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // String LEES_SPELERS_SQL = "SELECT ... WHERE Spel_Naam = ?";
//PreparedStatement prepStmt = con.prepareStatement(LEES_SPELERS_SQL);
//prepStmt.setString(1, naam); 
//
//ResultSet rs = prepStmt.executeQuery();
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maPhim = rs.getInt(1);
                String tenPhim = rs.getString(2);
                String trailer = rs.getString(3);
                String hinhAnh = rs.getString(4);
                String moTa = rs.getString(5);
                Date ngayKhoiChieu = rs.getDate(6);
                int danhGia = rs.getInt(7);
                int thoiLuong = rs.getInt(8);
                String biDanh = rs.getString(9);
                boolean daXoa = rs.getBoolean(10);
                Phim phim = new Phim(maPhim, tenPhim, trailer, hinhAnh, moTa, ngayKhoiChieu, danhGia, thoiLuong, biDanh, daXoa);
                listPhim.add(phim);
            }
            return Collections.unmodifiableList(listPhim);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public void themPhim(Object[] o) throws SQLException {
        System.out.println("Them Phim");
        String sql = "insert into Phim(tenPhim, trailer, hinhAnh, moTa, ngayKhoiChieu, danhGia, biDanh, daXoa, thoiLuong) values(?, ?, ?, ? ,?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setString(col++, (String) o[0]);
            ps.setString(col++, (String) o[4]);
            ps.setString(col++, (String) o[5]);
            ps.setString(col++, (String) o[6]);
            ps.setDate(col++, (Date) o[3]);
            ps.setInt(col++, 0);
            ps.setString(col++, toSlug((String) o[0]));
            ps.setBoolean(col++, false);
            ps.setInt(col++, (int) o[1]);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                theLoaiController.themTheLoaiChoPhim(generatedKeys.getInt(1), (int[]) o[7], con);
            } else {
                throw new SQLException("Creating Phim failed, no ID obtained.");
            }
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }

    }

    public Object[] getThongTinPhim(int maPhimArg) throws SQLException {
        System.out.println("Lay thong tin phim");
        String sql = "select * from Phim where maPhim = ?";
        System.out.println(maPhimArg);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] o = new Object[11];
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, maPhimArg);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
                o[4] = rs.getString(5);
                o[5] = rs.getDate(6);
                o[6] = rs.getInt(7);
                o[7] = rs.getInt(8);
                o[8] = rs.getString(9);
                o[9] = rs.getBoolean(10);
            }
            o[10] = theLoaiController.layTheLoaiCuaPhim(con, maPhimArg);
            return o;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class
                    .getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public void suaThongTinPhim(int maPhimArg, Object[] o) throws SQLException {
        System.out.println("Sua thong tin phim");
        String sql = "update Phim "
                + "set tenPhim = ?, "
                + "trailer = ?, "
                + "hinhAnh = ?, "
                + "moTa = ?, "
                + "ngayKhoiChieu = ?, "
                + "biDanh = ?, "
                + "thoiLuong = ? "
                + "where maPhim = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setString(col++, (String) o[0]);
            ps.setString(col++, (String) o[4]);
            ps.setString(col++, (String) o[5]);
            ps.setString(col++, (String) o[6]);
            ps.setDate(col++, (Date) o[3]);
            ps.setString(col++, toSlug((String) o[0]));
            ps.setInt(col++, (int) o[1]);
            ps.setInt(col++, maPhimArg);
            theLoaiController.capNhatTheLoaiCuaPhim(maPhimArg, (int[]) o[7], con);
            ps.executeUpdate();
            con.commit();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class
                    .getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }
    }

    public void xoaPhim(int maPhimArg, int index) throws SQLException {
        System.out.println("Xoa phim");
        String sql = "Delete from Phim where maPhim = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            ps.setInt(1, maPhimArg);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class
                    .getName()).log(Level.SEVERE, null, e);
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
            System.out.println("Da connect Phim");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS Phim");
            } catch (SQLException e) {
                Logger.getLogger(PhimController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS Phim");
            } catch (SQLException e) {
                Logger.getLogger(PhimController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn Phim");
            } catch (SQLException e) {
                Logger.getLogger(PhimController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
