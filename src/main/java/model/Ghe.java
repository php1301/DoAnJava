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
public class Ghe {
    private int maGhe;
    private String tenGhe;
    private int stt;
    private int maLoaiGhe;
    private int maRap;

    public Ghe(int maGhe, String tenGhe, int stt, int maLoaiGhe, int maRap) {
        this.maGhe = maGhe;
        this.tenGhe = tenGhe;
        this.stt = stt;
        this.maLoaiGhe = maLoaiGhe;
        this.maRap = maRap;
    }

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public String getTenGhe() {
        return tenGhe;
    }

    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getMaLoaiGhe() {
        return maLoaiGhe;
    }

    public void setMaLoaiGhe(int maLoaiGhe) {
        this.maLoaiGhe = maLoaiGhe;
    }

    public int getMaRap() {
        return maRap;
    }

    public void setMaRap(int maRap) {
        this.maRap = maRap;
    }

    
}
