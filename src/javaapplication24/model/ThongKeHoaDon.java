/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Administrator
 */
public class ThongKeHoaDon {
    private String tongHD;
       private String thang;
   private String nam;
    public ThongKeHoaDon() {
    }

    public ThongKeHoaDon(String tongHD, String thang, String nam) {
        this.tongHD = tongHD;
        this.thang = thang;
        this.nam = nam;
    }

   

    public String getTongHD() {
        return tongHD;
    }

    public void setTongHD(String tongKH) {
        this.tongHD = tongKH;
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
