/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChiTietGioHang;
import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Responsitoties.DUMinterface;
import Responsitoties.ResChiTietSanPham;
import Responsitoties.resGioHang;
import Utilities.DBConnection;
import ViewModels.ChiTietGioHangView;
import ViewModels.ChiTietHoaDonView;
import ViewModels.ChiTietSPView;
import ViewModels.GioHangView;
import ViewModels.HoaDonView;
import ViewModels.KhachHangView;
import ViewModels.SanPhamView;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class serGioHang implements intefaceGioHang {

    private final ResChiTietSanPham resSP = new ResChiTietSanPham();
    private final serChiTietSanPham serC = new serChiTietSanPham();
    private final KhachHangSer kh = new KhachHangSer();
    private final resGioHang resGH = new resGioHang();

    @Override
    public int addNV(ChiTietGioHangView nv) {
        ChiTietGioHangView c = (ChiTietGioHangView) nv;
        ChiTietSanPham ctsp = this.resSP.findNV(c.getCt().getSp().getTen());
        ctsp.setSoLuongTon(c.getCt().getSoLuongTon());
        ChiTietGioHang ct = new ChiTietGioHang(c.getSl(), c.getDonGia(), c.getDonGiaKhiGiam(),
                ctsp);
        return this.resGH.addNV(ct);
    }

    @Override
    public ChiTietGioHangView findNV(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String timID(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateNhanVien(ChiTietGioHangView ct, String ma) {
//        return DBConnection.ExcuteDungna("update giohang set trangthai", args)
        return 0;
    }

    @Override
    public int deleteNhanVien(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietGioHangView> getAllNhanVien() {
        List<ChiTietGioHangView> listGiohangView = new ArrayList<>();
        for (ChiTietGioHang chiTietGioHang : this.resGH.getAllNhanVien()) {
            listGiohangView.add(new ChiTietGioHangView(chiTietGioHang.getSl(), chiTietGioHang.getDonGia(),
                    chiTietGioHang.getDonGiaKhiGiam(),
                    new GioHangView(chiTietGioHang.getGh().getMa(), chiTietGioHang.getGh().getDiachi(), chiTietGioHang.getGh().getSdt(),
                            chiTietGioHang.getGh().getTinhTrang(), chiTietGioHang.getGh().getNgayTao(),
                            chiTietGioHang.getGh().getNgayThanhToan(),
                            chiTietGioHang.getGh().getTenNguoiNhan(),
                            kh.findNV(chiTietGioHang.getGh().getKh().getMa())),
                    serC.findNV(chiTietGioHang.getCt().getSp().getTen())
            ));
        }
        return listGiohangView;
    }

    public List<ChiTietSPView> getSp() {
        return this.serC.getAllNhanVien();
    }

    public List<KhachHangView> getKH() {
        return this.kh.getAllNhanVien();
    }

    public ChiTietSPView getCT(String id) {
        ChiTietSanPham cd = this.resGH.getCT(id);
        return new ChiTietSPView(cd.getSoLuongTon(), cd.getGianhap(), cd.getGiaBan(), new SanPhamView(cd.getSp().getMa(), cd.getSp().getTen()));
    }

    public void addCTHD() {
        this.resGH.addCTHD();
    }

    public int addHoaDon() {
        return this.resGH.addHoaDon();
    }

    public void getIDkhachHang(String ma) {
        this.resGH.getIDkhachHang(ma);
    }

    public void getTenSP(String ma) {
        this.resGH.getChiTietSP(ma);
    }

    public List<HoaDonView> getHoaDon(String ma) {
        List<HoaDonView> listHD = new ArrayList<>();
            for (HoaDon hoaDon : this.resGH.getHoaDon(ma)) {
            listHD.add(new HoaDonView(hoaDon.getId(), hoaDon.getMa(),
                        hoaDon.getTenNguoiNhan(), hoaDon.getDiaChi(),
                        hoaDon.getSdt(), hoaDon.getNgayTao(),
                        hoaDon.getNgayThanhToan(),
                        null, null,
                        hoaDon.getTrangThai(), null, null));
            }
        return listHD;
    }

    
    private Date getDate(String date) {
        Date d = null;
        try {
            d = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return d;
    }
    
    public List<ChiTietHoaDonView> getAllCTSanPham(String dk) {
        List<ChiTietHoaDonView> listHoaDonViews=new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet : this.resGH.getAllCTSanPham(dk)) {
            listHoaDonViews.add(new ChiTietHoaDonView(new HoaDonView
        (hoaDonChiTiet.getHd().getTenNguoiNhan(), hoaDonChiTiet.getHd().getDiaChi(),
                hoaDonChiTiet.getHd().getSdt(), hoaDonChiTiet.getHd().getNgayNhan(), hoaDonChiTiet.getHd().getTrangThai()), 
                    this.serC.finChiTietSanPham(hoaDonChiTiet.getCt().getId()), hoaDonChiTiet.getSl(), hoaDonChiTiet.getDonGia()));
        }
        return listHoaDonViews;
    }

}
