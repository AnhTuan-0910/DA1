/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication24.view;

import ViewModel.QLNhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import javaapplication24.viewmodel.GioHangViewModel;
import javaapplication24.viewmodel.HoaDonViewModel;
import javax.swing.table.DefaultTableModel;
import com.github.sarxos.webcam.*;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication24.model.HoaDon;
import javaapplication24.model.HoaDonChiTiet;
import javaapplication24.model.KhachHang;
import javaapplication24.model.Voucher;
import javaapplication24.model.VoucherChiTiet;
import javaapplication24.service.HopThitSer;
import javaapplication24.service.VoucherChiTietService;
import javaapplication24.service.VoucherService;
import javaapplication24.service.impl.HoaDonChiTietService;
import javaapplication24.service.impl.HoaDonSerVice;
import javaapplication24.service.impl.VoucherChiTietServiceImpl;
import javaapplication24.service.impl.VoucherServiceImpl;
import javaapplication24.viewmodel.HopThitViewModel;
import javaapplication24.viewmodel.VoucherViewModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BanHangView extends javax.swing.JPanel implements Runnable, ThreadFactory {

    HoaDonSerVice hds = new HoaDonSerVice();
    HoaDonChiTietService hdcts = new HoaDonChiTietService();
    HopThitSer hts = new HopThitSer();
    VoucherChiTietService vcts = new VoucherChiTietServiceImpl();
    VoucherService vs = new VoucherServiceImpl();
    List<Voucher> list = new ArrayList<>();
    List<VoucherViewModel> listv = new ArrayList<>();
    List<HoaDonViewModel> listhdv = new ArrayList();
    List<GioHangViewModel> listghv;
    List<KhachHang> listkh = new ArrayList<>();
    List<HopThitViewModel> listht = new ArrayList<>();
    DefaultTableModel dtmgh = new DefaultTableModel();
    DefaultTableModel dtmhd = new DefaultTableModel();
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    ChonKhachHangView ckhv;
    int count;
    ChonVoucher cv;
    HoaDonViewModel hdvmg;
    QLNhanVien nv;

    public BanHangView(QLNhanVien nv) {
        initComponents();
        initWebcam();
        this.nv = nv;
        list = vs.getList(LocalDate.now());
        listht = hts.readAll();
        listv = vcts.getListView();
        dtmgh = (DefaultTableModel) this.tblGioHang.getModel();
        dtmhd = (DefaultTableModel) this.tblHoaDonView.getModel();
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        jpnCam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 452, 199));
        executor.execute(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonView = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSanPham = new javax.swing.JButton();
        btnXoaTatCa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtKhachHang = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        btnChon = new javax.swing.JButton();
        btnThayDoi = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jblTongTien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jblThanhToan = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jblTienThua = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtaGhiChu = new javax.swing.JTextArea();
        btnThanhToan = new javax.swing.JButton();
        txtVoucher = new javax.swing.JTextField();
        btnChonVoucher = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboHinhThucVanChuyen = new javax.swing.JComboBox<>();
        btnThayDoiTT = new javax.swing.JButton();
        jpnCam = new javax.swing.JPanel();
        btnTat = new javax.swing.JButton();
        btnbatCam = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        btnTao = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Hoá đơn chờ ");

        tblHoaDonView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IdNhanVien", "Ten NhanVien", "sdtKhachHang", "TenKhachHang", "NgayTao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHoaDonView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonView);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Giỏ hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "TenSanPham", "ĐonGia", "SoLuong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaSanPham.setText("Xoá sản phẩm");
        btnXoaSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaSanPhamMouseClicked(evt);
            }
        });

        btnXoaTatCa.setText("Xoá tất cả");
        btnXoaTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaTatCaMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Đơn hàng");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Tên khách hàng");

        jLabel8.setText("Sdt");

        btnChon.setText("Chọn");
        btnChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonMouseClicked(evt);
            }
        });

        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThayDoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKhachHang)
                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChon)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThayDoi)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThayDoi))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel11.setText("Tổng tiền");

        jblTongTien.setText("0");

        jLabel13.setText("VND");

        jLabel14.setText("Voucher");

        jLabel15.setText("Thanh Toán");

        jLabel17.setText("VND");

        jblThanhToan.setText("0");

        jLabel19.setText("Tiền khách đưa");

        jLabel20.setText("VND");

        jLabel21.setText("Tiền thừa trả khách");

        jblTienThua.setText("0");

        jLabel23.setText("VND");

        jLabel24.setText("Ghi chú");

        jtaGhiChu.setColumns(20);
        jtaGhiChu.setRows(5);
        jScrollPane4.setViewportView(jtaGhiChu);

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        txtVoucher.setEnabled(false);

        btnChonVoucher.setText("Chọn");
        btnChonVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonVoucherMouseClicked(evt);
            }
        });

        jLabel3.setText("Hình thức vận chuyển");

        cboHinhThucVanChuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trực tiếp", "ship" }));

        btnThayDoiTT.setText("Thay doi");
        btnThayDoiTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThayDoiTTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnChonVoucher))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jblThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cboHinhThucVanChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel19)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel21)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel20)))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnThayDoiTT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonVoucher))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jblThanhToan)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jblTienThua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboHinhThucVanChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThayDoiTT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jpnCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTat.setText("Tắt cam");
        btnTat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTatMouseClicked(evt);
            }
        });

        btnbatCam.setText("Bật cam");
        btnbatCam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbatCamMouseClicked(evt);
            }
        });

        btnHuyHoaDon.setText("Huỷ hoá đơn");
        btnHuyHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyHoaDonMouseClicked(evt);
            }
        });

        btnTao.setText("Tạo hoá đơn");
        btnTao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoaTatCa)
                            .addComponent(btnXoaSanPham)))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jpnCam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTat)
                                    .addComponent(btnbatCam)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTao)
                                    .addComponent(btnHuyHoaDon))))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpnCam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTao)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHuyHoaDon))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnXoaSanPham)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnXoaTatCa))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnbatCam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTat)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonMouseClicked
        // TODO add your handling code here:
        ckhv = new ChonKhachHangView();
        ckhv.setVisible(true);
    }//GEN-LAST:event_btnChonMouseClicked

    private void btnThayDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThayDoiMouseClicked
        // TODO add your handling code here:
        if (ckhv != null && ckhv.getKh() != null) {
            txtSdt.setText(ckhv.getKh().getSdt());
            txtKhachHang.setText(ckhv.getKh().getTenKH());
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng");
        }
    }//GEN-LAST:event_btnThayDoiMouseClicked

    private void btnTaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoMouseClicked
        // TODO add your handling code here:
        List<GioHangViewModel> list = new ArrayList<>();
        HoaDonViewModel hdv = new HoaDonViewModel(nv.getIdNhanVien(), nv.getHoTen(), ckhv.getKh().getSdt(), ckhv.getKh().getTenKH(), LocalDate.now().toString(), list);
        listhdv.add(hdv);
        showDataTablehd(listhdv);

    }//GEN-LAST:event_btnTaoMouseClicked

    private void btnTatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTatMouseClicked
        // TODO add your handling code here:
        closeWebcam();
    }//GEN-LAST:event_btnTatMouseClicked

    private void btnbatCamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatCamMouseClicked
        // TODO add your handling code here:
        initWebcam();
    }//GEN-LAST:event_btnbatCamMouseClicked

    private void btnHuyHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDonView.getSelectedRow();
        if (row >= 0 && row < listhdv.size()) {
            listhdv.remove(row);
            showDataTablehd(listhdv);
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn hoá đơn cần xoá");
        }
    }//GEN-LAST:event_btnHuyHoaDonMouseClicked

    private void tblHoaDonViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonViewMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDonView.getSelectedRow();
        if (row >= 0 && row < listhdv.size()) {
            HoaDonViewModel hdv = listhdv.get(row);
            showDataTablegh(hdv.getList());
            listghv = hdv.getList();
            hdvmg = hdv;
            int t = tinhTong(listghv);
            jblTongTien.setText(String.valueOf(t));
            if (hdv.getVvm() == null) {
                txtVoucher.setText("");
                jblThanhToan.setText(String.valueOf(t));
            } else {
                txtVoucher.setText(hdv.getVvm().getIdVoucherChiTiet());
                jblThanhToan.setText(String.valueOf(thanhToan(t, hdv.getVvm())));
            }

        }
    }//GEN-LAST:event_tblHoaDonViewMouseClicked

    private void btnXoaSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSanPhamMouseClicked
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        if (row >= 0 && row < listghv.size()) {
            listghv.remove(row);
            int t = tinhTong(listghv);
            jblTongTien.setText(String.valueOf(t));
            if (hdvmg.getVvm() == null) {
                txtVoucher.setText("");
                jblThanhToan.setText(String.valueOf(t));
            } else {
                txtVoucher.setText(hdvmg.getVvm().getIdVoucherChiTiet());
                jblThanhToan.setText(String.valueOf(thanhToan(t, hdvmg.getVvm())));
            }
            showDataTablegh(listghv);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xoá");
        }
    }//GEN-LAST:event_btnXoaSanPhamMouseClicked

    private void btnXoaTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTatCaMouseClicked
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnXoaTatCaMouseClicked

    private void btnChonVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonVoucherMouseClicked
        // TODO add your handling code here:
        cv = new ChonVoucher(hdvmg.getSdtKhachHang(), tinhTong(listghv));
        cv.setVisible(true);
    }//GEN-LAST:event_btnChonVoucherMouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
        if (txtTienKhachDua.getText().trim().isEmpty() || !txtTienKhachDua.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Nhap tien khach dua");
        } else {
            if (Integer.parseInt(txtTienKhachDua.getText()) >= Integer.parseInt(jblThanhToan.getText())) {
                jblTienThua.setText(String.valueOf(Integer.parseInt(txtTienKhachDua.getText()) - Integer.parseInt(jblThanhToan.getText())));
                String idHoaDon = taoMaHD();
                String idvct = "";
                if (hdvmg.getVvm() != null && vcts.updateTrangThai(hdvmg.getVvm().getIdVoucherChiTiet())) {
                    idvct = hdvmg.getVvm().getIdVoucherChiTiet();
                }
                HoaDon hd = new HoaDon(idHoaDon, hdvmg.getSdtKhachHang(), idvct, hdvmg.getIdNhanVien(), hdvmg.getNgayTao(), cboHinhThucVanChuyen.getSelectedIndex(), Integer.parseInt(jblThanhToan.getText()), jtaGhiChu.getText());
                System.out.println(hd.toString());
                if (hds.add(hd) && addHoaDonChiTiet(idHoaDon, hdvmg.getList())) {
                    JOptionPane.showMessageDialog(this, "thanh toan thanh cong");
                    addVoucher(Integer.parseInt(jblTongTien.getText()), hdvmg.getSdtKhachHang(), idHoaDon);
                    listhdv.remove(hdvmg);
                    showDataTablehd(listhdv);
                    clearForm();
                }
            } else {
                JOptionPane.showMessageDialog(this, "thieu tien");
            }
        }
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnThayDoiTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThayDoiTTMouseClicked
        // TODO add your handling code here:
        VoucherViewModel vvm = cv.getVvm();
        hdvmg.setVvm(vvm);
        if (vvm == null) {
            txtVoucher.setText("");
        } else {
            txtVoucher.setText(vvm.getIdVoucherChiTiet());
        }

    }//GEN-LAST:event_btnThayDoiTTMouseClicked
    public void closeWebcam() {
        webcam.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnChonVoucher;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnTat;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JButton btnThayDoiTT;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.JButton btnbatCam;
    private javax.swing.JComboBox<String> cboHinhThucVanChuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jblThanhToan;
    private javax.swing.JLabel jblTienThua;
    private javax.swing.JLabel jblTongTien;
    private javax.swing.JPanel jpnCam;
    private javax.swing.JTextArea jtaGhiChu;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDonView;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtVoucher;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                String idHopThit = result.getText();
                int count = 0;
                NOTE:
                for (HopThitViewModel ht : listht) {
                    if (ht.getMa().equalsIgnoreCase(idHopThit)) {
                        LocalDate NSX = LocalDate.parse(ht.getNgaySanXuat(),DateTimeFormatter.ISO_LOCAL_DATE);
                        if (NSX.plusDays(ht.getHSD()).isBefore(LocalDate.now())) {
                            count++;
                            JOptionPane.showMessageDialog(this, "Thịt đã hết hạn");
                        } else {
                            count++;
                            int gia = ht.getTongGia();
                            int soluong = 0;
                            while (soluong == 0) {
                                String sl = JOptionPane.showInputDialog("Nhap so luong");
                                if (sl == null) {
                                    if (JOptionPane.showConfirmDialog(this, "Bạn muốn bỏ sản phẩm này", "Warning", 2) == 0) {
                                        break NOTE;
                                    }
                                } else if (!sl.matches("\\d+")) {
                                    JOptionPane.showMessageDialog(this, "Nhập sai dữ liệu");
                                } else {
                                    soluong = Integer.parseInt(sl);
                                }
                            }
                            GioHangViewModel ghv = new GioHangViewModel(idHopThit, gia, soluong);
                            listghv.add(ghv);
                            int t = tinhTong(listghv);
                            jblTongTien.setText(String.valueOf(t));
                            if (hdvmg.getVvm() == null) {
                                jblThanhToan.setText(String.valueOf(t));
                            } else {
                                jblThanhToan.setText(String.valueOf(thanhToan(t, hdvmg.getVvm())));
                            }
                            showDataTablegh(listghv);
                        }
                    }
                }
                if (count == 0) {
                    JOptionPane.showMessageDialog(this, "ko tim thay du lieu");
                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private void showDataTablehd(List<HoaDonViewModel> listhdv) {
        dtmhd.setRowCount(0);
        for (HoaDonViewModel hd : listhdv) {
            dtmhd.addRow(new Object[]{hd.getIdNhanVien(), hd.getTenNhanVien(), hd.getSdtKhachHang(), hd.getTenKhachHang(), hd.getNgayTao()});
        }
    }

    private void showDataTablegh(List<GioHangViewModel> list) {
        dtmgh.setRowCount(0);
        for (GioHangViewModel gh : list) {
            dtmgh.addRow(new Object[]{gh.getIdHopThit(), gh.getDonGia(), gh.getSoLuong()});
        }
    }

    private int tinhTong(List<GioHangViewModel> listghv) {
        int sum = 0;
        for (GioHangViewModel gh : listghv) {
            sum += gh.getDonGia() * gh.getSoLuong();
        }
        return sum;
    }

    private int thanhToan(int tongTien, VoucherViewModel vvm) {
        if (vvm.getLoai() == 0) {//theo %
            int soTienTru = tongTien * vvm.getGiatri();
            if (soTienTru > vvm.getMucGiaGioiHan()) {
                return tongTien - vvm.getMucGiaGioiHan();
            } else {
                return tongTien - soTienTru;
            }
        } else {//theo $
            return vvm.getGiatri() >= tongTien ? 0 : tongTien - vvm.getGiatri();
        }
    }

    private String taoMaHD() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    private boolean addHoaDonChiTiet(String idHoaDon, List<GioHangViewModel> list) {
        for (GioHangViewModel ghvm : list) {
            HoaDonChiTiet hdct = new HoaDonChiTiet(idHoaDon, ghvm.getIdHopThit(), ghvm.getSoLuong(), ghvm.getDonGia());
            if (!hdcts.add(hdct)) {
                JOptionPane.showMessageDialog(this, "add hdct that bai");
                return false;
            }
        }
        return true;
    }

    private void addVoucher(int tongTien, String idKhachhang, String idHoaDon) {
        Voucher vou = null;
        for (Voucher v : list) {
            if (v.getDkNhan() <= tongTien) {
                vou = v;
                break;
            }
        }
        if (vou != null) {
            VoucherChiTiet vct = new VoucherChiTiet(vou.getId(), idKhachhang, LocalDate.now().plusDays(vou.getHsd()).toString(), idHoaDon, (byte) 1);
            if (vcts.add(vct)) {
                JOptionPane.showMessageDialog(this, "add thanh cong voucher");
            } else {
                JOptionPane.showMessageDialog(this, "add that bai voucher");
            }
        }
    }

    private void clearForm() {
        dtmgh.setRowCount(0);
        jblTongTien.setText("0");
        txtVoucher.setText("");
        jblThanhToan.setText("0");
        txtTienKhachDua.setText("");
        jblTienThua.setText("0");
        jtaGhiChu.setText("");
    }
}
