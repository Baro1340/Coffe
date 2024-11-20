/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LEGION 5 PRO
 */
public class Product {
    private int id;
    private String tenSanPham;
    private int loaiHinh;
    private String giaThanh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getLoaiHinh() {
        return loaiHinh;
    }

    public void setLoaiHinh(int loaiHinh) {
        this.loaiHinh = loaiHinh;
    }

    public String getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(String giaThanh) {
        this.giaThanh = giaThanh;
    }
    
}
