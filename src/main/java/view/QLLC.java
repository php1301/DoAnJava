/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author fanta
 */
public class QLLC extends javax.swing.JFrame {

    /**
     * Creates new form QLLC
     */
    
    DefaultTableModel modelLich = null;
    String ma;
    
    ArrayList<String> tenphong = new ArrayList<>();
    ArrayList<String> maphong = new ArrayList<>();
    ArrayList<String> tenphim = new ArrayList<>();
    ArrayList<String> maphim = new ArrayList<>();
    ArrayList<String> sc = new ArrayList<>();
    ArrayList<String> masc = new ArrayList<>();
    ArrayList<String> ngc = new ArrayList<>();
    
    private void setTableLC(){    
//        try (Connection con = ConnectionUtils.getMyConnection()){
//            String SQL = "SELECT MALICHCHIEU,TENPHIM,TENPHONG,THOIGIANBD,NGAYCHIEU,THOILUONG \n" 
//            + "FROM LICHCHIEU,PHIM,PHONG,SUATCHIEU \n" 
//            + "WHERE LICHCHIEU.MASUAT=SUATCHIEU.MASUAT AND LICHCHIEU.MASUAT = SUATCHIEU.MASUAT AND LICHCHIEU.MAPHIM = PHIM.MAPHIM AND LICHCHIEU.MAPHONG = PHONG.MAPHONG\n" 
//            + "ORDER BY MALICHCHIEU";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(SQL);
//            SimpleDateFormat TimeFormatter = new SimpleDateFormat("HH:mm");
//            SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");
//            modelLich = (DefaultTableModel) tbLC.getModel();
//            modelLich.setRowCount(0);
//            while(rs.next()){
//                    String MaLich = rs.getString("MALICHCHIEU");
//                    String Phim = rs.getString("TENPHIM");
//                    String Phong = rs.getString("TENPHONG");
//                    Date t_TGBD = rs.getTime("THOIGIANBD");
//                    Date t_TLuong = rs.getTime("THOILUONG");
//                    String S_TGBD = TimeFormatter.format(t_TGBD);
//                    String S_TLuong = TimeFormatter.format(t_TLuong);
//                    int h = Integer.parseInt(S_TLuong.substring(0,2));
//                    int m = Integer.parseInt(S_TLuong.substring(3,5));
//                    Date TGBD = TimeFormatter.parse(S_TGBD);
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTime(TGBD);
//                    cal.add(Calendar.MINUTE, m);
//                    cal.add(Calendar.HOUR_OF_DAY, h);
//                    String time = TimeFormatter.format(cal.getTime());
//                    String d_NgChieu = DateFormatter.format(rs.getDate("NGAYCHIEU"));
//                    modelLich.addRow(new Object[]{MaLich,Phim,Phong,S_TGBD,time,d_NgChieu});
//                }
//            con.close();
//        } 
//        catch (Exception ex){
//            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    private void setCbb_Phim(){
//        try (Connection con = ConnectionUtils.getMyConnection()){
//            String SQL = "SELECT DISTINCT MAPHIM,TENPHIM FROM PHIM ORDER BY MAPHIM";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(SQL);
//            cbbPhim.removeAllItems();
//            maphim.clear();
//            tenphim.clear();
//            while(rs.next()){
//                maphim.add(rs.getString("MAPHIM"));
//                tenphim.add(rs.getString("TENPHIM"));
//            }
//            cbbPhim.setModel(new DefaultComboBoxModel(tenphim.toArray()));
//        } catch (Exception ex) {
//            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    private void setCbb_Phong(){
//        try (Connection con = ConnectionUtils.getMyConnection()){
//            String SQL = "SELECT DISTINCT MAPHONG,TENPHONG FROM PHONG ORDER BY MAPHONG";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(SQL);
//            cbbPhong.removeAllItems();
//            maphong.clear();
//            tenphong.clear();
//            while(rs.next()){
//                maphong.add(rs.getString("MAPHONG"));
//                tenphong.add(rs.getString("TENPHONG"));
//            }
//            cbbPhong.setModel(new DefaultComboBoxModel(tenphong.toArray()));
//        } catch (Exception ex) {
//            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    } 
    
    private void setCbb_NgC(){
//        try (Connection con = ConnectionUtils.getMyConnection()){
//            SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");
//            String SQL = "SELECT DISTINCT NGAYCHIEU FROM SUATCHIEU ORDER BY NGAYCHIEU";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(SQL);
//            cbbNgC.removeAllItems();
//            ngc.clear();
//            while(rs.next()){
//                String ngchieu = DateFormatter.format(rs.getDate("NGAYCHIEU"));
//                ngc.add(ngchieu);
//            }
//            cbbNgC.setModel(new DefaultComboBoxModel(ngc.toArray()));
//        } catch (Exception ex) {
//            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    private void getRowLC (int index){
//        try{
//            ma = (String)tbLC.getValueAt(index,0);
//            cbbPhim.setSelectedItem(tbLC.getValueAt(index,1));
//            cbbPhong.setSelectedItem(tbLC.getValueAt(index,2));
//            String date = (String)tbLC.getValueAt(index,5);
//            cbbNgC.setSelectedItem(date);
//            String time = (String)tbLC.getValueAt(index,3);
//            cbbSC.setSelectedItem(time);
//        }catch(Exception e){
//            System.out.println(e);
//        }
    }
    
    private void clearLC(){
//        cbbPhong.setSelectedItem(null);
//        cbbPhim.setSelectedItem(null);
//        cbbNgC.setSelectedItem(null);
//        cbbSC.setSelectedItem(null);
    }
    
    public QLLC() {
        initComponents();
        setTableLC();
        setCbb_Phim();
        setCbb_Phong();
        setCbb_NgC();
        clearLC();

        /*1. Set kích thước giao diện*/
        setLocation(100,40);
        /*2. Set nút chọn tắt mặc định EXIT_ON_CLOSE*/ 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Trang admin: quản lý lịch chiếu");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btBack = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbLC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbLC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Phim", "Ngày giờ chiếu", "Thời Lượng", "Giá vé", "Hệ thống rạp", "Cụm rạp", "Rạp"
            }
        ));
        tbLC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLC);
        if (tbLC.getColumnModel().getColumnCount() > 0) {
            tbLC.getColumnModel().getColumn(0).setMinWidth(40);
            tbLC.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbLC.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 780, 322));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_more_32px.png"))); // NOI18N
        jLabel1.setText("Tìm kiếm");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

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
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 600, 30));

        btBack.setBackground(new java.awt.Color(255, 255, 255));
        btBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBack.setForeground(new java.awt.Color(0, 255, 0));
        btBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_back_to_32px_2.png"))); // NOI18N
        btBack.setText("Quay lại");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });
        jPanel2.add(btBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, -1, 40));

        btThem.setBackground(new java.awt.Color(255, 255, 255));
        btThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btThem.setForeground(new java.awt.Color(0, 153, 51));
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_32px_1.png"))); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });
        jPanel2.add(btThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        btSua.setBackground(new java.awt.Color(255, 255, 255));
        btSua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSua.setForeground(new java.awt.Color(0, 0, 255));
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_job_32px_1.png"))); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 115, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("QUẢN LÝ THÔNG TIN LỊCH CHIẾU");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 390, 41));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
//        try(Connection con = ConnectionUtils.getMyConnection()){          
//            String MaSC = masc.get(cbbSC.getSelectedIndex());
//            String MaPhong = maphong.get(cbbPhong.getSelectedIndex());
//            String MaPhim = maphim.get(cbbPhim.getSelectedIndex());
//            String SQL = "INSERT INTO LICHCHIEU(MALICHCHIEU,MASUAT,MAPHIM,MAPHONG)"
//            +"VALUES(MALICHCHIEU_SEQ7.NEXTVAL,"+MaSC+","+MaPhim+","+MaPhong+")";
//            Statement stat = con.createStatement();
//            stat.executeUpdate(SQL);
//            setTableLC();
//            getRowLC(tbLC.getRowCount()-1);
//            con.close();
//            JOptionPane.showMessageDialog(this,"Thành công!");
//        }
//        catch (SQLException ex){
//            if(ex.getErrorCode()==20005)
//             {
//                 JOptionPane.showMessageDialog(this,"Lịch này đã có rồi","Lỗi trùng lịch chiếu",JOptionPane.ERROR_MESSAGE);
//             }
//
//        } catch (ClassNotFoundException ex) {
//           
//        }  
//       
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
//        try(Connection con = ConnectionUtils.getMyConnection()){          
//            String MaSC = masc.get(cbbSC.getSelectedIndex());
//            String MaPhong = maphong.get(cbbPhong.getSelectedIndex());
//            String MaPhim = maphim.get(cbbPhim.getSelectedIndex());
//            String SQL = "UPDATE LICHCHIEU SET MASUAT = " +MaSC+ ", MAPHIM = "+MaPhim+", MAPHONG = "+MaPhong+" WHERE MALICHCHIEU = "+ ma;
//            Statement stat = con.createStatement();
//            stat.executeUpdate(SQL);
//            setTableLC();
//            con.close();
//            JOptionPane.showMessageDialog(this,"Thành công!");
//        }
//        catch (SQLException ex){
//            if(ex.getErrorCode()==20005)
//             {
//                 JOptionPane.showMessageDialog(this,"Lịch này đã có rồi","Lỗi trùng lịch chiếu",JOptionPane.ERROR_MESSAGE);
//             }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
//        } 
    }//GEN-LAST:event_btSuaActionPerformed

    private void tbLCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLCMouseClicked
        // TODO add your handling code here:
        getRowLC(tbLC.getSelectedRow());
    }//GEN-LAST:event_tbLCMouseClicked

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        // TODO add your handling code here:
        hide();
        Admin.main(null);
    }//GEN-LAST:event_btBackActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel SearchTable = (DefaultTableModel) tbLC.getModel();
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(SearchTable);
        tbLC.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(QLLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLLC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLLC().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLC;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
