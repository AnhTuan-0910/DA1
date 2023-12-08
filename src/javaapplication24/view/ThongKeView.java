package javaapplication24.view;

import java.text.DecimalFormat;
import java.util.List;
import javaapplication24.model.ThongKeDoanhThu;
import javaapplication24.model.ThongKeHangHetHan;
import javaapplication24.model.ThongKeHoaDon;
import javaapplication24.model.ThongKeKhachHang;
import javaapplication24.model.ThongKeTable;
import javaapplication24.service.ThongKeService;

import javax.swing.table.DefaultTableModel;



public class ThongKeView extends javax.swing.JPanel {
private ThongKeService thongKeService;
    public ThongKeView() {
        initComponents();
        thongKeService = new ThongKeService();
         
       doanhThuAll();
        khachHangAll();
        HoaDonAll();
        loadTableTKAll();
        loadTableTKHangHetHan();
        
    }
    public void khachHangMonth(){
        String month = cboThang.getSelectedItem().toString();
       
         String year = cboNam.getSelectedItem().toString();
         ThongKeKhachHang tkkh = new ThongKeKhachHang("", month, year);
       List<ThongKeKhachHang> ds = thongKeService.ThongKeKhMonth(tkkh);
         for (ThongKeKhachHang tk : ds) {
               btnSoKhachHang.setText("<html>Khách Hàng: "+"<div style='text-align:center'>"+tk.getTongKH()+"</div>"+"</html>");
             btnSoKhachHang.setHorizontalAlignment(btnSoKhachHang.CENTER);
         
        }}
    
          public void hoaDonMonth(){
        String month = cboThang.getSelectedItem().toString();
       
         String year = cboNam.getSelectedItem().toString();
         ThongKeHoaDon tkhd = new ThongKeHoaDon("", month, year);
       List<ThongKeHoaDon> ds = thongKeService.ThongKeHDMonth(tkhd);
         for (ThongKeHoaDon tk : ds) {
               btnSoHoaDon.setText("<html>Hóa Đơn: "+"<div style='text-align:center'>"+tk.getTongHD()+"</div>"+"</html>");
             btnSoHoaDon.setHorizontalAlignment(btnSoHoaDon.CENTER);
         
        }
          }
          public void doanhThuMonth(){
        String month = cboThang.getSelectedItem().toString();
       
         String year = cboNam.getSelectedItem().toString();
              ThongKeDoanhThu tkdt = new ThongKeDoanhThu(0, month, year);
       List<ThongKeDoanhThu> ds = thongKeService.ThongKeDTMonth(tkdt);
        DecimalFormat df = new DecimalFormat("#,##0");
        
         int doanhThuMonth = ds.stream().mapToInt(ThongKeDoanhThu::getTongTien).sum();
         String doanhThuMonthdf = df.format(doanhThuMonth);
         btnTongDT.setText("<html>Doanh Thu:"+"<br>"+doanhThuMonthdf +" VNĐ"+"</html>");
   
          
    }
          public void khachHangYear(){
       
       
         String year = cboNamTK.getSelectedItem().toString();
         ThongKeKhachHang tkkh = new ThongKeKhachHang("", "", year);
       List<ThongKeKhachHang> ds = thongKeService.ThongKeKhYear(tkkh);
         for (ThongKeKhachHang tk : ds) {
               btnSoKhachHang.setText("<html>Khách Hàng: "+"<div style='text-align:center'>"+tk.getTongKH()+"</div>"+"</html>");
             btnSoKhachHang.setHorizontalAlignment(btnSoKhachHang.CENTER);
         
        }}
    
          public void hoaDonYear(){
      
       
         String year = cboNamTK.getSelectedItem().toString();
         ThongKeHoaDon tkhd = new ThongKeHoaDon("", "", year);
       List<ThongKeHoaDon> ds = thongKeService.ThongKeHDYear(tkhd);
         for (ThongKeHoaDon tk : ds) {
               btnSoHoaDon.setText("<html>Hóa Đơn: "+"<div style='text-align:center'>"+tk.getTongHD()+"</div>"+"</html>");
             btnSoHoaDon.setHorizontalAlignment(btnSoHoaDon.CENTER);
         
        }
          }
          public void doanhThuYear(){

       
         String year = cboNamTK.getSelectedItem().toString();
              ThongKeDoanhThu tkdt = new ThongKeDoanhThu(0, "", year);
       List<ThongKeDoanhThu> ds = thongKeService.ThongKeDTYear(tkdt);
        DecimalFormat df = new DecimalFormat("#,##0");
        
         int doanhThuMonth = ds.stream().mapToInt(ThongKeDoanhThu::getTongTien).sum();
         String doanhThuMonthdf = df.format(doanhThuMonth);
         btnTongDT.setText("<html>Doanh Thu:"+"<br>"+doanhThuMonthdf +" VNĐ"+"</html>");
   
          
    }
     public void khachHangAll(){
       List<ThongKeKhachHang> ds = thongKeService.ThongKeKHAll();
         for (ThongKeKhachHang tkkh : ds) {
             btnSoKhachHang.setText("<html>Khách Hàng: "+"<div style='text-align:center'>"+tkkh.getTongKH()+"</div>"+"</html>");
             btnSoKhachHang.setHorizontalAlignment(btnSoKhachHang.CENTER);
         }
    }
      public void HoaDonAll(){
       List<ThongKeHoaDon > ds = thongKeService.ThongKeHDAll();
         for (ThongKeHoaDon tkhd : ds) {
             btnSoHoaDon.setText("<html>Hóa Đơn: "+"<div style='text-align:center'>"+tkhd.getTongHD()+"</div>"+"</html>");
               btnSoHoaDon.setHorizontalAlignment(btnSoHoaDon.CENTER);
         }
    }
   
