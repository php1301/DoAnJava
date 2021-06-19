/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Trung
 */
public class LoaiNguoiDung {
    private int maLoaiNguoiDung;
    private String tenLoai;

    public LoaiNguoiDung(int maLoaiNguoiDung, String tenLoai) {
        this.maLoaiNguoiDung = maLoaiNguoiDung;
        this.tenLoai = tenLoai;
    }

    public int getMaLoaiNguoiDung() {
        return maLoaiNguoiDung;
    }

    public void setMaLoaiNguoiDung(int maLoaiNguoiDung) {
        this.maLoaiNguoiDung = maLoaiNguoiDung;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    
    
}
