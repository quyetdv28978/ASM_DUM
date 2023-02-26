/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitoties;

import DomainModels.ChiTietGioHang;
import DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author yugip
 */
public interface intefaceGioHang {

    public int addNV(ChiTietGioHang nv);

    public ChiTietGioHang findNV(String ma);

    public String timID(String ma);

    public int updateNhanVien(ChiTietGioHang l, String ma);

    public int addHoaDon();

    public int deleteNhanVien(String ma);

    public List<ChiTietGioHang> getAllNhanVien();

    public List<Object> getGH();
    
    public int addGH();
    
    public List<HoaDon> getHoaDon(String ma);
}
