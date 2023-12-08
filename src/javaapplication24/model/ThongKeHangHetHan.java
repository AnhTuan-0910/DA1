/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Administrator
 */
public class ThongKeHangHetHan {
     private String id;
    private String ten;
    private int donGia;
    private int soLuong;
       private String NgaySanXuat;
         private String HSD;
           private int TrangThai;

    public ThongKeHangHetHan() {
    }

    public ThongKeHangHetHan(String id, String ten, int donGia, int soLuong, String NgaySanXuat, String HSD, int TrangThai) {
        this.id = id;
        this.ten = ten;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.NgaySanXuat = NgaySanXuat;
        this.HSD = HSD;
        this.TrangThai = TrangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(String NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

           
}
