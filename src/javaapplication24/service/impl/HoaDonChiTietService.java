/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.List;
import javaapplication24.model.HoaDonChiTiet;
import javaapplication24.repository.HoaDonChiTietRepo;
import javaapplication24.viewmodel.HoaDonCtViewModel;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietService {
    HoaDonChiTietRepo hdctr = new HoaDonChiTietRepo();
    public List<HoaDonCtViewModel> getList() {
        return hdctr.getList();
    }

    public boolean add(HoaDonChiTiet hdct) {
        return hdctr.add(hdct);
    }
    
}
