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
public class User {
    private int taiKhoan;
    private String password;
    private String username;
    private String email;
    private Date ngaySinh;
    private String diaChi;
    private int diemTichLuy;
    private String soDT;
    private String hoTen;
    private String avatar;
    private int maLoaiNguoiDung;

    public User(int taiKhoan, String password, String username, String email, Date ngaySinh, String diaChi, int diemTichLuy, String soDT, String hoTen, String avatar, int maLoaiNguoiDung) {
        this.taiKhoan = taiKhoan;
        this.password = password;
        this.username = username;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.diemTichLuy = diemTichLuy;
        this.soDT = soDT;
        this.hoTen = hoTen;
        this.avatar = avatar;
        this.maLoaiNguoiDung = maLoaiNguoiDung;
    }

    public int getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(int taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getMaLoaiNguoiDung() {
        return maLoaiNguoiDung;
    }

    public void setMaLoaiNguoiDung(int maLoaiNguoiDung) {
        this.maLoaiNguoiDung = maLoaiNguoiDung;
    }

    
}
