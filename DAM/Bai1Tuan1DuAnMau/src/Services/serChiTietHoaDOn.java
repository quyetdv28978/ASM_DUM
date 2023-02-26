/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChiTietGioHang;
import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Responsitoties.resChiTietHoaDon;
import ViewModels.ChiTietGioHangView;
import ViewModels.ChiTietHoaDonView;
import ViewModels.ChiTietSPView;
import ViewModels.HoaDonView;
import ViewModels.KhachHangView;
import ViewModels.NhanVienView;
import com.sun.source.tree.IfTree;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class serChiTietHoaDOn implements DUMService<ChiTietHoaDonView> {

    private final serGioHang serGH = new serGioHang();
    private final resChiTietHoaDon resHD = new resChiTietHoaDon();
    private final NhanVienSevices nvser = new NhanVienSevices();
    private final serChiTietSanPham serChiTietSanPham = new serChiTietSanPham();

    @Override
    public int addNV(ChiTietHoaDonView nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietHoaDonView findNV(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String timID(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateNhanVien(ChiTietHoaDonView l, String ma) {
//        return this.resHD.updateNhanVien(l, ma);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteNhanVien(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietHoaDonView> getAllNhanVien() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<HoaDonView> getHoaDon() {
        List<HoaDonView> listView = new ArrayList<>();
        NhanVienView nv;
        for (HoaDon object : this.resHD.getHoaDon()) {
            if (object.getNv() == null) {
                nv = null;
            } else {
                nv = new NhanVienView(object.getNv().getMaNV(), object.getNv().getTenNV(),
                        object.getNv().isGioiTinh(), object.getNv().getDiaChi(),
                        null, null, object.getNv().getNgaString());
            }
            listView.add(new HoaDonView(object.getId(), object.getMa(), object.getTenNguoiNhan(),
                    object.getDiaChi(), object.getSdt(),
                    object.getNgayTao(),
                    object.getNgayThanhToan(), null,
                    null, object.getTrangThai(),
                    new KhachHangView(object.getKh().getMa(), object.getKh().getTen(),
                            object.getKh().getDiaChi(), object.getKh().getSdt(), object.getKh().getNgaySinh()),
                    nv)
            );
        }
        return listView;
    }

    public ChiTietGioHang getSPCT(String sp) {
        return this.resHD.getSPCT(sp);
    }

    public List<ChiTietGioHangView> getAllCTGH() {
        return this.serGH.getAllNhanVien();
    }

    public int updateGioHang(String idhd, String idnv, int check) {
        return this.resHD.updateGioHang(idhd, idnv, check);
    }

    public void getIDKhachhang(String ma) {
        this.resHD.getIDKhachhang(ma);
    }
    
     public List<ChiTietHoaDonView> getAllGioHangCT(String ma) {
         List<ChiTietHoaDonView> listGH = new ArrayList<>();
         for (HoaDonChiTiet chiTietGioHang : this.resHD.getALLHoaDonChiTiets(ma)) {
             listGH.add(new ChiTietHoaDonView( 
                     findHD(chiTietGioHang.getHd().getId()), finCTSP(chiTietGioHang.getCt().getId())
                     ,chiTietGioHang.getSl(), chiTietGioHang.getDonGia()));
         }
         return listGH;
     }
     
     private ChiTietSPView finCTSP(String ma){
         for (ChiTietSPView object : this.serChiTietSanPham.getAllNhanVien()) {
             if (object.getId().equalsIgnoreCase(ma)) {
                 return object;
             }
         }
         return null;
     }
       public HoaDonView findHD(String ma) {
        for (HoaDonView object : getHoaDon()) {
            if (ma.equalsIgnoreCase(object.getId())) {
                return object;
            }
        }
        return null;
    }

}
