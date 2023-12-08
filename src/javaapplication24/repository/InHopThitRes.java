/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.repository;

import javaapplication24.model.HopThit;
import java.util.ArrayList;
import javaapplication24.viewmodel.HopThitViewModel;

/**
 *
 * @author Admin
 */
public interface InHopThitRes {
    ArrayList<HopThit> read();
    ArrayList<HopThitViewModel> readAll();
    HopThit getHTByMa(String Ma);
    int add(HopThit ht);
    int delete(String Ma);
    int update(HopThit ht);
    int update(HopThit ht, int SL);
}
