/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.User;
import java.sql.*; 
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
/**
 *
 * @author LEGION 5 PRO
 */
public class UserDAO{
    public static UserDAO getInstance(){
        return new UserDAO();
    }
    public User quenMatKhau(String email){
        User user = null;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "SELECT * FROM user where email = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, email);
        //Bước 3:Thực thi câu lệnh SQL
        ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            user = new User();
            user.setCauHoiBaoMat(rs.getString("cauHoiBaoMat"));
            user.setCauTraLoi(rs.getString("cauTraLoi"));
        }
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
    public int insert(User t) {
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "INSERT INTO NhanVien(tennv,email,soDienThoai,diaChi,matKhau,cauHoiBaoMat,cauTraLoi,trangThai,macv)"
                +"VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getTen());
        pst.setString(2, t.getEmail());
        pst.setString(3, t.getSoDienThoai());
        pst.setString(4, t.getDiaChi());
        pst.setString(5, t.getMatKhau());
        pst.setString(6, t.getCauHoiBaoMat());
        pst.setString(7, t.getCauTraLoi());
        pst.setString(8, t.getTinhTrang());
        pst.setInt(9, t.getMaCV());
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
    public User login(String email, String matKhau){
        User user = null;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
//        String sql = "SELECT * FROM NHANVIEN where BINARY  email = ? AND BINARY matKhau = ?";
        String sql = "SELECT * FROM NHANVIEN where  email = ? AND  matKhau = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, email);
        pst.setString(2, matKhau);
        //Bước 3:Thực thi câu lệnh SQL
        ResultSet rs = pst.executeQuery();
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            user = new User();
            user.setTinhTrang(rs.getString("TRANGTHAI"));
            
        }
        con.close();
//        JOptionPane.showMessageDialog(null, "hi","ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return user;

    }
 
   public int update(String email, String matKhauMoi) {
        int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "UPDATE user SET matKhau = ? WHERE email = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, matKhauMoi);
        pst.setString(2, email);
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
   public ArrayList<User> getAllRecords(String email,String soDienThoai){
        if(soDienThoai.equals("")){
            ArrayList<User> ketQua = new ArrayList<>();
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from nhanvien where email like ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, email);
        //Bước 3:Thực thi câu lệnh SQL
        ResultSet rs = pst.executeQuery();
        
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("manv"));
            u.setTen(rs.getString("tennv"));
            u.setEmail(rs.getString("email"));
            u.setSoDienThoai(rs.getString("soDienThoai"));
            u.setDiaChi(rs.getString("diaChi"));
            u.setCauHoiBaoMat(rs.getString("cauHoiBaoMat"));
            u.setCauTraLoi(rs.getString("CauTraLoi"));
            u.setTinhTrang(rs.getString("trangthai"));
            u.setMaCV(rs.getInt("macv"));
            ketQua.add(u);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
        }
        else{
            ArrayList<User> ketQua = new ArrayList<>();
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con  = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "Select * from nhanvien where email like ? AND soDienThoai = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, email);
        pst.setString(2, soDienThoai);
        //Bước 3:Thực thi câu lệnh SQL
        ResultSet rs = pst.executeQuery();
        
        //Bước 4: Xử lý thông báo
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setTen(rs.getString("ten"));
            u.setEmail(rs.getString("email"));
            u.setSoDienThoai(rs.getString("soDienThoai"));
            u.setDiaChi(rs.getString("diaChi"));
            u.setCauHoiBaoMat(rs.getString("cauHoiBaoMat"));
            u.setTinhTrang(rs.getString("tinhTrang"));
            ketQua.add(u);
        }
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
        }
   }
   public int thayDoiTinhTrang(String email, String tinhTrang){
       int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "UPDATE nhanvien SET trangthai = ? WHERE email = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tinhTrang);
        pst.setString(2, email);
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
   public int changePassword(String email, String matKhauCu,String matKhauMoi){
       int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
        String sql = "UPDATE nhanvien SET matKhau = ? WHERE email = ? and matKhau = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, matKhauMoi);
        pst.setString(2, email);
        pst.setString(3, matKhauCu);
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        //Bước 4: Xử lý thông báo
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mật Khẩu Cũ Sai!!!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
   }
   public int changeQuestion(String email, String matKhau,String cauHoiCu,String cauHoiMoi,String cauTraLoiMoi){
       int ketQua = 0;
        try {
        //Bước 1:Tạo kết nối đến cơ sở dữ liệu
        Connection con = ConnectionProvider.getCon();
        //Bước 2:Tạo ra đối tượng PrepareStatement
            String sql = "UPDATE nhanvien SET cauHoiBaoMat = ?, cauTraLoi = ? WHERE email = ? and matKhau = ? and cauHoiBaoMat = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cauHoiMoi );
        pst.setString(2, cauTraLoiMoi);
        pst.setString(3, email);    
        pst.setString(4, matKhau);
        pst.setString(5, cauHoiCu);
        //Bước 3:Thực thi câu lệnh SQL
        ketQua = pst.executeUpdate();
        //Bước 4: Xử lý thông báo
//        JOptionPane.showMessageDialog(null, sql+"\n Có "+ketQua+" dòng được thay đổi!");
        con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mật Khẩu Cũ Sai!!!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
   }
}
