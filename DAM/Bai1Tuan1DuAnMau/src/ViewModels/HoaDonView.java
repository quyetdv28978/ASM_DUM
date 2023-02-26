/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.NhanVien;
import java.sql.Date;

/**
 *
 * @author yugip
 */
public class HoaDonView {
    private String id;
    private String ma, tenNguoiNhan, DiaChi, sdt;
    private Date ngayTao, ngayThanhToan, ngayShip, ngayNhan;
    private int trangThai;
    private KhachHangView kh;
    private NhanVienView nv;

    public HoaDonView() {
    }

    public HoaDonView(String tenNguoiNhan, String DiaChi, String sdt, Date ngayNhan, int trangThai) {
        this.tenNguoiNhan = tenNguoiNhan;
        this.DiaChi = DiaChi;
        this.sdt = sdt;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
    }

    
    
    public HoaDonView(String id, String ma, String tenNguoiNhan, String DiaChi, String sdt, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int trangThai, KhachHangView kh, NhanVienView nv) {
        this.id = id;
        this.ma = ma;
        this.tenNguoiNhan = tenNguoiNhan;
        this.DiaChi = DiaChi;
        this.sdt = sdt;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
        this.kh = kh;
        this.nv = nv;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHangView getKh() {
        return kh;
    }

    public void setKh(KhachHangView kh) {
        this.kh = kh;
    }

    public NhanVienView getNv() {
        return nv;
    }

    public void setNv(NhanVienView nv) {
        this.nv = nv;
    }

    @Override
    public String toString() {
        return ma;
    }
    
    
}
