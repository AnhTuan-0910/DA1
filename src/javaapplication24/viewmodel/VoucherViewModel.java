/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.viewmodel;

/**
 *
 * @author Admin
 */
public class VoucherViewModel {
    private String idVoucherChiTiet;
    private byte loai;
    private int giatri;
    private String ngayKetThuc;
    private int mucGiaGioiHan;

    public VoucherViewModel() {
    }

    public VoucherViewModel(String idVoucherChiTiet, byte loai, int giatri, String ngayKetThuc, int mucGiaGioiHan) {
        this.idVoucherChiTiet = idVoucherChiTiet;
        this.loai = loai;
        this.giatri = giatri;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiaGioiHan = mucGiaGioiHan;
    }
    
    public VoucherViewModel(byte loai, int giatri, String ngayKetThuc, int mucGiaGioiHan) {
        this.loai = loai;
        this.giatri = giatri;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiaGioiHan = mucGiaGioiHan;
    }

    public String getIdVoucherChiTiet() {
        return idVoucherChiTiet;
    }

    public void setIdVoucherChiTiet(String idVoucherChiTiet) {
        this.idVoucherChiTiet = idVoucherChiTiet;
    }
    
    public byte getLoai() {
        return loai;
    }

    public void setLoai(byte loai) {
        this.loai = loai;
    }

    public int getGiatri() {
        return giatri;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getMucGiaGioiHan() {
        return mucGiaGioiHan;
    }

    public void setMucGiaGioiHan(int mucGiaGioiHan) {
        this.mucGiaGioiHan = mucGiaGioiHan;
    }
    
}
