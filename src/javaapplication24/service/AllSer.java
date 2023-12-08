/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service;

/**
 *
 * @author Admin
 */
public class AllSer {
    public static InThitSer getThitSer(){
        return new ThitSer();
    }
    
    public static InLoaiThitSer getLoaiThitSer(){
        return new LoaiThitSer();
    }
    
    public static InHopThitSer getHopThitSer(){
        return new HopThitSer();
    }
}
