/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import MyUtil.MyUtil;
import MyUtil.OpenPDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.BillDAO;
import dao.BillDetailsDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.BillDetails;
import model.Category;
import model.Product;

/**
 *
 * @author LEGION 5 PRO
 */
public class PlaceOrder extends javax.swing.JFrame {
    public String email;
    public int billID = 1;
    public int tongBill = 0;
    public int giaMon = 0;
    public int tongMon = 0;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String soDienThoaiPattern = "^[0-9]*$";
    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
       
        btnTaoVaInBill.setEnabled(false);
        jTable1.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        tableCTHD.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        
        jTable1.setRowHeight(25);
        MyUtil.setJTableColumnsWidth(jTable1, 480, 10, 18, 18, 18,18,18,18);
        tableCTHD.setRowHeight(25);
        MyUtil.setJTableColumnsWidth(tableCTHD, 480, 10, 18, 18, 18,18,18,18);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon icon = new ImageIcon("src/images/full-page-background.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sicon = new ImageIcon(imgScale);
        jLabel14.setIcon(sicon);
    }
    public PlaceOrder(String userEmail) {
        initComponents();
        
        txtTenMon.setEditable(false);
        txtGiaThanh.setEditable(false);
        txtTongCong.setEditable(false);
        btnThemVaoGio.setEnabled(false);
        btnTaoVaInBill.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spinnerSoLuong.getEditor()).getTextField();
        tf.setEnabled(false);
        
        jTable1.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        tableCTHD.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        
        jTable1.setRowHeight(25);
        MyUtil.setJTableColumnsWidth(jTable1, 480, 10, 18, 18, 18,18,18,18);
        tableCTHD.setRowHeight(25);
        MyUtil.setJTableColumnsWidth(tableCTHD, 300, 3000,3000,1000,3000);
        
