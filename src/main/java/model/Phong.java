/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Phong {
    private int maRap;
    private String tenRap;
    private int soGhe;
    private String maCumRap;

    public Phong(int maRap, String tenRap, int soGhe, String maCumRap) {
        this.maRap = maRap;
        this.tenRap = tenRap;
        this.soGhe = soGhe;
        this.maCumRap = maCumRap;
    }

    public int getMaRap() {
        return maRap;
    }

    public void setMaRap(int maRap) {
        this.maRap = maRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public String getMaCumRap() {
        return maCumRap;
    }

    public void setMaCumRap(String maCumRap) {
        this.maCumRap = maCumRap;
    }
    
}
