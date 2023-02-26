/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import java.sql.Date;

/**
 *
 * @author yugip
 */
public class NhanVienView {
    private String ma, ten, diachi;
    private boolean gioitinh;
    private ChucVuVIew tenChucVu;
    private CuaHangView tenDiaChi;
    private Date nsDate;

    public NhanVienView(String ma, String ten, boolean gioitinh, String diachi, ChucVuVIew tenChucVu, CuaHangView tenDiaChi, Date ns) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.tenChucVu = tenChucVu;
        this.tenDiaChi = tenDiaChi;
        this.nsDate = ns;
    }

    public NhanVienView() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public ChucVuVIew getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(ChucVuVIew tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public CuaHangView getTenDiaChi() {
        return tenDiaChi;
    }

    public void setTenDiaChi(CuaHangView tenDiaChi) {
        this.tenDiaChi = tenDiaChi;
    }

    public Date getNsDate() {
        return nsDate;
    }

    public void setNsDate(Date nsDate) {
        this.nsDate = nsDate;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    
    
}
