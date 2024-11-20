/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;

/**
 *
 * @author LEGION 5 PRO
 */
public class ProductDAO {
//    public static void main(String[] args) {
//        String email = "123";
//        System.out.println("\"%"+email+"%\"");
//    }
    public static int insert(Product product) {
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "INSERT INTO sanpham(tenSanPham,giathanh,loaihinh)"
                +"VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, product.getTenSanPham());
        pst.setString(2, product.getGiaThanh());
        pst.setInt(3, product.getLoaiHinh());
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        //Bước 4: Xử lý thông báo
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }
    public static ArrayList<Product> selectAll(){
        ArrayList<Product> ketQua = new ArrayList<>();
          try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from sanpham";
        PreparedStatement pst = con.prepareStatement(sql);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery(sql);
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            Product p = new Product();
            p.setId(rs.getInt("masanpham"));
            p.setTenSanPham(rs.getString("tenSanPham"));
            p.setLoaiHinh(rs.getInt("loaiHinh"));
            p.setGiaThanh(rs.getString("giaThanh"));
            ketQua.add(p);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }
    public static int update(Product p){
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "update sanpham set tenSanPham = ?,loaiHinh = ?,giaThanh = ? where masanpham = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, p.getTenSanPham());
        pst.setInt(2, p.getLoaiHinh());
        pst.setString(3, p.getGiaThanh());
        pst.setInt(4, p.getId());
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        //Bước 4: Xử lý thông báo
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;  
    }
    public static int delete(String id){    
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "delete from sanpham where masanpham = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        //Bước 4: Xử lý thông báo
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }
    
        public static ArrayList<Product> selectAll(int loaiHinh){
        ArrayList<Product> ketQua = new ArrayList<>();
          try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from sanpham where loaiHinh = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, loaiHinh);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            Product p = new Product();
            p.setId(rs.getInt("masanpham"));
            p.setTenSanPham(rs.getString("tenSanPham"));
            p.setGiaThanh(rs.getString("giathanh"));
            ketQua.add(p);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }
        
    public static ArrayList<Product> selectAll(String ten, String loaiHinh) {
        ArrayList<Product> ketQua = new ArrayList<>();
        try {
            //Bước 1:Tạo kết nối đến cơ sở dữ liệu
            Connection con = ConnectionProvider.getCon();
            //Bước 2:Tạo ra đối tượng PrepareStatement
            String sql = "Select * from sanpham where tenSanPham like ? AND loaiHinh = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + ten + "%");
            pst.setString(2, loaiHinh);
            //Bước 3:Thực thi câu lệnh SQL
            ResultSet rs = pst.executeQuery();
            //Bước 4: Xử lý thông báo
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setTenSanPham(rs.getString("tenSanPham"));
                ketQua.add(p);
            }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }

    public static Product getProductByName(String ten) {
        Product product = new Product();
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from sanpham where tenSanPham = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,ten);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            product.setId(rs.getInt("masanpham"));
            product.setTenSanPham(rs.getString("TenSanPham"));
            product.setLoaiHinh(rs.getInt("LoaiHinh"));
            product.setGiaThanh(rs.getString("GiaThanh"));
            
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }
}
