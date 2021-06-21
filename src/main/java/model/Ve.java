/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Ve {

    private int maVe;
    private Date ngayDat;
    private int giaVe;
    private int maLichChieu;
    private int taiKhoan;

    public Ve(int maVe, Date ngayDat, int giaVe, int maLichChieu, int taiKhoan) {
        this.maVe = maVe;
        this.ngayDat = ngayDat;
        this.giaVe = giaVe;
        this.maLichChieu = maLichChieu;
        this.taiKhoan = taiKhoan;
    }

    
    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public int getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(int taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    
    
}
