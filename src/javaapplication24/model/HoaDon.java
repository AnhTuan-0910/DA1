/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Administrator
 */
public class HoaDon {

    private String idHoaDon;
    private String idKH;
    private String idVC;
    private String idNV;
    private String ngayTao;
    private int hinhThucGiaoHang;
    private int thanhToan;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, String idKH, String idVC, String idNV, String ngayTao, int hinhThucGiaoHang, int thanhToan, String ghiChu) {
        this.idHoaDon = idHoaDon;
        this.idKH = idKH;
        this.idVC = idVC;
        this.idNV = idNV;
        this.ngayTao = ngayTao;
        this.hinhThucGiaoHang = hinhThucGiaoHang;
        this.thanhToan = thanhToan;
        this.ghiChu = ghiChu;
    }

    
    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdVC() {
        return idVC;
    }

    public void setIdVC(String idVC) {
        this.idVC = idVC;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public int getHinhThucGiaoHang() {
        return hinhThucGiaoHang;
    }

    public void setHinhThucGiaoHang(int hinhThucGiaoHang) {
        this.hinhThucGiaoHang = hinhThucGiaoHang;
    }

    public int getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(int thanhToan) {
        this.thanhToan = thanhToan;
    }

    @Override
    public String toString() {
        return idHoaDon
     +"\n"+idKH
    +"\n"+idVC
     +"\n"+idNV
     +"\n"+ngayTao
     +"\n"+hinhThucGiaoHang
     +"\n"+thanhToan
     +"\n"+ghiChu;
    }

    
    
}
