/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.ChiTietSanPham;
import DomainModels.DongSanXuat;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import java.sql.*;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class ResChiTietSanPham implements DUMinterface<ChiTietSanPham> {

    private int checkChiTiet;

    @Override
    public int addNV(ChiTietSanPham nv) {
        ChiTietSanPham ct = (ChiTietSanPham) nv;
        SanPham s = ((ChiTietSanPham) nv).getSp();
        MauSac m = ((ChiTietSanPham) nv).getMs();
        DongSanXuat d = ((ChiTietSanPham) nv).getDsx();
        NhaSanXuat n = ((ChiTietSanPham) nv).getNsx();
        try {
            checkChiTiet = addNhieu(s, "SanPham", new Object[]{s.getMa(), s.getTen()});
            checkChiTiet = addNhieu(s, "mauSac", new Object[]{m.getMa(), m.getTen()});
            checkChiTiet = addNhieu(s, "DongSp", new Object[]{d.getMa(), d.getTen()});
            checkChiTiet = addNhieu(s, "NSX", new Object[]{n.getMa(), n.getTen()});
            s.setId(getIDNHieu("Sanpham", s.getMa()));
            m.setId(getIDNHieu("mauSac", m.getMa()));
            d.setId(getIDNHieu("DongSp", d.getMa()));
            n.setId(getIDNHieu("NSX", n.getMa()));
            System.out.println("dong san pham trong chitietsanpham: " + d.getId());
            checkChiTiet = DBConnection.ExcuteDungna("insert into chitietsp(id, IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) values"
                    + "(newid(),?,?,?,?,?,?,?,?,?)",
                    new Object[]{s.getId(), n.getId(), m.getId(), d.getId(), ct.getNamBH(), ct.getMota(), ct.getSoLuongTon(), ct.getGianhap(), ct.getGiaBan()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkChiTiet;
    }

    @Override
    public ChiTietSanPham findNV(String ma) {
        for (ChiTietSanPham object : getAllNhanVien()) {
            if (((ChiTietSanPham) object).getSp().getTen().equalsIgnoreCase(ma)) {
               return object;
            }
        }
        return null;
    }
    
     public ChiTietSanPham finCTSP(String ma) {
        for (ChiTietSanPham object : getAllNhanVien()) {
            if (((ChiTietSanPham) object).getId().equalsIgnoreCase(ma)) {
               return object;
            }
        }
        return null;
    }

    @Override
    public String timID(String ma) {
        for (ChiTietSanPham object : getAllNhanVien()) {
            if (object.getSp().getTen().equalsIgnoreCase(ma)) {
                return object.getSp().getId();
            }
        }
        return null;
    }

    @Override
    public int updateNhanVien(ChiTietSanPham nv, String ma) {
        ChiTietSanPham ct = (ChiTietSanPham) nv;
        SanPham s = ((ChiTietSanPham) nv).getSp();
        MauSac m = ((ChiTietSanPham) nv).getMs();
        DongSanXuat d = ((ChiTietSanPham) nv).getDsx();
        NhaSanXuat n = ((ChiTietSanPham) nv).getNsx();

        s.setId(getIDNHieu("Sanpham", s.getMa()));
        m.setId(getIDNHieu("mauSac", m.getMa()));
        d.setId(getIDNHieu("DongSp", d.getMa()));
        n.setId(getIDNHieu("NSX", n.getMa()));
        System.out.println("id san pham trong chitietsp: " + s.getId() + " mau sac: " + m.getId() + " dong san xuat " + d.getId() + " nha san xuat " + n.getId());
        System.out.println("id cua chitietsanpham: " + ct.getId());
        try {
            checkChiTiet = updateNhieu(s, "SanPham", new Object[]{s.getTen(), s.getId()});
            System.out.println("trong ctsp update sp: " + checkChiTiet);
            checkChiTiet = updateNhieu(m, "mauSac", new Object[]{m.getTen(), m.getId()});
            System.out.println("trong ctsp update ms: " + checkChiTiet);
            checkChiTiet = updateNhieu(d, "DongSp", new Object[]{d.getTen(), d.getId()});
            System.out.println("trong ctsp update dong sp: " + checkChiTiet);
            checkChiTiet = updateNhieu(n, "NSX", new Object[]{n.getTen(), n.getId()});
            System.out.println("trong ctsp update nsx: " + checkChiTiet);
            checkChiTiet = DBConnection.ExcuteDungna("update chitietsp set NamBH = ?, MoTa=?, SoLuongTon=?, GiaNhap=?, GiaBan=? where id = ? ",
                    new Object[]{ct.getNamBH(), ct.getMota(), ct.getSoLuongTon(), ct.getGianhap(), ct.getGiaBan(), ma});
            System.out.println("trong ctsp update ctsp: " + checkChiTiet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkChiTiet;
    }

    @Override
    public int deleteNhanVien(String ma) {
        ChiTietSanPham ct = (ChiTietSanPham) findNV(ma);
        SanPham s = ((ChiTietSanPham) ct).getSp();
        MauSac m = ((ChiTietSanPham) ct).getMs();
        DongSanXuat d = ((ChiTietSanPham) ct).getDsx();
        NhaSanXuat n = ((ChiTietSanPham) ct).getNsx();
        try {
            checkChiTiet = deleteNhieu(s, "SanPham", new Object[]{s.getId()});
            System.out.println(checkChiTiet);
            checkChiTiet = deleteNhieu(m, "mauSac", new Object[]{m.getId()});
            System.out.println(checkChiTiet);
            checkChiTiet = deleteNhieu(d, "DongSp", new Object[]{d.getId()});
            System.out.println(checkChiTiet);
            checkChiTiet = deleteNhieu(n, "NSX", new Object[]{n.getId()});
            System.out.println(checkChiTiet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkChiTiet;
    }

    @Override
    public List<ChiTietSanPham> getAllNhanVien() {
        List<ChiTietSanPham> chitietsp = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            String sql = "select * from ChiTietSP ct join sanpham c on ct.IdSP = c.id"
                    + " join MauSac m on ct.IdMauSac = m.Id"
                    + " join DongSP d  on ct.IdDongSP = d.Id "
                    + "join NSX n on ct.IdNsx = n.Id";
            ResultSet re = con.prepareStatement(sql).executeQuery();
            while (re.next()) {
                chitietsp.add(new ChiTietSanPham(re.getString(1), re.getInt("NamBH"), re.getString("MoTa"),
                        re.getInt("Soluongton"), re.getDouble("GiaNhap"), re.getDouble("GiaBan"),
                        new SanPham(re.getString(11), re.getString(12), re.getString(13)),
                        new MauSac(re.getString(14), re.getString(15), re.getString(16)),
                        new DongSanXuat(re.getString(17), re.getString(18), re.getString(19)),
                        new NhaSanXuat(re.getString(20), re.getString(21), re.getString(22))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chitietsp;
    }

    public int addNhieu(Object a, String sql, Object[] ob) {
        String insert = "insert into " + sql + "(id, ma, ten) values(newid(), ?, ?)";
        if (sql.equalsIgnoreCase("SanPham")) {
            return DBConnection.ExcuteDungna(insert, ob);
        } else if (sql.equalsIgnoreCase("mauSac")) {
            return DBConnection.ExcuteDungna(insert, ob);
        } else if (sql.equalsIgnoreCase("DongSp")) {
            return DBConnection.ExcuteDungna(insert, ob);
        } else if (sql.equalsIgnoreCase("NSX")) {
            return DBConnection.ExcuteDungna(insert, ob);
        }
        return 0;
    }

    public int updateNhieu(Object aObject, String sqlString, Object[] ob) {
        String update = "update " + sqlString + " set ten = ? where id = ?";
        if (sqlString.equalsIgnoreCase("SanPham")) {
            return DBConnection.ExcuteDungna(update, ob);
        } else if (sqlString.equalsIgnoreCase("mauSac")) {
            return DBConnection.ExcuteDungna(update, ob);
        } else if (sqlString.equalsIgnoreCase("DongSp")) {
            return DBConnection.ExcuteDungna(update, ob);
        } else if (sqlString.equalsIgnoreCase("NSX")) {
            return DBConnection.ExcuteDungna(update, ob);
        }
        return 0;
    }

    public String getIDNHieu(String name, String ma) {
        try {
            PreparedStatement pre = DBConnection.openDbConnection().prepareStatement("select id from " + name + " where ma = " + ma);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                System.out.println("id getidnhieu: " + re.getString("id"));
                return re.getString("id");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int deleteNhieu(Object aObject, String sqlString, Object[] ob) {
        String delete = "delete " + sqlString + " where id = ?";
        if (sqlString.equalsIgnoreCase("SanPham")) {
            return DBConnection.ExcuteDungna(delete, ob);
        } else if (sqlString.equalsIgnoreCase("mauSac")) {
            return DBConnection.ExcuteDungna(delete, ob);
        } else if (sqlString.equalsIgnoreCase("DongSp")) {
            return DBConnection.ExcuteDungna(delete, ob);
        } else if (sqlString.equalsIgnoreCase("NSX")) {
            return DBConnection.ExcuteDungna(delete, ob);
        }
        return 0;
    }

}
