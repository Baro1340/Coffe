/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;
import java.sql.*;
import model.Product;

/**
 *
 * @author LEGION 5 PRO
 */
public class CategoryDAO implements DAOInterface<Category>{
    public static CategoryDAO getInstance(){
        return new CategoryDAO();
    }
    @Override
    public int insert(Category t) {
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "INSERT INTO loai(tenloai)"
                +"VALUES(?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getTenLoaiHinh());
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

    @Override
    public int update(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int delete(String id) {
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "delete from loai where maloai = ?";
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
    @Override
    public int delete(Category t) {
        return -1; 
    }

    
    public Category selectByID(int id) {
        Category category = new Category();
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from loai where maloai = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            category.setId(id);
            category.setTenLoaiHinh(rs.getString("tenloai"));            
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return category;
    }

    @Override
    public ArrayList<Category> selectAll() {
        ArrayList<Category> ketQua = new ArrayList<>();
          try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from loai";
        PreparedStatement pst = con.prepareStatement(sql);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery(sql);
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            Category category = new Category();
            category.setId(rs.getInt("maloai"));
            category.setTenLoaiHinh(rs.getString("tenloai"));
            ketQua.add(category);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }

    @Override
    public ArrayList<Category> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Category getCategoryByName(String ten) {
                Category category = new Category();
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from loai where tenLoai = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,ten);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            category.setId(rs.getInt("maLoai"));
            category.setTenLoaiHinh(ten);            
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return category;
    }

    @Override
    public Category selectByID(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