        email = userEmail;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon icon = new ImageIcon("src/images/full-page-background.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sicon = new ImageIcon(imgScale);
        jLabel14.setIcon(sicon);
    }
    public void productNameByCategory(int category){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDAO.selectAll(category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()){
            Product product = itr.next();
            dtm.addRow(new Object[]{
                product.getTenSanPham()
            });
        }
    }
    public void filterProductByName(String name,String category){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDAO.selectAll(name,category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()){
            Product po = itr.next();
            dtm.addRow(new Object[]{
                po.getTenSanPham()
            });
        }
    }
    public void clearProductFields(){
        txtTenMon.setText("");
        txtGiaThanh.setText("");
        spinnerSoLuong.setValue(1);
        txtTongCong.setText("");
        btnThemVaoGio.setEnabled(false);
    }
    public void validateFields(){
        String ten = txtHoVaTen.getText();
//        String soDienThoai = txtSoDienThoai.getText();
//        String cusemail = txtEmail.getText();
        if(!ten.equals("")&&tongBill>0){
            btnTaoVaInBill.setEnabled(true);
        }
        else{
            btnTaoVaInBill.setEnabled(false);
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
        btnThoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbBillID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboBoxLoaiHinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        txtGiaThanh = new javax.swing.JTextField();
        txtTongCong = new javax.swing.JTextField();
        spinnerSoLuong = new javax.swing.JSpinner();
        btnClear = new javax.swing.JButton();
        btnThemVaoGio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTHD = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnTaoVaInBill = new javax.swing.JButton();
        lbGrandTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxPTTT = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Đặt Món");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1655, 6, 46, 32));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Bill ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 271, -1, -1));

        lbBillID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbBillID.setText("--");
        getContentPane().add(lbBillID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 271, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Thông Tin Khách Hàng:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 308, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Họ Và Tên");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, -1));

        txtHoVaTen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtHoVaTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoVaTenActionPerformed(evt);
            }
        });
        txtHoVaTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoVaTenKeyReleased(evt);
            }
        });
        getContentPane().add(txtHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 395, 330, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Loại Hình");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 271, -1, -1));

        comboBoxLoaiHinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        comboBoxLoaiHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxLoaiHinhActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxLoaiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 380, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Tìm Kiếm Theo Tên");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 355, -1, -1));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 395, 380, 29));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 453, 373, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Tên");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1054, 272, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Giá Thành");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1417, 272, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tổng Cộng");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1417, 355, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Số Lượng");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1054, 355, -1, -1));

        txtTenMon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtTenMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 310, 272, 40));

        txtGiaThanh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtGiaThanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1417, 314, 272, 29));

        txtTongCong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtTongCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1417, 395, 272, 29));

        spinnerSoLuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerSoLuongStateChanged(evt);
            }
        });
        spinnerSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spinnerSoLuongKeyReleased(evt);
            }
        });
        getContentPane().add(spinnerSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1054, 393, 272, 30));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1054, 453, 139, -1));

        btnThemVaoGio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemVaoGio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnThemVaoGio.setText("Thêm Vào Giỏ");
        btnThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoGioActionPerformed(evt);
            }
        });
        getContentPane().add(btnThemVaoGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 460, -1, -1));

        tableCTHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giá Thành", "Số Lượng", "Tổng Cộng"
            }
        ));
        tableCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCTHD);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 515, 656, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Tổng Bill: ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 998, -1, -1));

        btnTaoVaInBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTaoVaInBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btnTaoVaInBill.setText("Tạo Và In Bill");
        btnTaoVaInBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoVaInBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnTaoVaInBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 990, -1, -1));

        lbGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbGrandTotal.setText("000");
        getContentPane().add(lbGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1136, 998, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Phương Thức Thanh Toán");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        comboBoxPTTT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        comboBoxPTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Thẻ Tín Dụng" }));
        comboBoxPTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPTTTActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxPTTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 330, -1));

        jLabel14.setText("jLabel3");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1730, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        billID = Integer.parseInt(BillDAO.getID());
        lbBillID.setText(BillDAO.getID());
        ArrayList<Category> list = CategoryDAO.getInstance().selectAll();
        Iterator<Category> itr = list.iterator();
        while(itr.hasNext()){
            Category category = itr.next();
            comboBoxLoaiHinh.addItem(category.getTenLoaiHinh());
        }
        comboBoxLoaiHinh.setSelectedIndex(1);
        int category = CategoryDAO.getInstance().getCategoryByName((String) comboBoxLoaiHinh.getSelectedItem()).getId();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String tenSanPham = txtTimKiem.getText();
        String category =   (String) comboBoxLoaiHinh.getSelectedItem();
        filterProductByName(tenSanPham, category);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String ProductName = model.getValueAt(index, 0).toString();
        Product product = ProductDAO.getProductByName(ProductName);
        txtTenMon.setText(product.getTenSanPham());
        txtGiaThanh.setText(product.getGiaThanh());
        spinnerSoLuong.setValue(1);
        txtTongCong.setText(product.getGiaThanh());
        giaMon = Integer.parseInt(product.getGiaThanh());
        tongMon = Integer.parseInt(product.getGiaThanh());
        btnThemVaoGio.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void spinnerSoLuongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerSoLuongStateChanged
        int quantity = (Integer) spinnerSoLuong.getValue();
        if(quantity<=1){
            spinnerSoLuong.setValue(1);
            quantity = 1;
        }
        tongMon = giaMon * quantity;
        txtTongCong.setText(MyUtil.FormatNumber().format(tongMon));
        
    }//GEN-LAST:event_spinnerSoLuongStateChanged

    private void comboBoxLoaiHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLoaiHinhActionPerformed
        int category = CategoryDAO.getInstance().getCategoryByName((String) comboBoxLoaiHinh.getSelectedItem()).getId();
        productNameByCategory(category);
    }//GEN-LAST:event_comboBoxLoaiHinhActionPerformed

    private void btnThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoGioActionPerformed
        String ten = txtTenMon.getText();
        String giaThanh = txtGiaThanh.getText();
        String soLuong = String.valueOf(spinnerSoLuong.getValue());
        DefaultTableModel dtm2 = (DefaultTableModel) tableCTHD.getModel();
        tongBill+=tongMon;
        lbGrandTotal.setText(MyUtil.FormatNumber().format(tongBill));
        dtm2.addRow(new Object[]{
            ten,MyUtil.FormatNumber().format(Integer.parseInt(giaThanh)),soLuong,MyUtil.FormatNumber().format(tongMon)
        });
        clearProductFields();
        validateFields();
    }//GEN-LAST:event_btnThemVaoGioActionPerformed

    private void txtHoVaTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoVaTenKeyReleased
        validateFields();
    }//GEN-LAST:event_txtHoVaTenKeyReleased

    private void btnTaoVaInBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoVaInBillActionPerformed
        String cusName = txtHoVaTen.getText();
//        String soDienThoai = txtSoDienThoai.getText();
//        String Cusemail = txtEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String todayDate = dFormat.format(date);
        String tongCongBill  = String.valueOf(tongBill);
        String duocTaoBoi = email;
        String pttt = (String) comboBoxPTTT.getSelectedItem();
        Bill bill = new Bill();
        bill.setId(billID);
        bill.setTen(cusName);
