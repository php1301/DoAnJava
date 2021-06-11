/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Helper;
import controller.PhimController;
import controller.TheLoaiController;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import kong.unirest.Unirest;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.TheLoai;

/**
 *
 * @author Admin
 */
public class SuaPhim extends javax.swing.JFrame {

    /**
     * Creates new form SuaPhim
     */
    private File file = null;
    private PhimController phimController;
    private int maPhim;
    private int selectedIndex;
    private Helper helper;
    private TheLoaiController theLoaiController;
    private ArrayList<String> tenTheLoai;

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public SuaPhim() throws SQLException, ClassNotFoundException, ParseException, InterruptedException, MalformedURLException {
        initComponents();
        setTitle("Trang Sửa hoặc xóa Thông Tin Phim");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        phimController = new PhimController();
        helper = new Helper();
        theLoaiController = new TheLoaiController();
        tenTheLoai = new ArrayList<>();
        renderListTheLoai();

    }

    private void connect() {
        try {
            phimController.connect();
            System.out.println("Da connect Phim");
            theLoaiController.connect();
            System.out.println("Da connect the loai");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SuaPhim.this, "Cannot connect to the database", "Database connection Error",
                    JOptionPane.ERROR_MESSAGE);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        maPhimVal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        btOpenFile = new javax.swing.JButton();
        linkImageVal = new javax.swing.JTextField();
        btSua = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tenPhimVal = new javax.swing.JTextField();
        imageSection = new javax.swing.JLabel();
        btXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        trailerVal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        moTaVal = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btBack1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(378, 579));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Tên phim:");

        maPhimVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        maPhimVal.setText("12");
        maPhimVal.setToolTipText("");
        maPhimVal.setEnabled(false);
        maPhimVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maPhimValActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Thời lượng:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("Thể loại:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setText("Ngày phát hành:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("Hình ảnh:");

        btOpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_documents_20px_1.png"))); // NOI18N
        btOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenFileActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(255, 255, 255));
        btSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btSua.setForeground(new java.awt.Color(255, 153, 0));
        btSua.setText("Sửa");
        btSua.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btSuaStateChanged(evt);
            }
        });
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 255));
        jLabel14.setText("Mã phim:");

        tenPhimVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tenPhimVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenPhimValActionPerformed(evt);
            }
        });

        imageSection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btXoa.setBackground(new java.awt.Color(255, 255, 255));
        btXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 0, 0));
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("SỬA HOẶC XÓA PHIM");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 480, 1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 255));
        jLabel16.setText("Trailer: ");

        trailerVal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        trailerVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trailerValActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(98, 98, 98)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(tenPhimVal)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(linkImageVal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(btOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maPhimVal)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(imageSection, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addComponent(jSpinner1)
                            .addComponent(trailerVal)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maPhimVal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenPhimVal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trailerVal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(linkImageVal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(imageSection, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSua)
                    .addComponent(btXoa))
                .addGap(61, 61, 61))
        );

        moTaVal.setColumns(20);
        moTaVal.setRows(5);
        jScrollPane2.setViewportView(moTaVal);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Mô tả phim: ");

        btBack1.setBackground(new java.awt.Color(255, 255, 204));
        btBack1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBack1.setForeground(new java.awt.Color(255, 0, 0));
        btBack1.setText("Quay lại");
        btBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBack1))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addComponent(btBack1)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maPhimValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maPhimValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maPhimValActionPerformed

    private void btOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenFileActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        try {
            fc.setCurrentDirectory(new File(getClass().getResource("./").toURI()));
        } catch (URISyntaxException ex) {
            Logger.getLogger(ThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        fc.addChoosableFileFilter(filter);
        fc.setDialogTitle("Chọn ảnh");
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            System.out.println(file);
            imgurRequest(file);
        }
    }//GEN-LAST:event_btOpenFileActionPerformed
    private void imgurRequest(File f) {
        try {
            String imgurClientId = "4d7220bef63dd30";
            Unirest.config().connectTimeout(1000);
            String response = Unirest.post("https://api.imgur.com/3/image")
                    .header("Authorization", "Client-ID " + imgurClientId)
                    .multiPartContent()
                    .field("image", file)
                    .asJson()
                    .getBody()
                    .getObject()
                    .getJSONObject("data")
                    .get("link")
                    .toString();
            linkImageVal.setText(response);
            showAnh(response);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
        connect();
        java.sql.Date ngayKhoiChieuVal = new java.sql.Date(jDateChooser1.getDate().getTime());
        Object[] o = new Object[7];
        o[0] = tenPhimVal.getText();
        o[1] = jSpinner1.getValue();
        o[2] = jList1.getSelectedValuesList();
        o[3] = ngayKhoiChieuVal;
        o[4] = trailerVal.getText();
        o[5] = linkImageVal.getText();
        o[6] = moTaVal.getText();
        try {
            phimController.suaThongTinPhim(maPhim, o);
            JOptionPane.showMessageDialog(SuaPhim.this, "Sửa thông tin phim thành công", "Thành công",
                    JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(SuaPhim.this, "Xảy ra lỗi khi sửa thông tin phim vui lòng chọn phim khác", "Có lỗi",
                    JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void tenPhimValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenPhimValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenPhimValActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        try {
            int result = JOptionPane.showConfirmDialog(SuaPhim.this, "Bạn có chắc chắc muốn xóa phim này không?", "Xóa phim",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                connect();
                phimController.xoaPhim(maPhim, selectedIndex);
                JOptionPane.showMessageDialog(SuaPhim.this, "Xóa phim thành công", "Xóa phim",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();

            }
        } catch (SQLException ex) {
            Logger.getLogger(SuaPhim.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(SuaPhim.this, "Xảy ra lỗi khi xóa phim vui lòng chọn phim khác", "Có lỗi",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void trailerValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailerValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trailerValActionPerformed

    private void btBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBack1ActionPerformed
        // TODO add your handling code here:
        dispose();
        //        AdminPage_new.main(null);
    }//GEN-LAST:event_btBack1ActionPerformed

    private void btSuaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btSuaStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btSuaStateChanged
    private void showAnh(String name) throws MalformedURLException {
        try {
            URL url = new URL(name);
            Image img = ImageIO.read(url.openStream());
            Image newImg = img.getScaledInstance(imageSection.getWidth(), imageSection.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newImg);
            imageSection.setIcon(image);
        } catch (IOException ex) {
            Logger.getLogger(ThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void renderThongTinPhim() throws MalformedURLException {
        try {
            connect();
            Object[] o = phimController.getThongTinPhim(maPhim);
            maPhimVal.setText(o[0].toString());
            tenPhimVal.setText((String) o[1]);
            jDateChooser1.setDate((Date) o[5]);
            trailerVal.setText((String) o[2]);
            moTaVal.setText((String) o[4]);
            linkImageVal.setText((String) o[3]);
            jSpinner1.setValue((int) o[7]);
            showAnh((String) o[3]);
            btSua.setEnabled(false);
            helper.addChangeListener(tenPhimVal, e -> btSua.setEnabled(true));
            helper.addChangeListener(trailerVal, e -> btSua.setEnabled(true));
            helper.addChangeListener(linkImageVal, e -> btSua.setEnabled(true));
            helper.addChangeListener(moTaVal, e -> btSua.setEnabled(true));

        } catch (SQLException ex) {
            Logger.getLogger(SuaPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void renderListTheLoai() {
        try {
            connect();
            List<TheLoai> tloai = theLoaiController.layDanhSachTheLoai();
            for (TheLoai tl : tloai) {
                tenTheLoai.add(tl.getTenTheLoai());
            }
            jList1.setListData((String[]) tenTheLoai.toArray(new String[0]));
        } catch (SQLException ex) {
            Logger.getLogger(ThemPhim.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(SuaPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SuaPhim().setVisible(true);
                    Thread.sleep(5000);

                } catch (SQLException | ClassNotFoundException | ParseException | InterruptedException ex) {
                    Logger.getLogger(QLPhim.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(SuaPhim.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack1;
    private javax.swing.JButton btOpenFile;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel imageSection;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField linkImageVal;
    private javax.swing.JTextField maPhimVal;
    private javax.swing.JTextArea moTaVal;
    private javax.swing.JTextField tenPhimVal;
    private javax.swing.JTextField trailerVal;
    // End of variables declaration//GEN-END:variables
}
