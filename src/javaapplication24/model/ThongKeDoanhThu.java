/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Administrator
 */
public class ThongKeDoanhThu {
    private int tongTien;
       private String month;
          private String year;

    public ThongKeDoanhThu() {
    }

    public ThongKeDoanhThu(int tongTien, String month, String year) {
        this.tongTien = tongTien;
        this.month = month;
        this.year = year;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
          
}
