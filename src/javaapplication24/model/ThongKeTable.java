/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Administrator
 */
public class ThongKeTable {
    private String id;
    private String ten;
    private int donGia;
    private int soLuong;
       private int TongTien;
         private String thang;
           private String nam;

    public ThongKeTable() {
    }

    public ThongKeTable(String id, String ten, int donGia, int soLuong, int TongTien, String thang, String nam) {
        this.id = id;
        this.ten = ten;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.TongTien = TongTien;
        this.thang = thang;
        this.nam = nam;
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

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

   
       
    
}
