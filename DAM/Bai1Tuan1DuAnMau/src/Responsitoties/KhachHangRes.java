/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.GioHang;
import DomainModels.HoaDon;
import DomainModels.KhachHang;
import Utilities.DBConnection;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author yugip
 */
public class KhachHangRes implements DUMinterface<KhachHang> {

    private int checkKh;

    @Override
    public int addNV(KhachHang nv) {
        KhachHang kh = (KhachHang) nv;
        try {
            checkKh = DBConnection.ExcuteDungna("insert into khachhang(id, ma, ten, ngaysinh, diachi, sdt) values (newid(), ?,?,?,?,?)",
                    new Object[]{
                        kh.getMa(), kh.getTen(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSdt()
                    }
            );
            checkKh = DBConnection.ExcuteDungna("insert into giohang(id, idkh, ma) values(newid(), ?, ?)",
                    new Object[]{timID(kh.getMa()), new Random().nextLong(100000)});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkKh;
    }

    @Override
    public KhachHang findNV(String ma) {
        for (KhachHang object : getAllNhanVien()) {
            if (ma.equals(((KhachHang) object).getMa())) {
                return object;
            }
        }
        return null;
    }

    @Override
    public String timID(String ma) {
        for (KhachHang khachHang : getAllNhanVien()) {
            if (khachHang.getMa().equalsIgnoreCase(ma)) {
                return khachHang.getId();
            }
        }
        return null;
    }

    @Override
    public int updateNhanVien(KhachHang l, String ma) {
        KhachHang kh = (KhachHang) l;
        try {
            checkKh = DBConnection.ExcuteDungna("Update khachhang set ten = ?, diachi = ?, ngaysinh = ?, sdt = ? where id = ?",
                    new Object[]{
                        kh.getTen(), kh.getDiaChi(), kh.getNgaySinh(), kh.getSdt(), ma
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkKh;
    }

    @Override
    public int deleteNhanVien(String ma) {
        try {
            checkKh = DBConnection.ExcuteDungna("delete from khachhang where id = ?", new Object[]{ma});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkKh;
    }

    @Override
    public List<KhachHang> getAllNhanVien() {
        List<KhachHang> cuahanglistList = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            PreparedStatement pre = con.prepareStatement("select * from khachhang");
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                if (re.getString("ngaysinh") != null) {
                    cuahanglistList.add(new KhachHang(
                            re.getString("id"),
                            re.getString("Ma"),
                            re.getString("ten"),
                            re.getString("sdt"),
                            re.getString("diachi"),
                            Date.valueOf(re.getString("ngaysinh"))));
                }

            }
            con.close();
            return cuahanglistList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKHID(String id) {
        for (KhachHang object : getAllNhanVien()) {
            if (id.equals(((KhachHang) object).getId())) {
                return object;
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

    public List<HoaDon> getAllDons() {
        List<HoaDon> lHoadon = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            PreparedStatement pre = con.prepareStatement("select * from khachhang k join hoadon d on k.id = d.idkh");
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                lHoadon.add(new HoaDon(re.getString(12), re.getString(15), re.getString(21), re.getString(22),
                        re.getString(23), getDate(re.getString(16)), getDate(re.getString("ngaythanhtoan")), getDate(re.getString("ngayship")),
                        getDate(re.getString("ngaynhan")), re.getInt(20),
                        new KhachHang(re.getString(1), re.getString(2), re.getString(3),
                                re.getString(7), re.getString(8),
                                getDate(re.getString(6))
                        ), null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lHoadon;
    }
}
