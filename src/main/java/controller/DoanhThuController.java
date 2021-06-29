/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Database;
import model.DoanhThu;

/**
 *
 * @author Hp
 */
public class DoanhThuController {

    private Connection con;
    Database db = new Database();
    private List<DoanhThu> listDoanhThu;

    public DoanhThuController() {
        listDoanhThu = new LinkedList<DoanhThu>();
        System.out.println("Chay constructor Doanh Thu");
    }

    public List<DoanhThu> layDanhSachDoanhThu(int Thang, int Nam, int maPhim) throws SQLException {
        System.out.println("Lay danh sach doanh thu");
        listDoanhThu.clear();
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            connect();
            String sql = "{CALL sp2(?,?,?)}";
            stmt = con.prepareCall(sql);
            stmt.setInt(1, Thang);
            stmt.setInt(2, Nam);
            stmt.setInt(3, maPhim);
            boolean hadResults = stmt.execute();
            System.out.println(hadResults);
            if(hadResults){
                rs = stmt.getResultSet();
                while (rs.next()) {
                    int ma = rs.getInt("maPhim");
                    System.out.println(ma);
                    String tenphim = rs.getString("tenPhim");
                    int doanhthu = rs.getInt("doanhThu");
                    DoanhThu DoanhThu = new DoanhThu(ma, tenphim, doanhthu);
                    listDoanhThu.add(DoanhThu);
                }
            }
            return Collections.unmodifiableList(listDoanhThu);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(DoanhThuController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            disconnect(rs, stmt);
        }
    }

    public void connect() throws SQLException {
        try {
            db.connect();
            String url = "jdbc:mysql://localhost:3306/doanjavalb";
            String remoteUrl = "jdbc:mysql://103.97.125.254:3306/doanjava_v1?noAccessToProcedureBodies=true";
            con = DriverManager.getConnection(remoteUrl, "doanjava", "a2DpigCp7PDOyGk");
            System.out.println("Connected " + con);
            System.out.println("Da connect Doanh Thu");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logger.getLogger(DoanhThuController.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect(ResultSet rs, CallableStatement stmt) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("close RS Doanh Thu");
            } catch (SQLException e) {
                Logger.getLogger(DoanhThuController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
                System.out.println("close STMT Doanh Thu");
            } catch (SQLException e) {
                Logger.getLogger(DoanhThuController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        if (con != null) {
            try {
                con.close();
                System.out.println("close Conn Doanh Thu");
            } catch (SQLException e) {
                Logger.getLogger(DoanhThuController.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<DoanhThu> layDanhSachDoanhThu(Integer thang, int nam, Object[] maPhim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
