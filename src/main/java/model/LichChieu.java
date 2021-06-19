/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Trung
 */
public class LichChieu {
    private int maLichChieu;
    private Date ngayChieu;
    private Time gioChieu;
    private int giaVe;
    private int thoiLuong;
    private int maRap;
    private String maHeThongRap;
    private String maCumRap;
    private int maPhim;

    public LichChieu(int maLichChieu, Date ngayChieu, Time gioChieu, int giaVe, int thoiLuong, int maRap, String maHeThongRap, String maCumRap, int maPhim) {
        this.maLichChieu = maLichChieu;
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
        this.giaVe = giaVe;
        this.thoiLuong = thoiLuong;
        this.maRap = maRap;
        this.maHeThongRap = maHeThongRap;
        this.maCumRap = maCumRap;
        this.maPhim = maPhim;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Time getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(Time gioChieu) {
        this.gioChieu = gioChieu;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public int getMaRap() {
        return maRap;
    }

    public void setMaRap(int maRap) {
        this.maRap = maRap;
    }

    public String getMaHeThongRap() {
        return maHeThongRap;
    }

    public void setMaHeThongRap(String maHeThongRap) {
        this.maHeThongRap = maHeThongRap;
    }

    public String getMaCumRap() {
        return maCumRap;
    }

    public void setMaCumRap(String maCumRap) {
        this.maCumRap = maCumRap;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    
    
}
