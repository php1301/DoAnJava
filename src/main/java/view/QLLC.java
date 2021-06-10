/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ConnectionUtils;
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
        try (Connection con = ConnectionUtils.getMyConnection()){
            String SQL = "SELECT MALICHCHIEU,TENPHIM,TENPHONG,THOIGIANBD,NGAYCHIEU,THOILUONG \n" 
            + "FROM LICHCHIEU,PHIM,PHONG,SUATCHIEU \n" 
            + "WHERE LICHCHIEU.MASUAT=SUATCHIEU.MASUAT AND LICHCHIEU.MASUAT = SUATCHIEU.MASUAT AND LICHCHIEU.MAPHIM = PHIM.MAPHIM AND LICHCHIEU.MAPHONG = PHONG.MAPHONG\n" 
            + "ORDER BY MALICHCHIEU";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            SimpleDateFormat TimeFormatter = new SimpleDateFormat("HH:mm");
            SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            modelLich = (DefaultTableModel) tbLC.getModel();
            modelLich.setRowCount(0);
            while(rs.next()){
                    String MaLich = rs.getString("MALICHCHIEU");
                    String Phim = rs.getString("TENPHIM");
                    String Phong = rs.getString("TENPHONG");
                    Date t_TGBD = rs.getTime("THOIGIANBD");
                    Date t_TLuong = rs.getTime("THOILUONG");
                    String S_TGBD = TimeFormatter.format(t_TGBD);
                    String S_TLuong = TimeFormatter.format(t_TLuong);
                    int h = Integer.parseInt(S_TLuong.substring(0,2));
                    int m = Integer.parseInt(S_TLuong.substring(3,5));
                    Date TGBD = TimeFormatter.parse(S_TGBD);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(TGBD);
                    cal.add(Calendar.MINUTE, m);
                    cal.add(Calendar.HOUR_OF_DAY, h);
                    String time = TimeFormatter.format(cal.getTime());
                    String d_NgChieu = DateFormatter.format(rs.getDate("NGAYCHIEU"));
                    modelLich.addRow(new Object[]{MaLich,Phim,Phong,S_TGBD,time,d_NgChieu});
                }
            con.close();
        } 
        catch (Exception ex){
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setCbb_Phim(){
        try (Connection con = ConnectionUtils.getMyConnection()){
            String SQL = "SELECT DISTINCT MAPHIM,TENPHIM FROM PHIM ORDER BY MAPHIM";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            cbbPhim.removeAllItems();
            maphim.clear();
            tenphim.clear();
            while(rs.next()){
                maphim.add(rs.getString("MAPHIM"));
                tenphim.add(rs.getString("TENPHIM"));
            }
            cbbPhim.setModel(new DefaultComboBoxModel(tenphim.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setCbb_Phong(){
        try (Connection con = ConnectionUtils.getMyConnection()){
            String SQL = "SELECT DISTINCT MAPHONG,TENPHONG FROM PHONG ORDER BY MAPHONG";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            cbbPhong.removeAllItems();
            maphong.clear();
            tenphong.clear();
            while(rs.next()){
                maphong.add(rs.getString("MAPHONG"));
                tenphong.add(rs.getString("TENPHONG"));
            }
            cbbPhong.setModel(new DefaultComboBoxModel(tenphong.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private void setCbb_NgC(){
        try (Connection con = ConnectionUtils.getMyConnection()){
            SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            String SQL = "SELECT DISTINCT NGAYCHIEU FROM SUATCHIEU ORDER BY NGAYCHIEU";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            cbbNgC.removeAllItems();
            ngc.clear();
            while(rs.next()){
                String ngchieu = DateFormatter.format(rs.getDate("NGAYCHIEU"));
                ngc.add(ngchieu);
            }
            cbbNgC.setModel(new DefaultComboBoxModel(ngc.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getRowLC (int index){
        try{
            ma = (String)tbLC.getValueAt(index,0);
            cbbPhim.setSelectedItem(tbLC.getValueAt(index,1));
            cbbPhong.setSelectedItem(tbLC.getValueAt(index,2));
            String date = (String)tbLC.getValueAt(index,5);
            cbbNgC.setSelectedItem(date);
            String time = (String)tbLC.getValueAt(index,3);
            cbbSC.setSelectedItem(time);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void clearLC(){
        cbbPhong.setSelectedItem(null);
        cbbPhim.setSelectedItem(null);
        cbbNgC.setSelectedItem(null);
        cbbSC.setSelectedItem(null);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbPhim = new javax.swing.JComboBox<>();
        cbbPhong = new javax.swing.JComboBox<>();
        cbbNgC = new javax.swing.JComboBox<>();
        cbbSC = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btLamMoi = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1082, 510));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Phim:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Phòng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày chiếu:");

        cbbPhim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbPhim.setMaximumRowCount(20);

        cbbPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbPhong.setMaximumRowCount(10);
        cbbPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPhongActionPerformed(evt);
            }
        });

        cbbNgC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbNgC.setMaximumRowCount(20);
        cbbNgC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNgCItemStateChanged(evt);
            }
        });
        cbbNgC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNgCActionPerformed(evt);
            }
        });

        cbbSC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbSC.setMaximumRowCount(20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Giờ:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIandBUS/calendar (3).png"))); // NOI18N
        jLabel6.setText(" THÔNG TIN LỊCH CHIẾU");

        btLamMoi.setBackground(new java.awt.Color(51, 51, 51));
        btLamMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btLamMoi.setForeground(new java.awt.Color(0, 255, 0));
        btLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_reboot_24px_1.png"))); // NOI18N
        btLamMoi.setText("Reset");
        btLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiActionPerformed(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(51, 51, 51));
        btThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btThem.setForeground(new java.awt.Color(0, 153, 51));
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_32px_1.png"))); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(51, 51, 51));
        btXoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 51, 0));
        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_minus_32px.png"))); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(51, 51, 51));
        btSua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSua.setForeground(new java.awt.Color(0, 0, 255));
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_job_32px_1.png"))); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbSC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNgC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btThem)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbbPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbNgC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btXoa)
                    .addComponent(btSua))
                .addGap(18, 18, 18)
                .addComponent(btLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        tbLC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbLC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Phim", "Phòng", "Bắt đầu", "Kết thúc", "Ngày chiếu"
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_more_32px.png"))); // NOI18N
        jLabel1.setText("Tìm kiếm");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btBack)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        try(Connection con = ConnectionUtils.getMyConnection()){          
            String MaSC = masc.get(cbbSC.getSelectedIndex());
            String MaPhong = maphong.get(cbbPhong.getSelectedIndex());
            String MaPhim = maphim.get(cbbPhim.getSelectedIndex());
            String SQL = "INSERT INTO LICHCHIEU(MALICHCHIEU,MASUAT,MAPHIM,MAPHONG)"
            +"VALUES(MALICHCHIEU_SEQ7.NEXTVAL,"+MaSC+","+MaPhim+","+MaPhong+")";
            Statement stat = con.createStatement();
            stat.executeUpdate(SQL);
            setTableLC();
            getRowLC(tbLC.getRowCount()-1);
            con.close();
            JOptionPane.showMessageDialog(this,"Thành công!");
        }
        catch (SQLException ex){
            if(ex.getErrorCode()==20005)
             {
                 JOptionPane.showMessageDialog(this,"Lịch này đã có rồi","Lỗi trùng lịch chiếu",JOptionPane.ERROR_MESSAGE);
             }

        } catch (ClassNotFoundException ex) {
           
        }  
       
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
        try(Connection con = ConnectionUtils.getMyConnection()){          
            String MaSC = masc.get(cbbSC.getSelectedIndex());
            String MaPhong = maphong.get(cbbPhong.getSelectedIndex());
            String MaPhim = maphim.get(cbbPhim.getSelectedIndex());
            String SQL = "UPDATE LICHCHIEU SET MASUAT = " +MaSC+ ", MAPHIM = "+MaPhim+", MAPHONG = "+MaPhong+" WHERE MALICHCHIEU = "+ ma;
            Statement stat = con.createStatement();
            stat.executeUpdate(SQL);
            setTableLC();
            con.close();
            JOptionPane.showMessageDialog(this,"Thành công!");
        }
        catch (SQLException ex){
            if(ex.getErrorCode()==20005)
             {
                 JOptionPane.showMessageDialog(this,"Lịch này đã có rồi","Lỗi trùng lịch chiếu",JOptionPane.ERROR_MESSAGE);
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btSuaActionPerformed

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        // TODO add your handling code here:
        clearLC();
    }//GEN-LAST:event_btLamMoiActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        try(Connection con = ConnectionUtils.getMyConnection()){
            String SQL = "DELETE FROM LICHCHIEU WHERE MALICHCHIEU = "+ ma;
            Statement stat = con.createStatement();
            stat.executeUpdate(SQL);
            setTableLC();
            clearLC();
            con.close();
            JOptionPane.showMessageDialog(this,"Thành công!");
        } catch (Exception ex){
            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Xóa không thành công!","Lỗi",JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void cbbNgCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNgCItemStateChanged
        // TODO add your handling code here:
        cbbSC.setVisible(true);
        try (Connection con = ConnectionUtils.getMyConnection()){
            SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat TimeFormatter = new SimpleDateFormat("HH:mm");
            Date d_NgC = DateFormatter.parse((String)cbbNgC.getSelectedItem());
            String S_NgC = DateFormatter.format(d_NgC);
            String SQL = "SELECT MASUAT,THOIGIANBD FROM SUATCHIEU WHERE NGAYCHIEU = TO_DATE('"+S_NgC+"','dd-MM-yyyy') ORDER BY MASUAT";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            cbbSC.removeAllItems();
            masc.clear();
            sc.clear();
            while(rs.next()){
                masc.add(rs.getString("MASUAT"));
                String tgbd = TimeFormatter.format(rs.getTime("THOIGIANBD"));
                sc.add(tgbd);
            }
            cbbSC.setModel(new DefaultComboBoxModel(sc.toArray()));
            cbbSC.setSelectedItem(null);
        } catch (Exception ex) {
            Logger.getLogger(QLLC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbNgCItemStateChanged

    private void tbLCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLCMouseClicked
        // TODO add your handling code here:
        getRowLC(tbLC.getSelectedRow());
    }//GEN-LAST:event_tbLCMouseClicked

    private void cbbPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPhongActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        // TODO add your handling code here:
        hide();
        AdminPage_new.main(null);
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

    private void cbbNgCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNgCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNgCActionPerformed

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
    private javax.swing.JButton btLamMoi;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbbNgC;
    private javax.swing.JComboBox<String> cbbPhim;
    private javax.swing.JComboBox<String> cbbPhong;
    private javax.swing.JComboBox<String> cbbSC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLC;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
