/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.sql.Date;

/**
 *
 * @author yugip
 */
public class GioHangView {

    private String ma, diachi, sdt, tinhTrang, tenNguoiNhan;
    private Date ngayTao, ngayThanhToan;
    private KhachHangView kh;

    public GioHangView() {
    }

    public GioHangView(String ma, String diachi, String sdt, String tinhTrang, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan) {
        this.ma = ma;
        this.diachi = diachi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public GioHangView(String ma, String diachi, String sdt, String tinhTrang, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, KhachHangView kh) {
        this.ma = ma;
        this.diachi = diachi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.kh = kh;
    }

    
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
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

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public KhachHangView getKh() {
        return kh;
    }

    public void setKh(KhachHangView kh) {
        this.kh = kh;
    }
}
