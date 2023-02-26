/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.CuaHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Utilities.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class CuaHangRes implements DUMinterface<CuaHang> {

    private int checkThem;

    @Override
    public int addNV(CuaHang nv) {
        try {
            CuaHang ch = (CuaHang) nv;
            Connection con = DBConnection.openDbConnection();
            checkThem = DBConnection.ExcuteDungna("insert into cuahang(id, ma,ten,diachi) values (newid(),?,?,?)",
                    new Object[]{ch.getMachString(), ch.getTenCuaHang(), ch.getDiaChiCuaHang()});
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return checkThem;
    }

    @Override
    public CuaHang findNV(String ma) {
        for (Object object : getAllNhanVien()) {
            if (ma.equalsIgnoreCase(((CuaHang) object).getMachString())) {
                return (CuaHang)object;
            }
        }
        return null;
    }

    @Override
    public int updateNhanVien(CuaHang l, String ma) {
        System.out.println("ma :" + ma);
        try {
            CuaHang ch = (CuaHang) l;
            checkThem = DBConnection.ExcuteDungna("Update cuahang set ma = ?, ten= ?, diachi = ? where id = ? ", new Object[]{
                ch.getMachString(), ch.getTenCuaHang(), ch.getDiaChiCuaHang(), ma
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkThem;
    }

    @Override
    public int deleteNhanVien(String o) {
        int checkDelete = 0;
        checkDelete = DBConnection.ExcuteDungna("delete from cuahang where id = ?", new Object[]{
            o
        });
        return checkDelete;
    }

    @Override
    public List<CuaHang> getAllNhanVien() {
        List<CuaHang> cuahanglistList = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            PreparedStatement pre = con.prepareStatement("select * from cuahang");
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                cuahanglistList.add(new CuaHang(re.getString("id"), re.getString("ma"), re.getString("ten"), re.getString("DiaChi"),
                        re.getString("ThanhPho"), re.getString("QuocGia")));
            }
            con.close();
            return cuahanglistList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String timID(String ma) {
        for (CuaHang object : getAllNhanVien()) {
            if (ma.equalsIgnoreCase(((CuaHang) object).getMachString())) {
                return object.getIdUuid();
            }
        }
        return null;
    }

}
