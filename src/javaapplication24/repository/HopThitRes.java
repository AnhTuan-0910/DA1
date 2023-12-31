/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import javaapplication24.model.HopThit;
import javaapplication24.model.LoaiThit;
import  javaapplication24.Utilities.JDBCHelpers;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication24.Utilities.JDBCHelpers;
import javaapplication24.viewmodel.HopThitViewModel;

/**
 *
 * @author Admin
 */
public class HopThitRes implements InHopThitRes{
    
    public ArrayList<HopThit> read(){
        ArrayList<HopThit> listHT = new ArrayList<>();
        String sql = "SELECT HOPTHIT.ID, HOPTHIT.TRONGLUONG, HOPTHIT.SOLUONG, HOPTHIT.NGAYSANXUAT, HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG, LOAITHIT.ID, LOAITHIT.TEN, LOAITHIT.GIATHEOKG, LOAITHIT.HSD FROM HOPTHIT JOIN LOAITHIT ON HOPTHIT.IDLOAITHIT = LOAITHIT.ID ORDER BY HOPTHIT.ID";
        ResultSet rs = JDBCHelpers.executeQuery(sql);
        try {
            while (rs.next()) {
                String Id = rs.getString(1);
                int TrongLuong = Integer.parseInt(rs.getString(2));
                int SoLuong = Integer.parseInt(rs.getString(3));
                int TongGia = Integer.parseInt(rs.getString(5));
                listHT.add(new HopThit(Id, rs.getString(6), rs.getString(7), TrongLuong, SoLuong, rs.getDate(4),TongGia));
            }
            return listHT;

        } catch (SQLException ex) {
            Logger.getLogger(HopThitRes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    public ArrayList<HopThitViewModel> readAll(){
        ArrayList<HopThitViewModel> listHT = new ArrayList<>();
        String sql = "SELECT HOPTHIT.ID, HOPTHIT.TRONGLUONG, HOPTHIT.SOLUONG, HOPTHIT.NGAYSANXUAT, HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG, LOAITHIT.ID, LOAITHIT.TEN, LOAITHIT.GIATHEOKG, LOAITHIT.HSD FROM HOPTHIT JOIN LOAITHIT ON HOPTHIT.IDLOAITHIT = LOAITHIT.ID ORDER BY HOPTHIT.ID";
        ResultSet rs = JDBCHelpers.executeQuery(sql);
        try {
            while (rs.next()) {
                listHT.add(new HopThitViewModel(rs.getString(1),rs.getString(6),rs.getString(7),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(9),rs.getInt(5)));
            }
            return listHT;

        } catch (SQLException ex) {
            Logger.getLogger(HopThitRes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    public HopThit getHTByMa(String Ma){
        HopThit ht = null;
        String sql = "SELECT HOPTHIT.ID, HOPTHIT.TRONGLUONG, HOPTHIT.SOLUONG, HOPTHIT.NGAYSANXUAT, HOPTHIT.TRONGLUONG*LOAITHIT.GIATHEOKG, LOAITHIT.ID, LOAITHIT.TEN, LOAITHIT.GIATHEOKG, LOAITHIT.HSD FROM HOPTHIT JOIN LOAITHIT ON HOPTHIT.IDLOAITHIT = LOAITHIT.ID WHERE HOPTHIT.ID = ? ORDER BY HOPTHIT.ID";
        ResultSet rs = JDBCHelpers.executeQuery(sql,Ma);
        try {
            while (rs.next()) {
                String Id = rs.getString(1);
                int TrongLuong = Integer.parseInt(rs.getString(2));
                int SoLuong = Integer.parseInt(rs.getString(3));
                int TongGia = Integer.parseInt(rs.getString(5));
                ht = new HopThit(Id, rs.getString(6), rs.getString(7), TrongLuong, SoLuong, rs.getDate(4), TongGia);
            }
            return ht;

        } catch (SQLException ex) {
            Logger.getLogger(HopThitRes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    public int add(HopThit ht) {
        String sql = "INSERT INTO HOPTHIT (IDLOAITHIT, TRONGLUONG, SOLUONG, NGAYSANXUAT) VALUES (?,?,?,?)";
        return JDBCHelpers.executeUpdate(sql, ht.getIDLoaiThit(), ht.getTrongLuong(), ht.getSoLuong(), ht.getNgaySanXuat());
    }
    
    public int delete(String Ma) {
        String sql = "DELETE FROM HOPTHIT WHERE ID = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    public int update(HopThit ht) {
        String sql = "UPDATE HOPTHIT SET IDLOAITHIT = ?, TRONGLUONG = ?, SOLUONG = ?, NGAYSANXUAT = ? WHERE ID = ?";
        return JDBCHelpers.executeUpdate(sql, ht.getIDLoaiThit(), ht.getTrongLuong(), ht.getSoLuong(), ht.getNgaySanXuat(), ht.getId());
    }
    
    public int update(HopThit ht, int SL) {
        int SLSP = ht.getSoLuong() - SL;
        String sql = "UPDATE HOPTHIT SET SOLUONG = ? WHERE ID = ?";
        return JDBCHelpers.executeUpdate(sql, SLSP, ht.getId());
    }
}