    public void doanhThuAll(){
         DecimalFormat df = new DecimalFormat("#,##0");
         List<ThongKeTable> ds = thongKeService.ThongKeAll();
         int doanhThuAll = ds.stream().mapToInt(ThongKeTable::getTongTien).sum();
         String doanhThuAlldf = df.format(doanhThuAll);
         btnTongDT.setText("<html>Doanh Thu:"+"<br>"+doanhThuAlldf +" VNĐ"+"</html>");
        btnTongDT.setHorizontalAlignment(btnTongDT.CENTER);
    }
 public void loadTableTKAll() {
        DefaultTableModel dtm = (DefaultTableModel) tblThongKeHH.getModel();
 DecimalFormat df = new DecimalFormat("#,##0");
        dtm.setRowCount(0);
        List<ThongKeTable> ds = thongKeService.ThongKeAll();
        for (ThongKeTable tk : ds) {
            Object[] rowData = new Object[]{
              tk.getId(),
                tk.getTen(),
               df.format(tk.getDonGia())  +" VNĐ",
                tk.getSoLuong(),
                df.format(tk.getTongTien()) +" VNĐ"

            };
            dtm.addRow(rowData);

        }
    }
 public void loadTableTKFindHangHetHan() {
        DefaultTableModel dtm = (DefaultTableModel) tblThongKeHHH.getModel();
 DecimalFormat df = new DecimalFormat("#,##0");
         String ten= txtFind.getText();
         ThongKeHangHetHan tkhhh= new ThongKeHangHetHan("", ten, 0, 0, "", "", 0);
        dtm.setRowCount(0);
        List<ThongKeHangHetHan> ds = thongKeService.ThongKeFindHangHetHan(tkhhh);
        for (ThongKeHangHetHan tk : ds) {
            Object[] rowData = new Object[]{
              tk.getId(),
                tk.getTen(),
               df.format(tk.getDonGia())  +" VNĐ",
                tk.getSoLuong(),
               tk.getNgaySanXuat(),
               tk.getHSD(),
               tk.getTrangThai()==0?"Hết hạn":"Chưa hết hạn"

            };
            dtm.addRow(rowData);

        }
    }
 public void loadTableTKHangHetHan() {
        DefaultTableModel dtm = (DefaultTableModel) tblThongKeHHH.getModel();
 DecimalFormat df = new DecimalFormat("#,##0");
        dtm.setRowCount(0);
        List<ThongKeHangHetHan> ds = thongKeService.ThongKeHangHetHan();
        for (ThongKeHangHetHan tk : ds) {
            Object[] rowData = new Object[]{
              tk.getId(),
                tk.getTen(),
               df.format(tk.getDonGia())  +" VNĐ",
                tk.getSoLuong(),
               tk.getNgaySanXuat(),
               tk.getHSD(),
               tk.getTrangThai()==0?"Hết hạn":"Chưa hết hạn"

            };
            dtm.addRow(rowData);

        }
    }
 public void loadTableTKAllMonth() {
        DefaultTableModel dtm = (DefaultTableModel) tblThongKeHH.getModel();
 DecimalFormat df = new DecimalFormat("#,##0");
 String month = cboThangTbl.getSelectedItem().toString();
 String year = cboNamTbl.getSelectedItem().toString();
 ThongKeTable tkt = new ThongKeTable("", "", 0, 0, 0, month, year);
        dtm.setRowCount(0);
        List<ThongKeTable> ds = thongKeService.ThongKeAllMonth(tkt);
        for (ThongKeTable tk : ds) {
            Object[] rowData = new Object[]{
              tk.getId(),
                tk.getTen(),
               df.format(tk.getDonGia())  +" VNĐ",
                tk.getSoLuong(),
                df.format(tk.getTongTien()) +" VNĐ"

            };
            dtm.addRow(rowData);

        }
    }
 public void loadTableTKAllYear() {
        DefaultTableModel dtm = (DefaultTableModel) tblThongKeHH.getModel();
 DecimalFormat df = new DecimalFormat("#,##0");
        dtm.setRowCount(0);
      
 String year = cboNamTKTbl.getSelectedItem().toString();
 ThongKeTable tkt = new ThongKeTable("", "", 0, 0, 0, "", year);
        List<ThongKeTable> ds = thongKeService.ThongKeAllYear(tkt);
        for (ThongKeTable tk : ds) {
            Object[] rowData = new Object[]{
              tk.getId(),
                tk.getTen(),
               df.format(tk.getDonGia())  +" VNĐ",
                tk.getSoLuong(),
                df.format(tk.getTongTien()) +" VNĐ"

            };
            dtm.addRow(rowData);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongKeHH = new javax.swing.JTable();
        bntAllTb = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cboThangTbl = new javax.swing.JComboBox<>();
        cboNamTbl = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cboNamTKTbl = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThongKeHHH = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnHHAll = new javax.swing.JButton();
        btnSoKhachHang = new javax.swing.JButton();
        btnTongDT = new javax.swing.JButton();
        btnSoHoaDon = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cboThang = new javax.swing.JComboBox<>();
        cboNam = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cboNamTK = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnALL = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblThongKeHH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Hộp Thịt", "Tên Thịt", "Đơn Giá", "Số Lượng", "Tổng Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblThongKeHH);

        bntAllTb.setText("Tất cả");
        bntAllTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAllTbActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tháng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cboThangTbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboThangTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangTblActionPerformed(evt);
            }
        });

        cboNamTbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023" }));
        cboNamTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamTblActionPerformed(evt);
            }
        });

        jLabel7.setText("Tháng");

        jLabel8.setText("Năm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboThangTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboNamTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboThangTbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cboNamTbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Năm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cboNamTKTbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023" }));
        cboNamTKTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamTKTblActionPerformed(evt);
            }
        });

        jLabel6.setText("Năm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cboNamTKTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNamTKTbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(bntAllTb)
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bntAllTb)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("HÀNG HÓA", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tblThongKeHHH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Hộp Thịt", "Tên Thịt", "Đơn Giá", "Số Lượng Tồn", "Ngày Sản Xuất", "Hạn sử dụng", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblThongKeHHH);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });

        btnFind.setText("Tìm Kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFind.getAccessibleContext().setAccessibleName("");
        txtFind.getAccessibleContext().setAccessibleDescription("Tìm Kiếm"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tìm Kiếm");

        btnHHAll.setText("Tất cả");
        btnHHAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHHAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnHHAll, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnHHAll, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("HÀNG HẾT HẠN", jPanel7);

        btnSoKhachHang.setBackground(new java.awt.Color(102, 255, 255));
        btnSoKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnTongDT.setBackground(new java.awt.Color(102, 255, 255));
        btnTongDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTongDT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSoHoaDon.setBackground(new java.awt.Color(102, 255, 255));
        btnSoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tháng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangActionPerformed(evt);
            }
        });

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023" }));
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        jLabel1.setText("Tháng");

        jLabel2.setText("Năm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Năm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cboNamTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023" }));
        cboNamTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamTKActionPerformed(evt);
            }
        });

        jLabel4.setText("Năm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNamTK, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboNamTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnALL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnALL.setText("Tất cả");
        btnALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnALL, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTongDT, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(btnSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSoKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTongDT, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnALL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
      khachHangMonth();
      hoaDonMonth();
      doanhThuMonth();
    }//GEN-LAST:event_cboThangActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
       khachHangMonth();
         hoaDonMonth();
               doanhThuMonth();

    }//GEN-LAST:event_cboNamActionPerformed

    private void cboNamTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamTKActionPerformed
    khachHangYear();
    doanhThuYear();
    hoaDonYear();
    }//GEN-LAST:event_cboNamTKActionPerformed

    private void btnALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALLActionPerformed
        doanhThuAll();
        khachHangAll();
        HoaDonAll();
    }//GEN-LAST:event_btnALLActionPerformed

    private void cboThangTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangTblActionPerformed
loadTableTKAllMonth();
    }//GEN-LAST:event_cboThangTblActionPerformed

    private void cboNamTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamTblActionPerformed
        loadTableTKAllMonth();
    }//GEN-LAST:event_cboNamTblActionPerformed

    private void cboNamTKTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamTKTblActionPerformed
      loadTableTKAllYear();
    }//GEN-LAST:event_cboNamTKTblActionPerformed

    private void bntAllTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAllTbActionPerformed
    loadTableTKAll();
    }//GEN-LAST:event_bntAllTbActionPerformed

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        
    }//GEN-LAST:event_txtFindActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
          loadTableTKFindHangHetHan();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnHHAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHHAllActionPerformed
       loadTableTKHangHetHan();
    }//GEN-LAST:event_btnHHAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAllTb;
    private javax.swing.JButton btnALL;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnHHAll;
    private javax.swing.JButton btnSoHoaDon;
    private javax.swing.JButton btnSoKhachHang;
    private javax.swing.JButton btnTongDT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboNamTK;
    private javax.swing.JComboBox<String> cboNamTKTbl;
    private javax.swing.JComboBox<String> cboNamTbl;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JComboBox<String> cboThangTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblThongKeHH;
    private javax.swing.JTable tblThongKeHHH;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

}
