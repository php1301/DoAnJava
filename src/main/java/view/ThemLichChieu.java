/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LichChieuController;
import controller.PhimController;
import controller.PhongController;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Phim;
import model.Phong;

/**
 *
 * @author Hp
 */
public class ThemLichChieu extends javax.swing.JFrame {
    
    private LichChieuController lichChieuController;
    private PhimController phimController;
    private PhongController phongController;
    private ArrayList<String> tenPhim;
    private ArrayList<String> tenRap;
    /**
     * Creates new form ThemLichChieu
     */
    public ThemLichChieu() throws SQLException, ClassNotFoundException, ParseException, InterruptedException {
        initComponents();
        setTitle("Trang Thêm Lịch Chiếu");
        lichChieuController = new LichChieuController();
        phimController = new PhimController();
        tenPhim = new ArrayList<>();
        phongController = new PhongController();
        tenRap = new ArrayList<>();
        renderListPhim();
        renderListPhong();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnquaylai = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        giavetxt = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        giochieu = new com.toedter.calendar.JDateChooser();
        cumrapcbb = new javax.swing.JComboBox<>();
        rapcbb = new javax.swing.JComboBox<>();
        phimcbb = new javax.swing.JComboBox<>();
        hethongcbb = new javax.swing.JComboBox<>();
        Date date=new Date(0);
        SpinnerDateModel sm= new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        timepicker = new javax.swing.JSpinner(sm);
        thoiluongtime = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày giờ chiếu");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giá vé");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phim");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("THÊM THÔNG TIN LỊCH CHIẾU");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 440, 41));

        btnquaylai.setBackground(new java.awt.Color(51, 51, 51));
        btnquaylai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnquaylai.setForeground(new java.awt.Color(0, 255, 0));
        btnquaylai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_back_to_32px_2.png"))); // NOI18N
        btnquaylai.setText("Quay lại");
        btnquaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquaylaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnquaylai, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Thời lượng");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hệ thống rạp");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 100, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cụm rạp");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Rạp");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 100, 30));
        jPanel1.add(giavetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 300, 30));

        btnthem.setBackground(new java.awt.Color(204, 204, 204));
        btnthem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnthem.setForeground(new java.awt.Color(51, 204, 0));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_32px_1.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });
        jPanel1.add(btnthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 130, 40));
        jPanel1.add(giochieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 160, 30));

        cumrapcbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cumrapcbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 300, 30));

        rapcbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rapcbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapcbbActionPerformed(evt);
            }
        });
        jPanel1.add(rapcbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 300, 30));

        phimcbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        phimcbb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                phimcbbItemStateChanged(evt);
            }
        });
        jPanel1.add(phimcbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 300, 30));

        hethongcbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(hethongcbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 300, 30));

        JSpinner.DateEditor de =new JSpinner.DateEditor(timepicker,"HH:mm:ss");
        timepicker.setEditor(de);
        jPanel1.add(timepicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 130, 30));

        thoiluongtime.setModel(new javax.swing.SpinnerNumberModel(0, 0, 480, 1));
        thoiluongtime.setEnabled(false);
        jPanel1.add(thoiluongtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 300, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnquaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquaylaiActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnquaylaiActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        int valuePhim = phimcbb.getSelectedIndex() + 1;
        int valueRap = rapcbb.getSelectedIndex() + 1;
        java.sql.Date ngayChieuVal = new java.sql.Date(giochieu.getDate().getTime());
        int h = Integer.parseInt(timepicker.getValue().toString().substring(11, 13));
        int m = Integer.parseInt(timepicker.getValue().toString().substring(14, 16));
        int s = Integer.parseInt(timepicker.getValue().toString().substring(17, 19));
        java.sql.Time gioChieuVal = new java.sql.Time(h, m, s);
        Object[] o = new Object[6];
        o[0] = valuePhim;
        o[1] = ngayChieuVal;
        o[2] = gioChieuVal;
        o[3] = giavetxt.getText();
        o[4] = valueRap;
        o[5] = thoiluongtime.getValue();
        try {
            lichChieuController.themLichChieu(o);
            JOptionPane.showMessageDialog(ThemLichChieu.this, "Thành công", "Thêm lịch chiếu thành công",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ThemPhim.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(ThemLichChieu.this, "Xảy ra lỗi khi thêm lịch chiếu vui lòng thử lại", "Có lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void rapcbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapcbbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rapcbbActionPerformed

    private void phimcbbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_phimcbbItemStateChanged
        // TODO add your handling code here:
        try {
            Object[] o = phimController.getThongTinPhim(phimcbb.getSelectedIndex() + 1);
            thoiluongtime.setValue((int) o[7]);
        } catch (SQLException ex) {
            Logger.getLogger(SuaLichChieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_phimcbbItemStateChanged
    
    public void renderListPhim() {
        try {
            List<Phim> phim = phimController.layDanhSachPhim();
            for (Phim p : phim) {
                tenPhim.add(p.getTenPhim());
            }
            phimcbb.setModel(new DefaultComboBoxModel<>((String[]) tenPhim.toArray(new String[0])));
            thoiluongtime.setValue(phim.get(0).getThoiLuong());
        } catch (SQLException ex) {
            Logger.getLogger(SuaLichChieu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void renderListPhong() {
        try {
            List<Phong> phong = phongController.layDanhSachPhong();
            for (Phong p : phong) {
                tenRap.add(p.getTenRap());
            }
            rapcbb.setModel(new DefaultComboBoxModel<>((String[]) tenRap.toArray(new String[0])));
            hethongcbb.setModel(new DefaultComboBoxModel<>(new String[] { "BHD Star Cineplex"}));
            cumrapcbb.setModel(new DefaultComboBoxModel<>(new String[] { "BHDStar Hoang Van Thu"}));
        } catch (SQLException ex) {
            Logger.getLogger(SuaLichChieu.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ThemLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemLichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ThemLichChieu().setVisible(true);
                    Thread.sleep(5000);

                } catch (SQLException | ClassNotFoundException | ParseException | InterruptedException ex) {
                    Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnquaylai;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cumrapcbb;
    private javax.swing.JTextField giavetxt;
    private com.toedter.calendar.JDateChooser giochieu;
    private javax.swing.JComboBox<String> hethongcbb;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> phimcbb;
    private javax.swing.JComboBox<String> rapcbb;
    private javax.swing.JSpinner thoiluongtime;
    private javax.swing.JSpinner timepicker;
    // End of variables declaration//GEN-END:variables
}
