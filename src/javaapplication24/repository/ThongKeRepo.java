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
import javaapplication24.model.ThongKeDoanhThu;
import javaapplication24.model.ThongKeHangHetHan;
import javaapplication24.model.ThongKeHoaDon;
import javaapplication24.model.ThongKeKhachHang;

import javaapplication24.model.ThongKeTable;

/**
 *
 * @author Administrator
 */
public class ThongKeRepo {
     private Connection conn;

    public ThongKeRepo() {
        conn = DBconnect.getConnection();

    }

 public List<ThongKeKhachHang> thongKeKH() {

        List<ThongKeKhachHang> ds = new ArrayList<>();
        try {

            String sql = "Select COUNT(hoaDon.idKH) as idKH from hoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
             
               
                String tongKH = rs.getString("idKH");
                
                
             
            
            ThongKeKhachHang tkkh = new ThongKeKhachHang(tongKH, "", "");
             ds.add(tkkh);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
 public List<ThongKeKhachHang> thongKeKHMonth(ThongKeKhachHang tkkh) {

        List<ThongKeKhachHang> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder("Select COUNT(hoaDon.idKH) as idKH from hoaDon") ;
            sql.append(" where MONTH(ngaytao) = ? and YEAR(ngaytao) = ? ");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1,tkkh.getThang() );
              ps.setString(2,tkkh.getNam());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String tongKH = rs.getString("idKH");
               
            ThongKeKhachHang tk = new ThongKeKhachHang(tongKH, "", "");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
 public List<ThongKeKhachHang> thongKeKHYear(ThongKeKhachHang tkkh) {

        List<ThongKeKhachHang> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder("Select COUNT(hoaDon.idKH) as idKH from hoaDon") ;
            sql.append(" where YEAR(ngaytao) = ? ");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            
              ps.setString(1,tkkh.getNam());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String tongKH = rs.getString("idKH");
               
            ThongKeKhachHang tk = new ThongKeKhachHang(tongKH, "", "");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
 public List<ThongKeHoaDon> thongKeHDMonth(ThongKeHoaDon tkhd) {

        List<ThongKeHoaDon> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder("Select COUNT(hoaDon.idHoaDon) as idHoaDon from hoaDon") ;
            sql.append(" where MONTH(ngaytao) = ? and YEAR(ngaytao) = ? ");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1,tkhd.getThang() );
              ps.setString(2,tkhd.getNam());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String tongHD = rs.getString("idHoaDon");
               
            ThongKeHoaDon tk = new ThongKeHoaDon(tongHD, "", "");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
  public List<ThongKeHoaDon> thongKeHDYear(ThongKeHoaDon tkhd) {

        List<ThongKeHoaDon> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder("Select COUNT(hoaDon.idHoaDon) as idHoaDon from hoaDon") ;
            sql.append(" where YEAR(ngaytao) = ? ");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
          
              ps.setString(1,tkhd.getNam());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String tongHD = rs.getString("idHoaDon");
               
            ThongKeHoaDon tk = new ThongKeHoaDon(tongHD, "", "");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
 
 
 
  public List<ThongKeHoaDon> thongKeHDAll() {

        List<ThongKeHoaDon> ds = new ArrayList<>();
        try {

            String sql = "Select COUNT(hoaDon.idHoaDon) as idHoaDon from hoaDon";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
             
               
                String tongHD = rs.getString("idHoaDon");
              
               ThongKeHoaDon tkhd = new ThongKeHoaDon(tongHD, "", "");
             ds.add(tkhd);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
  public List<ThongKeDoanhThu> thongKeDTMonth(ThongKeDoanhThu dt) {

        List<ThongKeDoanhThu> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder("Select SUM(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG*HoaDonChiTiet.soluong) as tongGia\n" +
"from HOPTHIT join LOAITHIT on HOPTHIT.IDLOAITHIT= LOAITHIT.ID join HoaDonChiTiet on HOPTHIT.ID = HoaDonChiTiet.idhopThit join hoaDon on hoaDon.idHoaDon = HoaDonChiTiet.idHoaDon") ;
            sql.append(" Where  MONTH(hoaDon.ngaytao) =? and YEAR(hoaDon.ngaytao) = ? ");
            sql.append(" Group by HOPTHIT.ID");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1,dt.getMonth() );
              ps.setString(2,dt.getYear());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int tongTien = rs.getInt("tongGia");
               
            ThongKeDoanhThu tk = new ThongKeDoanhThu(tongTien, "", "");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
  public List<ThongKeDoanhThu> thongKeDTYear(ThongKeDoanhThu dt) {

        List<ThongKeDoanhThu> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder("Select SUM(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG*HoaDonChiTiet.soluong) as tongGia\n" +
"from HOPTHIT join LOAITHIT on HOPTHIT.IDLOAITHIT= LOAITHIT.ID join HoaDonChiTiet on HOPTHIT.ID = HoaDonChiTiet.idhopThit join hoaDon on hoaDon.idHoaDon = HoaDonChiTiet.idHoaDon") ;
            sql.append(" Where  YEAR(hoaDon.ngaytao) = ? ");
            sql.append(" Group by HOPTHIT.ID");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
          
              ps.setString(1,dt.getYear());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int tongTien = rs.getInt("tongGia");
               
            ThongKeDoanhThu tk = new ThongKeDoanhThu(tongTien, "", "");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
 
    public List<ThongKeTable> thongKeAll() {

        List<ThongKeTable> ds = new ArrayList<>();
        try {

            String sql = "Select  HOPTHIT.ID,MAX(LOAITHIT.TEN)as tenThit,MAX(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG) as donGia,SUM(HoaDonChiTiet.soluong) as soLuong,SUM(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG*HoaDonChiTiet.soluong) as tongGia\n" +
"from HOPTHIT join LOAITHIT on HOPTHIT.IDLOAITHIT= LOAITHIT.ID join HoaDonChiTiet on HOPTHIT.ID = HoaDonChiTiet.idhopThit\n" +
"Group by HOPTHIT.ID";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
             
               
                String id = rs.getString("ID");
                String ten = rs.getString("tenThit");
                int donGia = rs.getInt("donGia");
                int soLuong = rs.getInt("soLuong");
               
                int tongTien = rs.getInt("tongGia");
             
            
             ThongKeTable tk = new ThongKeTable(id, ten, donGia, soLuong, tongTien,"","");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
     public List<ThongKeHangHetHan> thongKeFindHangHetHan(ThongKeHangHetHan tkhhh) {

        List<ThongKeHangHetHan> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder("Select  HOPTHIT.ID,LOAITHIT.TEN as tenThit, HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG as donGia,HOPTHIT.SOLUONG as soLuong,HOPTHIT.NGAYSANXUAT,LOAITHIT.HSD,HOPTHIT.TRANGTHAI\n" +
              "from HOPTHIT join LOAITHIT on HOPTHIT.IDLOAITHIT= LOAITHIT.ID ");
            
          sql.append("Where TrangThai =0 and LOAITHIT.TEN LIKE ?");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1, tkhhh.getTen());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
             
               
                String id = rs.getString("ID");
                String ten = rs.getString("tenThit");
                int donGia = rs.getInt("donGia");
                int soLuong = rs.getInt("soLuong");
               
              String nsx = rs.getString("NGAYSANXUAT");
                String hsd = rs.getString("HSD");
              int trangThai = rs.getInt("TRANGTHAI");
            
                ThongKeHangHetHan tk = new ThongKeHangHetHan(id, ten, donGia, soLuong, nsx, hsd, trangThai);
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
     
      public List<ThongKeHangHetHan> thongKeHangHetHan() {

        List<ThongKeHangHetHan> ds = new ArrayList<>();
        try {

            String sql = "Select  HOPTHIT.ID,LOAITHIT.TEN as tenThit, HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG as donGia,HOPTHIT.SOLUONG as soLuong,HOPTHIT.NGAYSANXUAT,LOAITHIT.HSD,HOPTHIT.TRANGTHAI\n" +
"from HOPTHIT join LOAITHIT on HOPTHIT.IDLOAITHIT= LOAITHIT.ID \n" +
"Where TrangThai =0 ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
             
               
                String id = rs.getString("ID");
                String ten = rs.getString("tenThit");
                int donGia = rs.getInt("donGia");
                int soLuong = rs.getInt("soLuong");
               
              String nsx = rs.getString("NGAYSANXUAT");
                String hsd = rs.getString("HSD");
              int trangThai = rs.getInt("TRANGTHAI");
            
                ThongKeHangHetHan tk = new ThongKeHangHetHan(id, ten, donGia, soLuong, nsx, hsd, trangThai);
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
     public List<ThongKeTable> thongKeAllMonth(ThongKeTable tkt) {

        List<ThongKeTable> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder( "Select  HOPTHIT.ID,MAX(LOAITHIT.TEN)as tenThit,MAX(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG) as donGia,SUM(HoaDonChiTiet.soluong) as soLuong,SUM(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG*HoaDonChiTiet.soluong) as tongGia\n" +
"from HOPTHIT join LOAITHIT on HOPTHIT.IDLOAITHIT= LOAITHIT.ID join HoaDonChiTiet on HOPTHIT.ID = HoaDonChiTiet.idhopThit join hoaDon on hoaDon.idHoaDon = HoaDonChiTiet.idHoaDon");
            sql.append(" Where  MONTH(hoaDon.ngaytao) =?  and YEAR(hoaDon.ngaytao) = ?   ");
              sql.append("Group by HOPTHIT.ID");
              
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1, tkt.getThang());
             ps.setString(2, tkt.getNam());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
             
               
                String id = rs.getString("ID");
                String ten = rs.getString("tenThit");
                int donGia = rs.getInt("donGia");
                int soLuong = rs.getInt("soLuong");
               
                int tongTien = rs.getInt("tongGia");
             
            
             ThongKeTable tk = new ThongKeTable(id, ten, donGia, soLuong, tongTien,"","");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
      public List<ThongKeTable> thongKeAllYear(ThongKeTable tkt) {

        List<ThongKeTable> ds = new ArrayList<>();
        try {

            StringBuilder sql =new StringBuilder( "Select  HOPTHIT.ID,MAX(LOAITHIT.TEN)as tenThit,MAX(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG) as donGia,SUM(HoaDonChiTiet.soluong) as soLuong,SUM(HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG*HoaDonChiTiet.soluong) as tongGia\n" +
"from HOPTHIT join LOAITHIT on HOPTHIT.IDLOAITHIT= LOAITHIT.ID join HoaDonChiTiet on HOPTHIT.ID = HoaDonChiTiet.idhopThit join hoaDon on hoaDon.idHoaDon = HoaDonChiTiet.idHoaDon");
            sql.append(" Where  YEAR(hoaDon.ngaytao) = ?   ");
              sql.append("Group by HOPTHIT.ID");
              
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            
             ps.setString(1, tkt.getNam());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
             
               
                String id = rs.getString("ID");
                String ten = rs.getString("tenThit");
                int donGia = rs.getInt("donGia");
                int soLuong = rs.getInt("soLuong");
               
                int tongTien = rs.getInt("tongGia");
             
            
             ThongKeTable tk = new ThongKeTable(id, ten, donGia, soLuong, tongTien,"","");
             ds.add(tk);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
}
