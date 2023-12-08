/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javaapplication24.model.HoaDon;

/**
 *
 * @author Administrator
 */
public class HoaDonRepo {

    private Connection conn;

    public HoaDonRepo() {
        conn = DBconnect.getConnection();

    }

    public List<HoaDon> all() {

        List<HoaDon> ds = new ArrayList<>();
        try {

            String sql = "Select * from hoaDon where hinhThucGiaoHang = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("idHoaDon");
                 String idKH = rs.getString("idKH");
                  String idVC = rs.getString("idVC");
                   String idNV = rs.getString("idNV");
                String ngayTao = rs.getString("ngaytao");
                int hinhThucNhanHang = rs.getInt("hinhThucGiaoHang");
                String ghiChu = rs.getString("ghiChu");
                HoaDon hd = new HoaDon(idNV, idKH, idVC, idNV, ngayTao, hinhThucNhanHang,rs.getInt("thanhToan") ,ghiChu);
                ds.add(hd);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }

    public List<HoaDon> getList() {
        String query = """
                       SELECT [idHoaDon]
                             ,[idKH]
                             ,[idVC]
                             ,[idNV]
                             ,[hinhThucGiaoHang]
                             ,[ghiChu]
                             ,[ngaytao]
                             ,[thanhToan]
                         FROM [dbo].[hoaDon]
                       """;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getInt(5),rs.getInt(8),rs.getString(6));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDon hd) {
        int check=0;
        String query = """
                       INSERT INTO [dbo].[hoaDon]
                                  ([idHoaDon]
                                  ,[idKH]
                                  ,[idVC]
                                  ,[idNV]
                                  ,[hinhThucGiaoHang]
                                  ,[ghiChu]
                                  ,[ngaytao]
                                  ,[thanhToan])
                            VALUES (?,?,?,?,?,?,?,?)
                       """;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, hd.getIdHoaDon());
            ps.setObject(2, hd.getIdKH());
            if(hd.getIdVC().isEmpty()){
                ps.setObject(3,null);
            }else {
                ps.setObject(3, hd.getIdVC());
            }
            ps.setObject(4, hd.getIdNV());
            ps.setObject(5, hd.getHinhThucGiaoHang());
            ps.setObject(6, hd.getGhiChu());
            ps.setObject(7, hd.getNgayTao());
            ps.setObject(8, hd.getThanhToan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

}
