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
import javaapplication24.model.KhachHang;

/**
 *
 * @author fptsh
 */
public class KhachHangRepository {
    
    public static List<KhachHang> readDB() {
        String query = """
                       SELECT [tenKH]
                             ,[gioiTinh]
                             ,[sdt]
                         FROM [dbo].[khachHang]
                       """;
        try ( Connection con = DBconnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1),rs.getInt(2),rs.getString(3));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<KhachHang> getMa(String sdt) {
        String query = """
                       SELECT [tenKH]
                             ,[gioiTinh]
                             ,[sdt]
                         FROM [dbo].[khachHang]
                         WHERE sdt = ?
                       """;
        try ( Connection con = DBconnect.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, sdt);
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1),rs.getInt(2),rs.getString(3));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static List<KhachHang> sortByName() {
        String query = """
                       SELECT [tenKH]
                        ,[gioiTinh]
                        ,[sdt]
                       FROM [dbo].[khachHang]
                       ORDER BY tenKH ASC
                       """;
        try ( Connection con = DBconnect.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1),rs.getInt(2),rs.getString(3));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(KhachHang khachHang) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[khachHang]
                                  ([tenKH]
                                  ,[gioiTinh]
                                  ,[sdt])
                            VALUES
                                  (?,?,?)
                       """;
        try ( Connection con = DBconnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, khachHang.getTenKH());
            ps.setObject(2, khachHang.getGioiTinh());
            ps.setObject(3, khachHang.getSdt());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean update(String sdt, KhachHang khachHang) {
        int check = 0;
        String query = """
                        UPDATE [dbo].[khachHang]
                           SET [tenKH] = ?
                              ,[gioiTinh] = ?
                              ,sdt = ?
                         WHERE sdt = ?
                       """;
        try ( Connection con = DBconnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(4, sdt);
            ps.setObject(1, khachHang.getTenKH());
            ps.setObject(2, khachHang.getGioiTinh());
            ps.setObject(3, khachHang.getSdt());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }   
}
