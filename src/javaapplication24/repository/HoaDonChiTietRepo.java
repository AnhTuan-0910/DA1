/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import java.util.List;
import javaapplication24.viewmodel.HoaDonCtViewModel;
import java.sql.*;
import java.util.ArrayList;
import javaapplication24.model.HoaDonChiTiet;
/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepo {

    public List<HoaDonCtViewModel> getList() {
        String query = """
                       select hdct.idHoaDon,lt.ten,hdct.soluong,hdct.donGia from HoaDonChiTiet as hdct join hopthit as ht on hdct.idHopThit = ht.id join loaiThit as lt on lt.id = ht.idLoaiThit 
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps  = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<HoaDonCtViewModel> list = new ArrayList<>();
            while(rs.next()){
                HoaDonCtViewModel hdct = new HoaDonCtViewModel(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonChiTiet hdct) {
        int check =0;
        String query = """
                       INSERT INTO [dbo].[HoaDonChiTiet]
                                  ([idHoaDon]
                                  ,[idhopThit]
                                  ,[soluong]
                                  ,[donGia])
                            VALUES (?,?,?,?)
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1,hdct.getIdHoaDon());
            ps.setObject(2,hdct.getIdHopThit());
            ps.setObject(3,hdct.getSoLuong());
            ps.setObject(4,hdct.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

}