//        bill.setSoDienThoai(soDienThoai);
//        bill.setEmail(Cusemail);
        bill.setPhuongthucthanhtoan(pttt);
        bill.setThoiDiemDen(todayDate);
        bill.setTongCong(tongCongBill);
        bill.setDuocTaoBoi(duocTaoBoi);
        BillDAO.insert(bill);
        //CTHD
        for(int i=0;i<tableCTHD.getRowCount();i++){
            BillDetails billDetails = new BillDetails();
            int masanpham  = ProductDAO.getProductByName((String)tableCTHD.getValueAt(i, 0)).getId();
            int soluong = Integer.parseInt((String)tableCTHD.getValueAt(i, 2));
            billDetails.setMahoadon(billID);
            System.out.println(billID);
            billDetails.setMasanpham(masanpham);
            billDetails.setSoluong(soluong);
            BillDetailsDAO billDetailsDAO = new BillDetailsDAO();
            billDetailsDAO.insert(billDetails);
        }
        //Creating document
        //Create file
         String directoryPath = "D:\\BillCafe"; // Đường dẫn thư mục bạn muốn tạo

        File directory = new File(directoryPath);

        if (!directory.exists()) { // Kiểm tra xem thư mục đã tồn tại chưa
            boolean created = directory.mkdir(); // Tạo thư mục

            if (created) {
                System.out.println("Thư mục đã được tạo.");
            } else {
                System.out.println("Không thể tạo thư mục.");
            }
        } else {
            System.out.println("Thư mục đã tồn tại.");
        }
        //
        String path = "D:\\BillCafe\\";
        com.itextpdf.text.Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+""+billID+".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                           Cafe Can Tho\n");
            doc.add(cafeName);
            Paragraph starline = new Paragraph("***************************************************************************************************************\n"
                    + "ID: "+billID
                    + "\nCustomer Name: "+bill.getTen()
                    + "\nDate: "+bill.getThoiDiemDen()
                    + "\nTotal: "+MyUtil.FormatNumber().format(Integer.parseInt(bill.getTongCong())) +" VND"
                    + "\nCreate By: "+email+"\n\n");
            
            doc.add(starline);
            doc.add(new Paragraph("***************************************************************************************************************\n\n")); 
            PdfPTable tb1 = new PdfPTable(4) {
            };
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for(int i=0;i<tableCTHD.getRowCount();i++){
                String a = tableCTHD.getValueAt(i, 0).toString();
                String b = tableCTHD.getValueAt(i, 1).toString();
                String c = tableCTHD.getValueAt(i, 2).toString();
                String d = tableCTHD.getValueAt(i, 3).toString();
                tb1.addCell(a);
                tb1.addCell(b);
                tb1.addCell(c);
                tb1.addCell(d);
            }
            doc.add(tb1);
            Paragraph thanks = new Paragraph("\n***************************************************************************************************************\n\n"+" Chuc Quy Khach Mot Ngay Moi Vui Ve\n\n");
            doc.add(thanks);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"ERROR", JOptionPane.ERROR);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(email).setVisible(true);
        OpenPDF.openByID(String.valueOf(billID));
    }//GEN-LAST:event_btnTaoVaInBillActionPerformed

    private void spinnerSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinnerSoLuongKeyReleased
        validateFields();
    }//GEN-LAST:event_spinnerSoLuongKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearProductFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tableCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCTHDMouseClicked
        int index = tableCTHD.getSelectedRow();
        JLabel label = new JLabel("Bạn Có Muốn Xóa Món Này Khỏi Danh Sách ?");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        int a = JOptionPane.showConfirmDialog(null,label ,"SELECT",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(a==0){
            TableModel model = tableCTHD.getModel();
            String total = model.getValueAt(index, 3).toString();
            tongBill -= Integer.parseInt(total);
            lbGrandTotal.setText(String.valueOf(tongBill));
            ((DefaultTableModel) tableCTHD.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_tableCTHDMouseClicked

    private void txtHoVaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoVaTenActionPerformed
        validateFields();
    }//GEN-LAST:event_txtHoVaTenActionPerformed

    private void comboBoxPTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPTTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxPTTTActionPerformed

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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnTaoVaInBill;
    private javax.swing.JButton btnThemVaoGio;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> comboBoxLoaiHinh;
    private javax.swing.JComboBox<String> comboBoxPTTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbBillID;
    private javax.swing.JLabel lbGrandTotal;
    private javax.swing.JSpinner spinnerSoLuong;
    private javax.swing.JTable tableCTHD;
    private javax.swing.JTextField txtGiaThanh;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongCong;
    // End of variables declaration//GEN-END:variables
}
