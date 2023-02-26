/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import Responsitoties.KhachHangRes;
import Utilities.DBConnection;
import ViewModels.HoaDonView;
import ViewModels.KhachHangView;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class KhachHangSer implements DUMService<KhachHangView> {

    private final KhachHangRes res = new KhachHangRes();

    @Override
    public int addNV(KhachHangView nv) {
        KhachHangView kh = (KhachHangView) nv;
        KhachHang kh1 = new KhachHang(kh.getMa(), kh.getTen(), kh.getSdt(), kh.getDiachi(), kh.getNgS());
        return this.res.addNV(kh1);
    }

    @Override
    public KhachHangView findNV(String ma) {
        KhachHang kh = this.res.findNV(ma);
        return new KhachHangView(kh.getMa(), kh.getTen(), kh.getDiaChi(), kh.getSdt(), kh.getNgaySinh());
    }

    @Override
    public String timID(String ma) {
        return this.res.timID(ma);
    }

    @Override
    public int updateNhanVien(KhachHangView l, String ma) {
        KhachHangView khv = (KhachHangView) l;
        KhachHang kh = new KhachHang(khv.getTen(), khv.getSdt(), khv.getDiachi(), khv.getNgS());
        return this.res.updateNhanVien(kh, ma);
    }

    @Override
    public int deleteNhanVien(String ma) {
        return this.res.deleteNhanVien(ma);
    }

    @Override
    public List<KhachHangView> getAllNhanVien() {
        List<KhachHangView> listKH = new ArrayList<>();
        for (KhachHang object : this.res.getAllNhanVien()) {
            listKH.add(new KhachHangView(object.getMa(), object.getTen(),
                    object.getDiaChi(), object.getSdt(), object.getNgaySinh()));
        }
        return listKH;
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

    public List<HoaDonView> getAllDons() {
        Date a, b;
        List<HoaDonView> lHoadon = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            PreparedStatement pre = con.prepareStatement("select * from khachhang k join hoadon d on k.id = d.idkh");
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                if (re.getString("ngayship") == null) {
                    a = null;
                    b = null;
                } else {
                    a = getDate(re.getString("ngayship"));
                    b = getDate(re.getString("ngaynhan"));
                }
                lHoadon.add(new HoaDonView(re.getString(12), re.getString(15), re.getString(21), re.getString(22),
                        re.getString(23), getDate(re.getString(16)), getDate(re.getString("ngaythanhtoan")), a,
                        b, re.getInt(20),
                        new KhachHangView(re.getString(2), re.getString(3),
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
