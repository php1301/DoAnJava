/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hp
 */
public class DoanhThu {
    private int maPhim;
    private String tenPhim;
    private int doanhThu;

    public DoanhThu(int maPhim, String tenPhim, int doanhThu) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.doanhThu = doanhThu;
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

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    
}
