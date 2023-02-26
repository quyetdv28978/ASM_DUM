/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class NhanVienResponsitories implements DUMinterface<NhanVien> {

    private int checkNV;

    @Override
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> lis = new ArrayList<>();
        try {
            Connection c = DBConnection.openDbConnection();
            String sql = "select NhanVien.Ma, NhanVien.Ten, NhanVien.GioiTinh, NhanVien.DiaChi,chucvu.ma, ChucVu.Ten,cuahang.ma, CuaHang.Ten, CuaHang.DiaChi,nhanvien.id, cuahang.id, chucvu.id, nhanvien.ngaysinh from ChucVu join NhanVien \n"
                    + "on ChucVu.Id = NhanVien.IdCV\n"
                    + "join CuaHang\n"
                    + "on NhanVien.IdCH = CuaHang.Id";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(13) != null) {
                    CuaHang ch = new CuaHang(rs.getString(11), rs.getString(7), rs.getString(8), rs.getString(9));
                    ChucVu cv = new ChucVu(rs.getString(12), rs.getString(5), rs.getString(6));
                    lis.add(new NhanVien(rs.getString(10), rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), cv, ch, Date.valueOf(rs.getString(13))));
                }
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lis;
    }

    @Override
    public int deleteNhanVien(String chuc) {
        try {
            String ch = "delete from nhanvien where id = ?";
            checkNV = DBConnection.ExcuteDungna(ch, new Object[]{
                chuc});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkNV;
    }

    @Override
    public int updateNhanVien(NhanVien l, String ma) {
        NhanVien nv = (NhanVien) l;
        try {
            updateNhieu(nv.getChucVu(), nv.getCh());
            
            String sql = "update NhanVien set ngaysinh =?, Ten = ?, GioiTinh = ?, DiaChi = ?, idch = ?, idcv = ? where id = ?";
            checkNV = DBConnection.ExcuteDungna(sql, new Object[]{
                nv.getNgaString(), nv.getTenNV(), nv.isGioiTinh(), nv.getDiaChi(), ((CuaHang)nv.getCh()).getIdUuid(), ((ChucVu)nv.getChucVu()).getIdUuid(), ma
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkNV;
    }

    @Override
    public int addNV(NhanVien nvV) {
        NhanVien nv = (NhanVien) nvV;
        try {
            String sql = "insert into NhanVien(id,ma, ten ,gioitinh, diachi, idch, idcv, ngaysinh) values(NEWID(),?,?,?,?,?,?,?)";
            checkNV = DBConnection.ExcuteDungna(sql, new Object[]{
                nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh(), nv.getDiaChi(), ((CuaHang) nv.getCh()).getIdUuid(), ((ChucVu) nv.getChucVu()).getIdUuid(), nv.getNgaString()
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkNV;
    }

    @Override
    public NhanVien findNV(String ma) {
        for (NhanVien nhanVien : getAllNhanVien()) {
            if (nhanVien.getId().equalsIgnoreCase(ma)) {
                return nhanVien;
            }
        }
        return null;
    }

    @Override
    public String timID(String ma) {
        for (NhanVien nhanVien : getAllNhanVien()) {
            if (nhanVien.getMaNV().equalsIgnoreCase(ma)) {
                return nhanVien.getId();
            }
        }
        return null;
    }
    
    private int updateNhieu(ChucVu cd, CuaHang ch){
        checkNV = DBConnection.ExcuteDungna("update cuahang set ma = ?, ten= ? , diachi = ? where id = ?",
                ch.getMachString(), ch.getTenCuaHang(), ch.getDiaChiCuaHang(), ch.getIdUuid());
        checkNV = DBConnection.ExcuteDungna("update chucvu set ma = ?, ten = ? where id = ?",
                cd.getMaCV(), cd.getTenChucVu(), cd.getIdUuid());
        return checkNV;
    }
}
