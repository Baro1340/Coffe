/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Category;
import model.Product;

/**
 *
 * @author LEGION 5 PRO
 */
public class AddNewProduct extends javax.swing.JFrame {

    /**
     * Creates new form AddNewProduct
     */
    public AddNewProduct() {
        initComponents();
        
        btnLuu.setEnabled(false);
        
        ImageIcon icon = new ImageIcon("src/images/small-page-background.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sicon = new ImageIcon(imgScale);
        jLabel1.setIcon(sicon);
    }
    public void validateFields(){
        String tenSanPham = txtTenSanPham.getText();
        String loaiHinh = (String) comboBoxLoaiHinh.getSelectedItem();
        String giaThanh = txtGiaThanh.getText();
        if(!tenSanPham.equals("")&&!loaiHinh.equals("")&&!giaThanh.equals("")){
            btnLuu.setEnabled(true);
        }
        else{
            btnLuu.setEnabled(false);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        txtGiaThanh = new javax.swing.JTextField();
        comboBoxLoaiHinh = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tên Sản Phẩm");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Loại Hình");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Giá Thành");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTenSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenSanPhamKeyReleased(evt);
            }
        });
        getContentPane().add(txtTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 420, -1));

        txtGiaThanh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtGiaThanh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaThanhKeyReleased(evt);
            }
        });
        getContentPane().add(txtGiaThanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 420, -1));

        comboBoxLoaiHinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        comboBoxLoaiHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxLoaiHinhActionPerformed(evt);
            }
        });
        comboBoxLoaiHinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboBoxLoaiHinhKeyReleased(evt);
            }
        });
        getContentPane().add(comboBoxLoaiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 420, -1));

        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 140, -1));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new product.png"))); // NOI18N
        jLabel5.setText("Sản Phẩm Mới");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 35, 32));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 950, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenSanPhamKeyReleased
       validateFields();
    }//GEN-LAST:event_txtTenSanPhamKeyReleased

    private void comboBoxLoaiHinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxLoaiHinhKeyReleased
        validateFields();
    }//GEN-LAST:event_comboBoxLoaiHinhKeyReleased

    private void txtGiaThanhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaThanhKeyReleased
        validateFields();
    }//GEN-LAST:event_txtGiaThanhKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        ArrayList<Category> list = CategoryDAO.getInstance().selectAll();
        Iterator<Category> itr = list.iterator();
        while(itr.hasNext()){
            Category category = itr.next();
            comboBoxLoaiHinh.addItem(category.getTenLoaiHinh());
        }
    }//GEN-LAST:event_formComponentShown

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        Product product = new Product();
        product.setTenSanPham(txtTenSanPham.getText());
        System.out.println(CategoryDAO.getInstance().getCategoryByName((String) comboBoxLoaiHinh.getSelectedItem()).getId());
        product.setLoaiHinh(CategoryDAO.getInstance().getCategoryByName((String) comboBoxLoaiHinh.getSelectedItem()).getId());
        product.setGiaThanh(txtGiaThanh.getText());
        int kq = ProductDAO.insert(product);
        setVisible(false);
        new AddNewProduct().setVisible(true);
        if(kq>0){
            JLabel label = new JLabel("Đã thêm "+txtTenSanPham.getText()+" vào Menu quán!");
            label.setFont(new Font("Arial", Font.BOLD, 14));
            JOptionPane.showMessageDialog(null, label,"MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtTenSanPham.setText("");
        txtGiaThanh.setText("");
        comboBoxLoaiHinh.setSelectedIndex(-1);
        btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboBoxLoaiHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLoaiHinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxLoaiHinhActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> comboBoxLoaiHinh;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtGiaThanh;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
