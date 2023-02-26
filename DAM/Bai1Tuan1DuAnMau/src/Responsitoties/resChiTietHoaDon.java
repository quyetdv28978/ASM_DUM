/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.ChiTietGioHang;
import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author yugip
 */
public class resChiTietHoaDon implements intefaceChitiethoadon {

    private final resGioHang resGiohang = new resGioHang();
    private final KhachHangRes kh = new KhachHangRes();
    private final NhanVienResponsitories nvres = new NhanVienResponsitories();
    private final ResChiTietSanPham ResChiTietSanPham = new ResChiTietSanPham();

    @Override
    public int addNV(HoaDonChiTiet nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonChiTiet findNV(String ma) {
        return null;
    }

    public HoaDon findHD(String ma) {
        for (HoaDon object : getHoaDon()) {
            if (ma.equalsIgnoreCase(object.getId())) {
                return object;
            }
        }
        return null;
    }

    @Override
    public String timID(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateNhanVien(HoaDonChiTiet l, String ma) {
        throw new UnsupportedClassVersionError();
    }

    @Override
    public int deleteNhanVien(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonChiTiet> getAllNhanVien() {
        List<HoaDonChiTiet> lHoadon = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            PreparedStatement pre = con.prepareStatement("select * from khachhang k join hoadon d on k.id = d.idkh");
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                lHoadon.add(new HoaDonChiTiet(new HoaDon(re.getString(12), re.getString(15), re.getString(21), re.getString(22),
                        re.getString(23), getDate(re.getString(16)), null, null, null, re.getInt(20),
                        new KhachHang(re.getString(1), re.getString(2), re.getString(3),
                                re.getString(7), re.getString(8),
                                getDate(re.getString(6))),
                        null),
                        null, 0, 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lHoadon;
    }

    @Override
    public int updateGioHang(String idhd, String idnv, int check) {
        Date d;
        LocalDate d1;
        if (check == 2) {
            d = null;
            d1 = null;
        } else {
            d = new Date(new java.util.Date().getTime());
            d1 = d.toLocalDate().plusDays(3);
        }
        System.out.println("d, d1: " + d  + d1);
        return DBConnection.ExcuteDungna("update hoadon set idnv = ?, tinhtrang = ?, ngayship = ?, ngaynhan= ? where id = ?",
                new Object[]{idnv, check, d, d1, idhd});
    }

    @Override
    public List<HoaDon> getHoaDon() {
        List<HoaDon> lhd = new ArrayList<>();
        Connection con = DBConnection.openDbConnection();
        PreparedStatement pre;
        NhanVien nv;
        try {
            pre = con.prepareStatement("select * from hoadon");
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                if (re.getString("idnv") == null) {
                    nv = null;
                } else {
                    nv = nvres.findNV(re.getString("idnv"));
                }
                lhd.add(new HoaDon(re.getString("id"), re.getString("ma"),
                        re.getString("tenNguoiNhan"), re.getString("DiaChi"),
                        re.getString("sdt"), getDate(re.getString("ngayTao")),
                        getDate(re.getString("ngaythanhtoan")),
                        null, null, re.getInt("tinhtrang"), this.kh.getKHID(re.getString("idkh")), nv));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lhd;
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

    public List<ChiTietGioHang> getAllCTGH() {
        return this.resGiohang.getAllNhanVien();
    }

    public void getIDKhachhang(String ma) {
        this.resGiohang.getIDkhachHang(ma);
    }

    public ChiTietGioHang getSPCT(String sp) {
        for (ChiTietGioHang object : this.resGiohang.getAllNhanVien()) {
            if (object.getCt().getSp().getTen().equalsIgnoreCase(sp)) {
                return object;
            }
        }
        return null;
    }

    public List<HoaDonChiTiet> getALLHoaDonChiTiets(String ma) {
        List<HoaDonChiTiet> listCT = new ArrayList<>();
        String sql = "select * from hoadon g join hoadonchitiet c on g.id = c.idhoadon where g.id =  " + "'" + ma + "'";
        System.out.println("sql: " + sql);
        try {
            ResultSet re = DBConnection.openDbConnection().prepareStatement(sql).executeQuery();
            while (re.next()) {
                listCT.add(new HoaDonChiTiet(findHD(ma), finCTSP(re.getString("idchitietsp")),
                        re.getInt("soluong"), re.getDouble("dongia")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listCT;
    }

    private ChiTietSanPham finCTSP(String ma) {
        for (ChiTietSanPham chiTietSanPham : ResChiTietSanPham.getAllNhanVien()) {
            if (chiTietSanPham.getId().equalsIgnoreCase(ma)) {
                return chiTietSanPham;
            }
        }
        return null;
    }

}
