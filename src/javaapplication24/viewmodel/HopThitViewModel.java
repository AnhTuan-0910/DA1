/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.viewmodel;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HopThitViewModel {
    private int Stt;
    private String Ma;
    private String LoaiThit;
    private String TenLoaiThit;
    private int TrongLuong;
    private int SoLuong;
    private String NgaySanXuat;
    private int HSD;
    private int TongGia;

    public HopThitViewModel() {
    }

    public HopThitViewModel(String Ma, String LoaiThit, String TenLoaiThit, int TrongLuong, int SoLuong,String NgaySanXuat, int HSD, int TongGia) {
        this.Ma = Ma;
        this.LoaiThit = LoaiThit;
        this.TenLoaiThit = TenLoaiThit;
        this.TrongLuong = TrongLuong;
        this.SoLuong = SoLuong;
        this.NgaySanXuat = NgaySanXuat;
        this.HSD = HSD;
        this.TongGia = TongGia;
    }
    public HopThitViewModel(int Stt, String Ma, String LoaiThit, String TenLoaiThit, int TrongLuong, int SoLuong, String NgaySanXuat, int TongGia) {
        this.Stt = Stt;
        this.Ma = Ma;
        this.LoaiThit = LoaiThit;
        this.TenLoaiThit = TenLoaiThit;
        this.TrongLuong = TrongLuong;
        this.SoLuong = SoLuong;
        this.NgaySanXuat = NgaySanXuat;
        this.TongGia = TongGia;
    }
    public int getHSD() {
        return HSD;
    }

    public void setHSD(int HSD) {
        this.HSD = HSD;
    }
    
    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getLoaiThit() {
        return LoaiThit;
    }

    public void setLoaiThit(String LoaiThit) {
        this.LoaiThit = LoaiThit;
    }

    public String getTenLoaiThit() {
        return TenLoaiThit;
    }

    public void setTenLoaiThit(String TenLoaiThit) {
        this.TenLoaiThit = TenLoaiThit;
    }

    public int getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(int TrongLuong) {
        this.TrongLuong = TrongLuong;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(String NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    

    public int getTongGia() {
        return TongGia;
    }

    public void setTongGia(int TongGia) {
        this.TongGia = TongGia;
    }

    @Override
    public String toString() {
        return TenLoaiThit;
    }

    
    
    
}
