/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitoties;

import DomainModels.ChucVu;
import Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class resChucVuj implements DUMinterface<ChucVu> {
private int checkCV;
    @Override
    public int addNV(ChucVu nv) {
        ChucVu cv = (ChucVu)nv;
        try {
            checkCV = DBConnection.ExcuteDungna("insert into chucvu values(newid(), ?,?)", new Object[]{
                cv.getMaCV(), cv.getTenChucVu()
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkCV;
    }

    @Override
    public ChucVu findNV(String ma) {
        for (ChucVu chucVu : getAllNhanVien()) {
            if (chucVu.getMaCV().equalsIgnoreCase(ma)) {
                return chucVu;
            }
        }
        return null;
    }

    @Override
    public String timID(String ma) {
         for (ChucVu chucVu : getAllNhanVien()) {
            if (chucVu.getMaCV().equalsIgnoreCase(ma)) {
                System.out.println(chucVu.getIdUuid());
                return chucVu.getIdUuid();
            }
        }
        return null;
    }

    @Override
    public int updateNhanVien(ChucVu l, String ma) {
        ChucVu cv = (ChucVu)l;
        try {
            checkCV = DBConnection.ExcuteDungna("update chucvu set ma = ?, ten = ? where id = ?", new Object[]{
                cv.getMaCV(), cv.getTenChucVu(), ma
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkCV;
    }

    @Override
    public int deleteNhanVien(String ma) {
        try {
           checkCV = DBConnection.ExcuteDungna("delete from chucvu where id = ?", new Object[]{
               ma
           });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkCV;
    }

    @Override
    public List<ChucVu> getAllNhanVien() {
        List<ChucVu> lcv = new ArrayList<>();
        try {
            Connection con = DBConnection.openDbConnection();
            PreparedStatement pre = con.prepareStatement("select * from chucvu");
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                lcv.add(new ChucVu(resultSet.getString("id"), resultSet.getString("ma"), resultSet.getString("ten")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lcv;
    }

}
