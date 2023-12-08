/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package javaapplication24.view;

import java.util.ArrayList;
import java.util.List;
import javaapplication24.model.HoaDon;
import javaapplication24.service.impl.HoaDonChiTietService;
import javaapplication24.service.impl.HoaDonSerVice;
import javaapplication24.viewmodel.HoaDonCtViewModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDonView extends javax.swing.JPanel {

    HoaDonSerVice hds = new HoaDonSerVice();
    HoaDonChiTietService hdcts = new HoaDonChiTietService();
    List<HoaDonCtViewModel> listhdct = new ArrayList<>();
    List<HoaDon> listhd = new ArrayList<>();
    DefaultTableModel dtmhd = new DefaultTableModel();
    DefaultTableModel dtmhdct = new DefaultTableModel();
    public HoaDonView() {
        initComponents();
        listhd = hds.getList();
        listhdct = hdcts.getList();
        dtmhd = (DefaultTableModel) this.tblHoaDon.getModel();
        dtmhdct = (DefaultTableModel) this.tblHoaDonChiTiet.getModel();
        showDataTable(listhd);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idHoaDon", "sdtKhachHang", "idVoucher", "idNhanVien", "HinhThucGiaoHang", "GhiChu", "NgayTao", "thanhToan"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên Hộp thịt", "Soluong", "DonGia"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        jLabel1.setText("Hoá đơn");

        jLabel2.setText("Hoá đơn chi tiết");

        jLabel3.setText("Nhập idHoaDon cần tìm");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnTimKiem))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1)
                        .addGap(241, 241, 241)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        if(txtTimKiem.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this,"Nhap du lieu can tim");
        }else {
            List<HoaDon> listsearch = new ArrayList<>();
            for(HoaDon hd:listhd){
                if(hd.getIdHoaDon().equalsIgnoreCase(txtTimKiem.getText())){
                    listsearch.add(hd);
                }
            }
            showDataTable(listsearch);
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if(row>=0&&row<listhd.size()){
            HoaDon hd = listhd.get(row);
            showDataTableHdct(getHdcvt(hd.getIdHoaDon()));
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void showDataTable(List<HoaDon> listhd) {
        dtmhd.setRowCount(0);
        for(HoaDon hd:listhd){
            dtmhd.addRow(new Object[]{hd.getIdHoaDon(),hd.getIdKH(),hd.getIdVC(),hd.getIdNV(),hd.getHinhThucGiaoHang(),hd.getGhiChu(),hd.getNgayTao(),hd.getThanhToan()});
        }
    }

    private void showDataTableHdct(List<HoaDonCtViewModel> listhdct) {
        dtmhdct.setRowCount(0);
        for(HoaDonCtViewModel hdct:listhdct){
            dtmhdct.addRow(new Object[]{hdct.getTenLoaiThit(),hdct.getSoLuong(),hdct.getDonGia()});
        }
    }

    private List<HoaDonCtViewModel> getHdcvt(String idHoaDon) {
        List<HoaDonCtViewModel> list = new ArrayList<>();
        for(HoaDonCtViewModel hdct :listhdct){
            if(hdct.getIdHoaDon().equals(idHoaDon)){
                list.add(hdct);
            }
        }
        return list;
    }

}
