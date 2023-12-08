/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.service;

import java.util.List;
import javaapplication24.model.VoucherChiTiet;
import javaapplication24.viewmodel.VoucherViewModel;

/**
 *
 * @author Admin
 */
public interface VoucherChiTietService {
    public boolean add(VoucherChiTiet vou);
    public boolean delete(String idHoaDon);

    public List<VoucherChiTiet> getList();

    public List<VoucherViewModel> getListView();

    public boolean updateTrangThai(String idVoucherChiTiet);
}
