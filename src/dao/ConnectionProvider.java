/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION 5 PRO
 */
public class ConnectionProvider {
    public static Connection getCon(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/oldb","system","Baobao123!");
            return con;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không ổn rồi Đại Vương ơi\n Hãy thoát ra vào lại, "
                    + "nhập dữ liệu từ từ thoai chủ app chưa có điều kiện :<","ERROR",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
