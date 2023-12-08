/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Administrator
 */
public class ThongKeKhachHang {
    private String tongKH;
private String thang;
private String nam;
    public ThongKeKhachHang() {
    }

    public ThongKeKhachHang(String tongKH, String thang, String nam) {
        this.tongKH = tongKH;
        this.thang = thang;
        this.nam = nam;
    }

  

    public String getTongKH() {
        return tongKH;
    }

    public void setTongKH(String tongKH) {
        this.tongKH = tongKH;
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
