/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.UserDAO;
import java.awt.Font;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION 5 PRO
 */
public class ChangeSecurityQuestion extends javax.swing.JFrame {
    public String userEmail;
    /**
     * Creates new form ChangeSecurityQuestion
     */
    public ChangeSecurityQuestion() {
        initComponents();
        ImageIcon icon = new ImageIcon("src/images/small-page-background.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sicon = new ImageIcon(imgScale);
        jLabel6.setIcon(sicon);
    }
    public ChangeSecurityQuestion(String email) {
        
        initComponents();
        userEmail = email;
        btnThayDoi.setEnabled(false);
        
        ImageIcon icon = new ImageIcon("src/images/small-page-background.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sicon = new ImageIcon(imgScale);
        jLabel6.setIcon(sicon);
    }
    public void validateFiels(){
        String matKhau = txtMatKhau.getText();
        String cauHoiMoi = (String) newcomboBox.getSelectedItem();
        String cauTraLoi = txtCauTraLoiMoi.getText();
        if(!matKhau.equals("")&&!cauHoiMoi.equals("")&&!cauTraLoi.equals("")){
            btnThayDoi.setEnabled(true);
        }
        else{
            btnThayDoi.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCauTraLoiMoi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        oldcomboBox = new javax.swing.JComboBox<>();
        newcomboBox = new javax.swing.JComboBox<>();
        btnThayDoi = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change Security Question.png"))); // NOI18N
        jLabel1.setText("Đổi Câu Hỏi Bảo Mật");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 6, 52, 32));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Câu Hỏi Cũ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 203, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Câu Hỏi Mới");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 252, -1, -1));

        txtCauTraLoiMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCauTraLoiMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCauTraLoiMoiActionPerformed(evt);
            }
        });
        txtCauTraLoiMoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCauTraLoiMoiKeyReleased(evt);
            }
        });
        getContentPane().add(txtCauTraLoiMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 298, 318, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Câu Trả Lời Mới");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 301, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mật Khẩu");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 350, -1, -1));

        oldcomboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        oldcomboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Món ăn sáng yêu thích của bạn ?", "Màu sắc yêu thích của bạn  ?", "Cầu thủ yêu thích của bạn ?", "Bài hát yêu thích của bạn ?" }));
        getContentPane().add(oldcomboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 200, 320, -1));

        newcomboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        newcomboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Món ăn sáng yêu thích của bạn ?", "Màu sắc yêu thích của bạn  ?", "Cầu thủ yêu thích của bạn ?", "Bài hát yêu thích của bạn ?" }));
        newcomboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newcomboBoxKeyReleased(evt);
            }
        });
        getContentPane().add(newcomboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 249, 320, -1));

        btnThayDoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThayDoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnThayDoi.setText("Thay Đổi");
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnThayDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 396, -1, 31));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 396, 121, 31));

        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyReleased(evt);
            }
        });
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 320, 30));

        jLabel6.setText("jLabel7");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 910, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCauTraLoiMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCauTraLoiMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCauTraLoiMoiActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void newcomboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newcomboBoxKeyReleased
        validateFiels();
    }//GEN-LAST:event_newcomboBoxKeyReleased

    private void txtCauTraLoiMoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCauTraLoiMoiKeyReleased
        validateFiels();
    }//GEN-LAST:event_txtCauTraLoiMoiKeyReleased

    private void txtMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyReleased
        validateFiels();
    }//GEN-LAST:event_txtMatKhauKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
        String matKhau = txtMatKhau.getText();
        String cauHoiCu = (String) oldcomboBox.getSelectedItem();
        String cauHoiMoi = (String) newcomboBox.getSelectedItem();
        String cauTraLoi = txtCauTraLoiMoi.getText();
        int kq = UserDAO.getInstance().changeQuestion(userEmail, matKhau, cauHoiCu, cauHoiMoi, cauTraLoi);
        if(kq==0){
                    JLabel label = new JLabel("Mật Khẩu Hoặc Câu Hỏi Bảo Mật Cũ Sai!!!");
        label.setFont(new Font("Arial", Font.BOLD, 14));
            JOptionPane.showMessageDialog(null, label,"MESSAGE",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
                    JLabel label = new JLabel("Thay Đổi Câu Hỏi Bảo Mật Thành Công");
        label.setFont(new Font("Arial", Font.BOLD, 14));
            JOptionPane.showMessageDialog(null, label,"MESSAGE",JOptionPane.INFORMATION_MESSAGE);
        }
        setVisible(false);
        new ChangeSecurityQuestion(userEmail).setVisible(true);
    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         new ChangeSecurityQuestion(userEmail).setVisible(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Câu lệnh mà bạn muốn thực hiện sau khoảng thời gian
                setVisible(false);
            }
        };

        Timer timer = new Timer();
        int delay = 30; // Khoảng thời gian (đơn vị: mili giây) trước khi thực hiện câu lệnh
        timer.schedule(task, delay);
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeSecurityQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> newcomboBox;
    private javax.swing.JComboBox<String> oldcomboBox;
    private javax.swing.JTextField txtCauTraLoiMoi;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
