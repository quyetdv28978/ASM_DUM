/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author yugip
 */
public interface intefaceChitiethoadon {

    public int addNV(HoaDonChiTiet nv);

    public HoaDonChiTiet findNV(String ma);

    public String timID(String ma);

    public int updateNhanVien(HoaDonChiTiet l, String ma);

    public int deleteNhanVien(String ma);

    public List<HoaDonChiTiet> getAllNhanVien();

    public List<HoaDon> getHoaDon();

    public int updateGioHang(String ma, String idnv, int check);
    
}
