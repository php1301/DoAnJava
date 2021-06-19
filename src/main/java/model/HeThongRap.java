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
public class HeThongRap {
    private String maHeThongRap;
    private String tenHeThongRap;
    private String biDanh;
    private String logo;

    public HeThongRap(String maHeThongRap, String tenHeThongRap, String biDanh, String logo) {
        this.maHeThongRap = maHeThongRap;
        this.tenHeThongRap = tenHeThongRap;
        this.biDanh = biDanh;
        this.logo = logo;
    }

    public String getMaHeThongRap() {
        return maHeThongRap;
    }

    public void setMaHeThongRap(String maHeThongRap) {
        this.maHeThongRap = maHeThongRap;
    }

    public String getTenHeThongRap() {
        return tenHeThongRap;
    }

    public void setTenHeThongRap(String tenHeThongRap) {
        this.tenHeThongRap = tenHeThongRap;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    
}
