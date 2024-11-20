/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyUtil;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION 5 PRO
 */
public class OpenPDF {
    public static void openByID(String id){
        try {
            if(new File("D:\\BillCafe\\"+id+".pdf").exists()){
                System.out.println("hihi");
                Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\BillCafe\\"+id+".pdf");
            }
            else{
                JOptionPane.showMessageDialog(null, "Dont exit","MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
