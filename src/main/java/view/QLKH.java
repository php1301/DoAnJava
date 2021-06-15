/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author fanta
 */
public class QLKH extends javax.swing.JFrame {
    /**
     * Creates new form QLKH
     */
    
    DefaultTableModel modelKH = null;
    String ma;
    String username;
    
    private void getRowKH (int index){
//        cbb_LKH.setEnabled(true);
//        txtDTL.setEnabled(true);
//        try{
//            ma = (String) tbKH.getValueAt(index,0);
//            txtHoKH.setText((String)(tbKH.getValueAt(index,1)));
//            txtTenKH.setText((String)(tbKH.getValueAt(index,2)));
//            java.util.Date d_NgSinhKH = new SimpleDateFormat("dd-MM-yyyy").parse((String)(tbKH.getValueAt(index,3)));
//            txtNgS.setDate(d_NgSinhKH);
//            cbb_GTKH.setSelectedItem(tbKH.getValueAt(index,4));
//            cbb_LKH.setSelectedItem(tbKH.getValueAt(index,5));
//            txtDTL.setText(String.valueOf(tbKH.getValueAt(index,6)));
//        }catch(ParseException e){System.out.println(e);} 
    }
    
    private void clearKH(){
//        txtHoKH.setText("");
//        txtTenKH.setText("");
//        txtDTL.setText("0");
//        txtNgS.setDate(null);
//        cbb_GTKH.setSelectedItem(null);
//        cbb_LKH.setSelectedItem(null);
//        cbb_LKH.setEnabled(false);
//        txtDTL.setEnabled(false);
//        txtDTL.setEditable(false);
        
    }
    
    private void setTableKH() {
//        try (Connection con = ConnectionUtils.getMyConnection()){
//            String SQL = "SELECT MAKH,HO,TEN,NGAYSINH,GIOITINH,LOAIKH,TICHLUY,username FROM KHACHHANG ORDER BY MAKH";
//            Statement statement= con.createStatement();
//            ResultSet rs=statement.executeQuery(SQL);
//            modelKH = (DefaultTableModel) tbKH.getModel();
//            modelKH.setRowCount(0);
//            while(rs.next())
//            {
//                String MaKH = rs.getString(1);
//                String HoKH = rs.getString(2);
//                String TenKH = rs.getString(3);
//                java.util.Date d_NgSinhKH = rs.getDate(4);
////                String S_NgSinhKH = String.format("%1$td-%1$tm-%1$tY", d_NgSinhKH);
//                String S_NgSinhKH = new SimpleDateFormat("dd-MM-yyyy").format(d_NgSinhKH);
//                String GTKH = rs.getString(5);
//                String LOAIKH = rs.getString(6);
//                String TL = rs.getString(7);
//                modelKH.addRow(new Object[]{MaKH,HoKH,TenKH,S_NgSinhKH,GTKH,LOAIKH,TL});
//            }
//            con.close();
//        } 
//    catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
//        Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public QLKH() {
        initComponents();
        setTableKH();
        clearKH();
        setLocation(100,40);
        setResizable(false);
        setSize(1200,560);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Trang admin: quản lý khách hàng");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btBack = new javax.swing.JButton();
        txtSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("QUẢN LÝ THÔNG TIN KHÁCH HÀNG");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 390, 41));

        tbKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ và Tên", "Địa chỉ", "Số điện thoại", "Ngày sinh", "Ngày đăng ký", "Doanh số"
            }
        ));
        tbKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKH);
        if (tbKH.getColumnModel().getColumnCount() > 0) {
            tbKH.getColumnModel().getColumn(0).setMaxWidth(40);
            tbKH.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 830, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_more_32px.png"))); // NOI18N
        jLabel1.setText("Tìm kiếm");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 102, -1));

        txtSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 440, 30));

        btBack.setBackground(new java.awt.Color(51, 51, 51));
        btBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBack.setForeground(new java.awt.Color(0, 255, 0));
        btBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_back_to_32px_2.png"))); // NOI18N
        btBack.setText("Quay lại");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });
        jPanel2.add(btBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, 50));

        txtSua.setBackground(new java.awt.Color(51, 51, 51));
        txtSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSua.setForeground(new java.awt.Color(0, 255, 0));
        txtSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_screwdriver_32px.png"))); // NOI18N
        txtSua.setText("Sửa");
        txtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuaActionPerformed(evt);
            }
        });
        jPanel2.add(txtSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 120, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        // TODO add your handling code here:
        hide();
        Admin.main(null);
    }//GEN-LAST:event_btBackActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel SearchTable = (DefaultTableModel) tbKH.getModel();
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(SearchTable);
        tbKH.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tbKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKHMouseClicked
        // TODO add your handling code here:
        //        getRowKH(tbKH.getSelectedRow());
    }//GEN-LAST:event_tbKHMouseClicked

    private void txtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSuaActionPerformed
 public void LayReportQLKH(String a) throws SQLException, JRException {
        // TODO code application logic here
//        String makh = a;
//        HashMap hs= new HashMap();
//        hs.put("makh", makh);
//        String localDir = System.getProperty("user.dir");
    }
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
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QLKH().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton txtSua;
    // End of variables declaration//GEN-END:variables

    private void LayReport(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
