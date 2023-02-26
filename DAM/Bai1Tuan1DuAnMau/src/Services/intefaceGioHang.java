/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ViewModels.ChiTietGioHangView;
import java.util.List;

/**
 *
 * @author yugip
 */
public interface intefaceGioHang {
    public int addNV(ChiTietGioHangView nv);
    public ChiTietGioHangView findNV(String ma);
    public String timID(String ma);
    public int updateNhanVien(ChiTietGioHangView ct, String ma);
    public int deleteNhanVien(String ma);
    public List<ChiTietGioHangView> getAllNhanVien();
    
}
