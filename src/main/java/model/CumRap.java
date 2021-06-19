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
public class CumRap {
    private String maCumRap;
    private String tenCumRap;
    private String thongTin;
    private String maHeThongRap;

    public CumRap(String maCumRap, String tenCumRap, String thongTin, String maHeThongRap) {
        this.maCumRap = maCumRap;
        this.tenCumRap = tenCumRap;
        this.thongTin = thongTin;
        this.maHeThongRap = maHeThongRap;
    }

    public String getMaCumRap() {
        return maCumRap;
    }

    public void setMaCumRap(String maCumRap) {
        this.maCumRap = maCumRap;
    }

    public String getTenCumRap() {
        return tenCumRap;
    }

    public void setTenCumRap(String tenCumRap) {
        this.tenCumRap = tenCumRap;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public String getMaHeThongRap() {
        return maHeThongRap;
    }

    public void setMaHeThongRap(String maHeThongRap) {
        this.maHeThongRap = maHeThongRap;
    }
    
    
}
