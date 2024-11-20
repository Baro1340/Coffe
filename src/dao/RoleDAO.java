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
import model.Role;

/**
 *
 * @author LEGION 5 PRO
 */
public class RoleDAO implements DAOInterface<Role> {
    public static RoleDAO getInstance(){
        return new RoleDAO();
    }
    @Override
    public int insert(Role t) {
         int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        if(t.getId()==0){
        String sql = "INSERT INTO chucvu(tencv,luong,congviec)"
        +"VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getTenChucVu());
        pst.setString(2, t.getLuong());
        pst.setString(3, t.getCongViec());
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        }
        else{
            String sql = "update chucvu set tencv = ?,luong = ?,congviec = ? where macv = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getTenChucVu());
        pst.setString(2, t.getLuong());
        pst.setString(3, t.getCongViec());
        pst.setInt(4, t.getId());
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        }
        //Bước 4: Xử lý thông báo
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;    
    }

    @Override
    public int update(Role t) {
        return 0;
    }

    
    public int delete(int id) {
            int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "delete from chucvu where macv = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
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
    public ArrayList<Role> selectAll() {
        ArrayList<Role> ketQua = new ArrayList<>();
          try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from chucvu";
        PreparedStatement pst = con.prepareStatement(sql);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            Role role = new Role();
            role.setId(rs.getInt("macv"));
            role.setTenChucVu(rs.getString("tencv"));
            role.setLuong(rs.getString("luong"));
            role.setCongViec(rs.getString("congviec"));
            ketQua.add(role);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }

    public Role getRoleByName(String tencv) {
        Role role = new Role();
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from chucvu where tencv = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,tencv);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            role.setId(rs.getInt("macv"));
            role.setTenChucVu(tencv);
            role.setLuong(rs.getString("Luong"));
            role.setCongViec(rs.getString("CongViec"));
            
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return role;
    }

    @Override
    public ArrayList<Role> selectByCondition(String condition) {
        return null;
    }

    @Override
    public int delete(Role t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Role selectByID(Role t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
