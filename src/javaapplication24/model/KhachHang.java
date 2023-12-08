/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author fptsh
 */
public class KhachHang {
    
    private String sdt;
    private String tenKH;
    private int gioiTinh;
    public KhachHang() {
    }

    public KhachHang(String tenKH, int gioiTinh,String sdt) {
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
    }
 
    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh(int gioiTinh) {
        if (gioiTinh == 0) {
            return "Nam";
        } else {
            return "Nu";
        }
    }
}
