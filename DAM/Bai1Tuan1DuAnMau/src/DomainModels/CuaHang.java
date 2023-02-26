/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CuaHang {
    private String idUuid;
    private String machString;
    private String tenCuaHang;
    private String diaChiCuaHang, thanhPhoString, quocGia;
    public CuaHang() {
    }

    public CuaHang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
    }
    

    public CuaHang(String idUuid,String ma,String tenCuaHang, String diaChiCuaHang, String thanhPhoString, String quocGia) {
        this.idUuid =idUuid;
        this.tenCuaHang = tenCuaHang;
        this.diaChiCuaHang = diaChiCuaHang;
        this.machString = ma;
        this.thanhPhoString = thanhPhoString;
        this.quocGia = quocGia;
    }

    public CuaHang(String string, String string0) {
        this.tenCuaHang = string;
        this.diaChiCuaHang = string0;
    }

    public String getIdUuid() {
        return idUuid;
    }

    public CuaHang(String machString, String tenCuaHang, String diaChiCuaHang) {
        this.machString = machString;
        this.tenCuaHang = tenCuaHang;
        this.diaChiCuaHang = diaChiCuaHang;
    }

    public CuaHang(String idUuid, String machString, String tenCuaHang, String diaChiCuaHang) {
        this.idUuid = idUuid;
        this.machString = machString;
        this.tenCuaHang = tenCuaHang;
        this.diaChiCuaHang = diaChiCuaHang;
    }
    
    

    public void setIdUuid(String idUuid) {
        this.idUuid = idUuid;
    }

    
    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public String getMachString() {
        return machString;
    }

    public void setMachString(String machString) {
        this.machString = machString;
    }

    public void setTenCuaHang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
    }

    public String getDiaChiCuaHang() {
        return diaChiCuaHang;
    }

    public void setDiaChiCuaHang(String diaChiCuaHang) {
        this.diaChiCuaHang = diaChiCuaHang;
    }

    public String getThanhPhoString() {
        return thanhPhoString;
    }

    public void setThanhPhoString(String thanhPhoString) {
        this.thanhPhoString = thanhPhoString;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
    
    @Override
    public String toString() {
        return this.tenCuaHang;
    }
}
