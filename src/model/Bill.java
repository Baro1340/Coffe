/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LEGION 5 PRO
 */
public class Bill {

    public String getPhuongthucthanhtoan() {
        return phuongthucthanhtoan;
    }

    public void setPhuongthucthanhtoan(String phuongthucthanhtoan) {
        this.phuongthucthanhtoan = phuongthucthanhtoan;
    }
    private int id;
    private String ten;
    private String thoiDiemDen;
    private String tongCong;
    private String phuongthucthanhtoan;
    private String duocTaoBoi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getThoiDiemDen() {
        return thoiDiemDen;
    }

    public void setThoiDiemDen(String thoiDiemDen) {
        this.thoiDiemDen = thoiDiemDen;
    }

    public String getTongCong() {
        return tongCong;
    }

    public void setTongCong(String tongCong) {
        this.tongCong = tongCong;
    }

    public String getDuocTaoBoi() {
        return duocTaoBoi;
    }

    public void setDuocTaoBoi(String duocTaoBoi) {
        this.duocTaoBoi = duocTaoBoi;
    }
    
}
