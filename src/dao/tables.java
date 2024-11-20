    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author LEGION 5 PRO
 */
public class tables {
    public static void main(String[] args) {
        String userTable = "create table user(id int AUTO_INCREMENT primary key, ten varchar(200),email varchar(200),"
                    + "soDienThoai varchar(13),diaChi varchar(200),matKhau varchar(200),cauHoiBaoMat varchar(200),"
                    + "cauTraLoi varchar(200), tinhTrang varchar(20),UNIQUE (email))";
        String categoryTable = "create table category(id int AUTO_INCREMENT primary key,tenSanPham varchar(200))";
        String productTable = "create table product(id int AUTO_INCREMENT primary key,tenSanPham varchar(200),category varchar(200),price varchar(200))";
        String BillTable = "create table bill(id int primary key,ten varchar(200),soDienThoai varchar(200),email varchar(200),thoiGianDen varchar(50),tongCong varchar(200),duocTaoBoi varchar(200))";
        try {
            
//            DbOperations.setDataOrDelete(userTable, "User Table Created Successfuly!");
//            DbOperations.setDataOrDelete(categoryTable, "Tạo bảng sản phẩm");
//            DbOperations.setDataOrDelete(productTable, "Thành Công");
//            DbOperations.setDataOrDelete(BillTable, "Thành Công");
                
        } catch (Exception e) {
            System.out.println(userTable);
            JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
