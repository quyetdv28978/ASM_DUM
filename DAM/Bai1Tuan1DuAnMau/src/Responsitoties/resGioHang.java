/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.ChiTietGioHang;
import DomainModels.ChiTietSanPham;
import DomainModels.GioHang;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import Utilities.DBConnection;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yugip
 */
public class resGioHang implements intefaceGioHang {

    private int checkGioHang;
    private final KhachHangRes reskhachhang = new KhachHangRes();
    private final ResChiTietSanPham resCtSp = new ResChiTietSanPham();
    private static KhachHang idkh;
    private String tenSp;
    private String idHoaDon;

    @Override
    public int addNV(ChiTietGioHang nv) {
        ChiTietGioHang ct = (ChiTietGioHang) nv;
        checkGioHang = DBConnection.ExcuteDungna("insert into giohang(id, idkh, ma) values(newid(), ?, ?)",
                new Object[]{timID(idkh.getId()), new Random().nextLong(100000)});
        if (getAllNhanVien().isEmpty() == false) {
            for (ChiTietGioHang chiTietGioHang : getAllNhanVien()) {
                if (ct.getCt().getSp().getTen().equalsIgnoreCase(chiTietGioHang.getCt().getSp().getTen())) {
                    checkGioHang = DBConnection.ExcuteDungna("Update giohangchitiet set soluong=?, dongia=? where IdChiTietSP = ?",
                            new Object[]{
                                ct.getSl() + findNV(ct.getCt().getSp().getMa()).getSl(), ct.getDonGia(),
                                ct.getCt().getId()
                            });
                    checkGioHang = DBConnection.ExcuteDungna("update chitietsp set soluongton = ? where id = ?",
                            new Object[]{ct.getCt().getSoLuongTon(), ct.getCt().getId()});
                    return checkGioHang;
                }
            }
        }
        checkGioHang = addGH();
        checkGioHang = DBConnection.ExcuteDungna("insert into giohangchitiet(IdGioHang, IdChiTietSP, SoLuong, DonGia, DonGiaKhiGiam) values(?,?,?,?,?)",
                new Object[]{
                    getIDHoaDon(idkh.getId()), tenSp, ct.getSl(), ct.getDonGia(), ct.getDonGiaKhiGiam()
                });
        checkGioHang = DBConnection.ExcuteDungna("update chitietsp set soluongton = ? where id = ?",
                new Object[]{ct.getCt().getSoLuongTon(), ct.getCt().getId()});
        return checkGioHang;
    }

    @Override
    public ChiTietGioHang findNV(String ma) {
        for (ChiTietGioHang chiTietGioHang : getAllNhanVien()) {
            if (chiTietGioHang.getCt().getSp().getMa().equalsIgnoreCase(ma)) {
                return chiTietGioHang;
            }
        }
        return null;
    }

    @Override
    public String timID(String ma) {
        for (Object object : this.getGH()) {
            if (ma.equalsIgnoreCase(((GioHang) object).getKh().getMa())) {
                return ((GioHang) object).getId();
            }
        }
        return null;
    }

    @Override
    public int updateNhanVien(ChiTietGioHang l, String ma) {
        return 0;
    }

