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
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    Database db = new Database();

    public PhimController() {
        listPhim = new LinkedList<Phim>();
        System.out.println("Chay constructor Phim");
    }

    public List<Phim> getPhim() throws SQLException {
        System.out.println("Lay danh sach phim");
        listPhim.clear();
        String sql = "select * from phim order by maPhim";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // String LEES_SPELERS_SQL = "SELECT ... WHERE Spel_Naam = ?";
//PreparedStatement prepStmt = con.prepareStatement(LEES_SPELERS_SQL);
//prepStmt.setString(1, naam); 
//
//ResultSet rs = prepStmt.executeQuery();
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
                String biDanh = rs.getString(8);
                boolean daXoa = rs.getBoolean(9);
                Phim phim = new Phim(maPhim, tenPhim, trailer, hinhAnh, moTa, ngayKhoiChieu, danhGia, biDanh, daXoa);
                listPhim.add(phim);
            }
            return Collections.unmodifiableList(listPhim);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("close RS Phim");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("close PS Phim");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("close Conn Phim");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    public void themPhim(Object[] o) throws SQLException {
        System.out.println("Them Phim");
        String sql = "insert into PHIM(tenPhim, trailer, hinhAnh, moTa, ngayKhoiChieu, danhGia, biDanh, daXoa) values(?, ?, ?, ? ,?, ?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
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
            ps.setInt(col++, 0);
            ps.setString(col++, toSlug((String)o[0]));
            ps.setBoolean(col++, false);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
            con.rollback();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    System.out.println("close RS Phim");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("close PS Phim");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("close Conn Phim");
                } catch (SQLException e) {
                    Logger.getLogger(PhimController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
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

    public String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
