/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {
    private String idHoaDonChiTiet;
    private String idHoaDon;
    private String idHopThit;
    private int soLuong;
    private int donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDonChiTiet, String idHoaDon, String idHopThit, int soLuong, int donGia) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
        this.idHoaDon = idHoaDon;
        this.idHopThit = idHopThit;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public HoaDonChiTiet( String idHoaDon, String idHopThit, int soLuong, int donGia) {
        this.idHoaDon = idHoaDon;
        this.idHopThit = idHopThit;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    
    public String getIdHoaDonChiTiet() {
        return idHoaDonChiTiet;
    }

    public void setIdHoaDonChiTiet(String idHoaDonChiTiet) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdHopThit() {
        return idHopThit;
    }

    public void setIdHopThit(String idHopThit) {
        this.idHopThit = idHopThit;
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
