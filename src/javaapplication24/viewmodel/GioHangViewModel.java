/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.viewmodel;

/**
 *
 * @author Admin
 */
public class GioHangViewModel {
    private String idHopThit;
    private int donGia;
    private int soLuong;

    public GioHangViewModel() {
    }

    public GioHangViewModel(String idHopThit, int donGia, int soLuong) {
        this.idHopThit = idHopThit;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getIdHopThit() {
        return idHopThit;
    }

    public void setIdHopThit(String idHopThit) {
        this.idHopThit = idHopThit;
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
    
}
