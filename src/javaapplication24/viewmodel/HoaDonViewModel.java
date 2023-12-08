/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.viewmodel;

import java.util.List;
import javaapplication24.model.Voucher;

/**
 *
 * @author Admin
 */
public class HoaDonViewModel {
    private String idNhanVien;
    private String tenNhanVien;
    private String sdtKhachHang;
    private String tenKhachHang;
    private VoucherViewModel vvm;
    private String ngayTao;
    private List<GioHangViewModel> list;
    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String idNhanVien, String tenNhanVien, String sdtKhachHang, String tenKhachHang, String ngayTao, List<GioHangViewModel> list) {
        this.idNhanVien = idNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.sdtKhachHang = sdtKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.list = list;
    }

    public HoaDonViewModel(String idNhanVien, String tenNhanVien, String sdtKhachHang, String tenKhachHang, VoucherViewModel vvm, int thanhToan, String ngayTao, List<GioHangViewModel> list) {
        this.idNhanVien = idNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.sdtKhachHang = sdtKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.vvm = vvm;
        this.ngayTao = ngayTao;
        this.list = list;
    }

    public VoucherViewModel getVvm() {
        return vvm;
    }

    public void setVvm(VoucherViewModel vvm) {
        this.vvm = vvm;
    }
    
    public List<GioHangViewModel> getList() {
        return list;
    }

    public void setList(List<GioHangViewModel> list) {
        this.list = list;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getSdtKhachHang() {
        return sdtKhachHang;
    }

    public void setSdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    
    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    
}
