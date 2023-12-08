/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.List;
import javaapplication24.model.VoucherChiTiet;
import javaapplication24.repository.VoucherChitietRepository;
import javaapplication24.service.VoucherChiTietService;
import javaapplication24.viewmodel.VoucherViewModel;


public class VoucherChiTietServiceImpl implements VoucherChiTietService{
    VoucherChitietRepository vcr = new VoucherChitietRepository();
    @Override
    public boolean add(VoucherChiTiet vou) {
        return vcr.add(vou);
    }

    @Override
    public boolean delete(String idHoaDon) {
        return vcr.delete(idHoaDon);
    }

    @Override
    public List<VoucherChiTiet> getList() {
        return vcr.getList();
    }

    public List<VoucherViewModel> getListv(String idKhachHang) {
        return vcr.getListView(idKhachHang);
    }

    @Override
    public List<VoucherViewModel> getListView() {
        return vcr.getListView();
    }

    @Override
    public boolean updateTrangThai(String idVoucherChiTiet) {
        return vcr.updateTrangThai(idVoucherChiTiet);
    }
    
}
