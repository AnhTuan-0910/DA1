/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import javaapplication24.model.VoucherChiTiet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javaapplication24.viewmodel.VoucherViewModel;
/**
 *
 * @author Admin
 */
public class VoucherChitietRepository {

    public boolean add(VoucherChiTiet vou) {
        int check=0;
        String query = """
                       INSERT INTO [dbo].[voucherChitiet]
                                  ([idVoucher]
                                  ,[idKhachHang]
                                  ,[NgayKetThuc]
                                  ,[Tinhtrang]
                                  ,[idHoaDon])
                            VALUES(?,?,?,?,?)
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, vou.getIdVoucher());
            ps.setObject(2, vou.getIdKhachHang());
            ps.setObject(3, vou.getNgayKetThuc());
            ps.setObject(4, vou.getTrangThai());
            ps.setObject(5, vou.getIdHoaDon());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

    public boolean delete(String idHoaDon) {
        int check=0;
        String query = """
                       DELETE FROM [dbo].[voucherChitiet]
                             WHERE idHoaDon = ?
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, idHoaDon);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }

    public List<VoucherChiTiet> getList() {
        String query = """
                       SELECT [idVoucherChitiet]
                             ,[idVoucher]
                             ,[idKhachHang]
                             ,[NgayKetThuc]
                             ,[Tinhtrang]
                             ,[idHoaDon]
                         FROM [dbo].[voucherChitiet]
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<VoucherChiTiet> list = new ArrayList<>();
            while(rs.next()){
                VoucherChiTiet vct = new VoucherChiTiet(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getByte(5));
                list.add(vct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<VoucherViewModel> getListView(String idKhachhang) {
        String query = """
                       select vct.idvoucherChitiet,vct.Ngayketthuc,v.loai,v.giaTri,v.MucGiaGioiHan from voucherChiTiet as vct join voucher as v on vct.idVoucher= v.idvoucher where vct.idkhachhang = ? and vct.TinhTrang = 1 and vct.Ngayketthuc>getDate()
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, idKhachhang);
            ResultSet rs = ps.executeQuery();
            List<VoucherViewModel> list = new ArrayList<>();
            while(rs.next()){
                VoucherViewModel vvm = new VoucherViewModel(rs.getString(1),rs.getByte(3),rs.getInt(4),rs.getString(2),rs.getInt(5));
                list.add(vvm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<VoucherViewModel> getListView() {
        String query = """
                       select vct.idvoucherChitiet,vct.Ngayketthuc,v.loai,v.giaTri,v.MucGiaGioiHan from voucherChiTiet as vct join voucher as v on vct.idVoucher= v.idvoucher where vct.TinhTrang = 1 and vct.Ngayketthuc>getDate()
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<VoucherViewModel> list = new ArrayList<>();
            while(rs.next()){
                VoucherViewModel vvm = new VoucherViewModel(rs.getString(1),rs.getByte(3),rs.getInt(4),rs.getString(2),rs.getInt(5));
                list.add(vvm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean updateTrangThai(String idVoucherChiTiet) {
        int check=0;
        String query = """
                       UPDATE [dbo].[voucherChitiet]
                          SET [Tinhtrang] = ?
                        WHERE [idVoucherChitiet] = ?
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, 0);
            ps.setObject(2, idVoucherChiTiet);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }
    
}