    @Override
    public int deleteNhanVien(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietGioHang> getAllNhanVien() {
        List<ChiTietGioHang> gioHangList = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            PreparedStatement pre = con.prepareStatement("select * from khachhang k join giohang g on k.id = g.idkh join GioHangChitiet ct on ct.idgiohang = g.id "
                    + "join ChiTietSP c on ct.IdChiTietSP = c.id where k.id = ?");
            pre.setString(1, idkh.getId());
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                GioHang g = new GioHang(re.getString(12), re.getString(15), re.getString(19), re.getString(20), re.getString(21),
                        getDate(re.getString(16)), getDate(re.getString(17)), re.getString(18),
                        new KhachHang(re.getString(1), re.getString(2), re.getString(3), re.getString(7),
                                re.getString(8), getDate(re.getString(6))));
                gioHangList.add(new ChiTietGioHang(re.getInt("soluong"), re.getDouble("dongia"), re.getDouble("dongiakhigiam"),
                        g, getCTID(re.getString(28))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gioHangList;
    }

    @Override
    public int addHoaDon() {
        KhachHang kh = idkh;
        idHoaDon = String.valueOf(new Random().nextLong(100000));
        checkGioHang = DBConnection.ExcuteDungna("Insert into hoadon(id, IdKH, Ma, NgayTao, ngaythanhtoan,TenNguoiNhan, DiaChi,Sdt) values"
                + " (newid(), ?,?,?,?,?,?,?)",
                new Object[]{
                    kh.getId(), idHoaDon, new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime()),
                    kh.getTen(), kh.getDiaChi(), kh.getSdt()
                });
        return checkGioHang;
    }

    @Override
    public int addGH() {
        KhachHang g = idkh;
        checkGioHang = DBConnection.ExcuteDungna("update giohang set ngaytao = ?, ngaythanhtoan = ?, tennguoinhan= ?, diachi = ?, sdt = ?, tinhtrang = ? where id = ? ",
                new Object[]{
                    new Date(new java.util.Date().getTime()),
                    new Date(new java.util.Date().getTime()),
                    g.getTen(),
                    g.getDiaChi(),
                    g.getSdt(),
                    0, timID(g.getMa())
                });
        return checkGioHang;
    }

    private HoaDon getIDHoaDonTheoMa(String ma) {
        for (HoaDon object : getHoaDon("")) {
            if (object.getMa().equalsIgnoreCase(ma)) {
                System.out.println("id: " + object.getId());
                return object;
            }
        }
        return null;
    }

    @Override
    public List<HoaDon> getHoaDon(String ma) {
        List<HoaDon> listHD = new ArrayList<>();
        try {
            String sql = "select * from hoadon g " + ma;
            System.out.println("sql: " + sql);
            ResultSet re = DBConnection.openDbConnection().prepareStatement(sql).executeQuery();
            while (re.next()) {
                listHD.add(new HoaDon(re.getString("id"), re.getString("ma"),
                        re.getString("tennguoinhan"), re.getString("diachi"),
                        re.getString("sdt"), getDate(re.getString("ngaytao")),
                        getDate(re.getString("ngaythanhtoan")),
                        null, null,
                        re.getInt("tinhtrang"), idkh, null));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listHD;
    }

    @Override
    public List<Object> getGH() {
        List<Object> g = new ArrayList<>();
        try {
            ResultSet re = DBConnection.openDbConnection().prepareStatement("select * from giohang g join khachhang k on g.idkh = k.id").executeQuery();
            while (re.next()) {
                g.add(new GioHang(re.getString(1), re.getString(4),
                        re.getString(8),
                        re.getString(9), re.getString("TinhTrang"),
                        new KhachHang(re.getString(11), re.getString(12), re.getString(13),
                                re.getString(17), re.getString(18),
                                getDate(re.getString(16)))));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    public void getIDkhachHang(String ma) {
        idkh = reskhachhang.findNV(ma);
    }

    public void getChiTietSP(String ma) {
        tenSp = this.resCtSp.findNV(ma).getId();
    }

    private String getIDHoaDon(String ma) {
        System.out.println("ma kh trong resgiohang: " + ma);
        for (Object object : getGH()) {
            if (((GioHang) object).getKh().getId().equalsIgnoreCase(ma)) {
                System.out.println(((GioHang) object).getId());
                return ((GioHang) object).getId();
            }
        }
        return null;
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

    public ChiTietSanPham getCT(String id) {
        for (ChiTietSanPham object : this.resCtSp.getAllNhanVien()) {
            if (object.getSp().getMa().equalsIgnoreCase(id)) {
                return (ChiTietSanPham) object;
            }
        }
        return null;
    }

    private void addChiTietHoaDon() {
        HoaDon d = getIDHoaDonTheoMa(idHoaDon);
        for (Object object : getAllNhanVien()) {
            DBConnection.ExcuteDungna("insert into hoadonchitiet (idhoadon, idchitietsp, soluong, dongia) values(?,?,?,?)",
                    new Object[]{d.getId(), ((ChiTietGioHang) object).getCt().getId(), ((ChiTietGioHang) object).getSl(),
                        (((ChiTietGioHang) object).getDonGia() * ((ChiTietGioHang) object).getSl())});
        }
    }

    public ChiTietSanPham getCTID(String id) {
        for (ChiTietSanPham object : this.resCtSp.getAllNhanVien()) {
            if (object.getSp().getId().equalsIgnoreCase(id)) {
                return (ChiTietSanPham) object;
            }
        }
        return null;
    }

    public void addCTHD() {
        addChiTietHoaDon();
    }

    public List<HoaDonChiTiet> getAllCTSanPham(String dk) {
        List<HoaDonChiTiet> listHoaDonChiTiets = new ArrayList<>();
        Date d ;
        if (dk.contains("'null'")) {
            dk = "";
        }
        String sql = "select * from hoadon g join hoadonchitiet c on g.id = c.idhoadon join ChiTietSP p on p.Id = c.IdChiTietSP " + dk;
        System.out.println("sql trong getall: " + sql);
        try {
            ResultSet re = DBConnection.openDbConnection().prepareStatement(sql).executeQuery();
            while (re.next()) {
                if (re.getString("ngaynhan") == null) {
                    d = null;
                }else d = getDate(re.getString("ngaynhan"));
                listHoaDonChiTiets.add(new HoaDonChiTiet(
                        new HoaDon(re.getString(10), re.getString(11), re.getString(12),
                                d, re.getInt("tinhtrang")), 
                        this.resCtSp.finCTSP(re.getString(17)), re.getInt("soluong"), re.getDouble("dongia")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listHoaDonChiTiets;
    }
}
