/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Category;
import model.Bill;
/**
 *
 * @author LEGION 5 PRO
 */
public class BillDAO {
    public static String getID(){
        int id = 1 ;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select max(mahoadon) from hoadon";
        PreparedStatement pst = con.prepareStatement(sql);
        //Bước 3:Thực thi câu lệnh SQL
        ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            id = rs.getInt(1);
            id++;
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return String.valueOf(id); 
    }
    public static int insert(Bill bill){
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        con.setAutoCommit(false);
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "INSERT INTO hoadon(tenkhachhang,tongCong,phuongthucthanhtoan,duocTaoBoi)"
                +"VALUES(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,bill.getTen() );
        pst.setString(2,bill.getTongCong());
        pst.setString(3, bill.getPhuongthucthanhtoan());
        pst.setString(4,bill.getDuocTaoBoi());
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        //Bước 4: Xử lý thông báo
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.commit();
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }
    public static ArrayList<Bill> getAllRecordsByDesc(String date){
        ArrayList<Bill> ketQua = new ArrayList<>();
          try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from hoadon where ngaylap like ? order By mahoadon DESC";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, date);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("mahoadon"));
            bill.setTen(rs.getString("tenkhachhang"));
            bill.setThoiDiemDen(rs.getString("ngaylap"));
            bill.setTongCong(rs.getString("tongCong"));
            bill.setPhuongthucthanhtoan(rs.getString("phuongthucthanhtoan"));
            bill.setDuocTaoBoi(rs.getString("duocTaoBoi"));
            ketQua.add(bill);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }
        public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> ketQua = new ArrayList<>();
          try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "select * from hoadon where ngaylap like ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, date);
        //Bước 3:Thực thi câu lệnh SQL
         ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("mahoadon"));
            bill.setTen(rs.getString("tenkhachhang"));
            bill.setThoiDiemDen(rs.getString("ngaylap"));
            System.out.println(rs.getString("ngaylap"));
            bill.setTongCong(rs.getString("tongCong"));
            bill.setPhuongthucthanhtoan(rs.getString("phuongthucthanhtoan"));
            bill.setDuocTaoBoi(rs.getString("duocTaoBoi"));
            ketQua.add(bill);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }
}
