/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service;

import java.util.List;
import javaapplication24.model.ThongKeDoanhThu;
import javaapplication24.model.ThongKeHangHetHan;
import javaapplication24.model.ThongKeHoaDon;

import javaapplication24.model.ThongKeKhachHang;
import javaapplication24.model.ThongKeTable;
import javaapplication24.repository.ThongKeRepo;

/**
 *
 * @author Administrator
 */
public class ThongKeService {

    private ThongKeRepo thongKeRepo;

    public ThongKeService() {
        thongKeRepo = new ThongKeRepo();
    }

    public List ThongKeAll() {
        return thongKeRepo.thongKeAll();
    }
     public List ThongKeHangHetHan() {
        return thongKeRepo.thongKeHangHetHan();
    }
 public List ThongKeFindHangHetHan(ThongKeHangHetHan tkhhh) {
        return thongKeRepo.thongKeFindHangHetHan(tkhhh);
    }
    public List ThongKeKHAll() {
        return thongKeRepo.thongKeKH();
    }

    public List ThongKeHDAll() {
        return thongKeRepo.thongKeHDAll();
    }

    public List ThongKeKhMonth(ThongKeKhachHang tkkh) {
        return thongKeRepo.thongKeKHMonth(tkkh);
    }

    public List ThongKeHDMonth(ThongKeHoaDon tkhd) {
        return thongKeRepo.thongKeHDMonth(tkhd);
    }

    public List ThongKeDTMonth(ThongKeDoanhThu tkdt) {
        return thongKeRepo.thongKeDTMonth(tkdt);
    }

    public List ThongKeKhYear(ThongKeKhachHang tkkh) {
        return thongKeRepo.thongKeKHYear(tkkh);
    }

    public List ThongKeHDYear(ThongKeHoaDon tkhd) {
        return thongKeRepo.thongKeHDYear(tkhd);
    }

    public List ThongKeDTYear(ThongKeDoanhThu tkdt) {
        return thongKeRepo.thongKeDTYear(tkdt);
    }
     public List ThongKeAllMonth(ThongKeTable tkt) {
        return thongKeRepo.thongKeAllMonth(tkt);
    }
    public List ThongKeAllYear(ThongKeTable tkt) {
        return thongKeRepo.thongKeAllYear(tkt);
    }
}
