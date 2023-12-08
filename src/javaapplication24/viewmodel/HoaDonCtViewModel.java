/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.viewmodel;

/**
 *
 * @author Admin
 */
public class HoaDonCtViewModel {
    private String idHoaDon;
    private String tenLoaiThit;
    private int soLuong;
    private int donGia;

    public HoaDonCtViewModel() {
    }

    public HoaDonCtViewModel(String idHoaDon, String tenLoaiThit, int soLuong, int donGia) {
        this.idHoaDon = idHoaDon;
        this.tenLoaiThit = tenLoaiThit;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getTenLoaiThit() {
        return tenLoaiThit;
    }

    public void setTenLoaiThit(String tenLoaiThit) {
        this.tenLoaiThit = tenLoaiThit;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
}
