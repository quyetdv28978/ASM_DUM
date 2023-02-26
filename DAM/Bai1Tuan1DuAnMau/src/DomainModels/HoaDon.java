/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.sql.Date;

/**
 *
 * @author yugip
 */
public class HoaDon {

    private String id;
    private String ma, tenNguoiNhan, DiaChi, sdt;
    private Date ngayTao, ngayThanhToan, ngayShip, ngayNhan;
    private int trangThai;
    private KhachHang kh;
    private NhanVien nv;

    public HoaDon() {
    }

    public HoaDon(String tenNguoiNhan, String DiaChi, String sdt, Date ngayNhan, int trangThai) {
        this.tenNguoiNhan = tenNguoiNhan;
        this.DiaChi = DiaChi;
        this.sdt = sdt;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, String ma, String tenNguoiNhan, String DiaChi, String sdt, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int trangThai, KhachHang kh, NhanVien nv) {
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

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", ma=" + ma + ", tenNguoiNhan=" + tenNguoiNhan + ", DiaChi=" + DiaChi + ", sdt=" + sdt + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", ngayShip=" + ngayShip + ", ngayNhan=" + ngayNhan + ", trangThai=" + trangThai + ", kh=" + kh + ", nv=" + nv + '}';
    }

}
