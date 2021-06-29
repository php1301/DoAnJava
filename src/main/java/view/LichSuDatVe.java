/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LichChieuController;
import controller.PhimController;
import controller.VeController;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Ve;
import model.LichChieu;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import model.Phim;
/**
 *
 * @author Admin
 */
public class LichSuDatVe extends javax.swing.JFrame {

    private VeController veController;
    private DefaultTableModel modelVe = null;
    private LichChieuController LichChieuController;
    private String taiKhoan;
    private Preferences prefs;
    private String defaultPrefs = "Default";
    private PhimController PhimController;
    /**
     * Creates new form LichSuDatVe
     */
    public LichSuDatVe() throws SQLException {
        try {
            initComponents();
            System.out.println("view.LichSuDatVe.<init>()");
            LichChieuController = new LichChieuController();
            veController = new VeController();
            PhimController =new PhimController();
            prefs = Preferences.userRoot().node("db");
            taiKhoan = prefs.get("userId", defaultPrefs);
            createTableLichSuVe();
        } catch (InterruptedException ex) {
            Logger.getLogger(LichSuDatVe.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblichsu = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        btnXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblichsu.setAutoCreateRowSorter(true);
        tblichsu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblichsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã vé", "Tên phim", "Ngày đặt", "Giá vé", "Ngày chiếu", "Giờ chiếu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblichsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblichsuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblichsu);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 73, 691, 188));

        txtSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(0, 204, 0)));
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
        jPanel6.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 25, 200, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 255));
        jLabel37.setText("Tìm kiếm:");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 23, -1, 30));

        btnXuat.setBackground(new java.awt.Color(204, 255, 204));
        btnXuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 0, 255));
        btnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_export_40px_1.png"))); // NOI18N
        btnXuat.setText("Xuất hóa đơn");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });
        jPanel6.add(btnXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 376));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblichsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblichsuMouseClicked
        // TODO add your handling code here:
        //        getRowPhim(tbPhim.getSelectedRow());
    }//GEN-LAST:event_tblichsuMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel SearchTable = (DefaultTableModel) tblichsu.getModel();
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(SearchTable);
        tblichsu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
 try {
            int selectedRow = tblichsu.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(LichSuDatVe.this, "Chua chon lich chieu", "Vui long chon lich chieu", 
                        JOptionPane.ERROR_MESSAGE);
            }

            System.out.println(tblichsu.getValueAt(selectedRow, 4));
             int mave = (int) tblichsu.getValueAt(selectedRow, 0);
             System.out.println(mave);
             String tenPhim = (String) tblichsu.getValueAt(selectedRow, 1);
            java.util.Date Ngaychieu = new SimpleDateFormat("dd-MM-yyyy").parse((tblichsu.getValueAt(selectedRow, 4).toString()));
            int h = Integer.parseInt(tblichsu.getValueAt(selectedRow, 5).toString().substring(0, 2));
            int m = Integer.parseInt(tblichsu.getValueAt(selectedRow, 5).toString().substring(3, 5));
            int s = Integer.parseInt(tblichsu.getValueAt(selectedRow, 5).toString().substring(6, 8));
            System.out.println(h);
            System.out.println(m);
            System.out.println(s);
             java.sql.Time GioChieu = new java.sql.Time(h, m, s);
            XuatHoaDon xuathoadon = new XuatHoaDon();
            xuathoadon.setmaVe(mave);
            xuathoadon.settenphim(tenPhim);
            xuathoadon.setNgaychieu(Ngaychieu);
            xuathoadon.setGioChieu(GioChieu);
            xuathoadon.setSelectedIndex(selectedRow);
            xuathoadon.renderlistVe();
            xuathoadon.setVisible(true);

        } catch (MalformedURLException ex) {
            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LichSuDatVe.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_btnXuatActionPerformed
    public void createTableLichSuVe() throws InterruptedException, SQLException {
        try {
            SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            List<Ve> ve = veController.layDanhSachVeCuaKhachHang(Integer.parseInt(taiKhoan));
            List<LichChieu> lichChieu = LichChieuController.layDanhSachLichChieu();
            List<Phim> Phim = PhimController.layDanhSachPhim();
            modelVe = (DefaultTableModel) tblichsu.getModel();
            modelVe.setRowCount(0);
            for (Ve v : ve) {
                Object[] o = new Object[6];
                o[0] = v.getMaVe();
                o[1] = Phim.get((lichChieu.get(v.getMaLichChieu() - 1).getMaPhim())-1).getTenPhim();
                o[2] = DateFormatter.format(v.getNgayDat());
                o[3] = v.getGiaVe();
                o[4] = DateFormatter.format(lichChieu.get(v.getMaLichChieu()-1).getNgayChieu());
                o[5] = lichChieu.get(v.getMaLichChieu()-1).getGioChieu();
                modelVe.addRow(o);
            }
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(LichSuDatVe.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(LichSuDatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LichSuDatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LichSuDatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LichSuDatVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LichSuDatVe().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(LichSuDatVe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuat;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblichsu;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
