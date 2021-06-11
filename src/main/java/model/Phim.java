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
public class Phim {

    private int maPhim;
    private String tenPhim;
    private String trailer;
    private String hinhAnh;
    private String moTa;
    private Date ngayKhoiChieu;
    private int danhGia;
    private int thoiLuong;
    private String biDanh;
    private boolean daXoa;

    public Phim(int maPhim, String tenPhim, String trailer, String hinhAnh, String moTa, Date ngayKhoiChieu, int danhGia, int thoiLuong, String biDanh, boolean daXoa) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.trailer = trailer;
        this.hinhAnh = hinhAnh;
        this.moTa = moTa;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.danhGia = danhGia;
        this.thoiLuong = thoiLuong;
        this.biDanh = biDanh;
        this.daXoa = daXoa;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setNgayKhoiChieu(Date ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public int getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(int danhGia) {
        this.danhGia = danhGia;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public boolean isDaXoa() {
        return daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

}
