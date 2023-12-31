/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.repository;

import javaapplication24.model.NhanVien;
import java.util.List;

/**
 *
 * @author Do Quoc Thinh
 */
public interface INhanVienResponsitory {

    List<NhanVien> getAllNhanVien();

    int deleteNhanVien(String maNV);

    int updateNhanVien(NhanVien nv);

    NhanVien addNhanVien(NhanVien nv);
    
}
