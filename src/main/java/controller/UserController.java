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
import model.User;

/**
 *
 * @author Admin
 */
public class UserController {

    private Connection con;
    private List<User> listUser;
    Database db = new Database();

    public UserController() {
        listUser = new LinkedList<User>();
        System.out.println("Chay constructor User");
    }

    public List<User> LayDanhSachUser() throws SQLException {
        System.out.println("Lay danh sach User");
        listUser.clear();
        String sql = "select * from Users where maLoaiNguoiDung <> 1 order by taiKhoan";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int taiKhoan = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                String email = rs.getString(4);
                Date ngaySinh = rs.getDate(5);
                String diaChi = rs.getString(6);
                int diemTichLuy = rs.getInt(7);
                String soDT = rs.getString(8);
                String hoTen = rs.getString(9);
                String avatar = rs.getString(10);
                int maLoaiNguoiDung = rs.getInt(11);
                User user = new User(taiKhoan, password, username, email, ngaySinh, diaChi, diemTichLuy, soDT, hoTen, avatar, maLoaiNguoiDung);
                listUser.add(user);
            }
            return Collections.unmodifiableList(listUser);
        } catch (SQLException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public Object[] getThongTinUser(int taiKhoanArg) throws SQLException {
        System.out.println("Lay thong tin user");
        String sql = "select * from Users where taiKhoan = ?";
        System.out.println(taiKhoanArg);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] o = new Object[11];
        try {
            connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, taiKhoanArg);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
                o[4] = rs.getDate(5);
                o[5] = rs.getString(6);
                o[6] = rs.getInt(7);
                o[7] = rs.getString(8);
                o[8] = rs.getString(9);
                o[9] = rs.getString(10);
                o[10] = rs.getInt(11);
            }
            return o;
        } catch (SQLException e) {
            Logger.getLogger(UserController.class
                    .getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, ps);
        }
    }

    public void suaThongTinUser(int taiKhoanArg, Object[] o) throws SQLException {
        System.out.println("Sua thong tin user");
        String sql = "update Users "
                + "set ngaySinh  = ?, "
                + "diaChi  = ?, "
                + "soDT = ?, "
                + "hoTen = ?, "
                + "diemTichLuy = ?, "
                + "maLoaiNguoiDung = ? "
                + "where taiKhoan = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            int col = 1;
            ps.setDate(col++, (Date) o[3]);
            ps.setString(col++, (String) o[1]);
            ps.setString(col++, (String) o[2]);
            ps.setString(col++, (String) o[0]);
            ps.setInt(col++, (int) o[5]);
            ps.setInt(col++, (int) o[4]);
            ps.setInt(col++, taiKhoanArg);
            ps.executeUpdate();
            con.commit();

        } catch (SQLException e) {
            Logger.getLogger(UserController.class
                    .getName()).log(Level.SEVERE, null, e);
            con.rollback();
            throw new SQLException();
        } finally {
            disconnect(rs, ps);
        }
    }

    public void xoaUser(int taiKhoanArg, int index) throws SQLException {
        System.out.println("Xoa user");
        String sql = "Delete from Users where taiKhoan = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connect();
            ps = con.prepareStatement(sql);
            int i = Connection.TRANSACTION_READ_COMMITTED;
            con.setAutoCommit(false);
            con.setTransactionIsolation(i);
            ps.setInt(1, taiKhoanArg);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            Logger.getLogger(UserController.class
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
            System.out.println("Da connect User");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UserController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS User");
            } catch (SQLException e) {
                Logger.getLogger(UserController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("close PS User");
            } catch (SQLException e) {
                Logger.getLogger(UserController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn User");
            } catch (SQLException e) {
                Logger.getLogger(UserController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }

}
