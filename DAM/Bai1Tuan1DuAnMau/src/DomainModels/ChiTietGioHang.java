/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import ViewModels.ChiTietSPView;

/**
 *
 * @author yugip
 */
public class ChiTietGioHang {
    private int sl;
    private double donGia, donGiaKhiGiam;
    private GioHang gh;
    private ChiTietSanPham ct;

    public ChiTietGioHang() {
    }

    public ChiTietGioHang(int sl, double donGia, double donGiaKhiGiam) {
        this.sl = sl;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
    
    

    public ChiTietGioHang(int sl, double donGia, double donGiaKhiGiam, GioHang gh, ChiTietSanPham ct) {
        this.sl = sl;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
        this.gh = gh;
        this.ct = ct;
    }

    public ChiTietGioHang(int sl, double donGia, double donGiaKhiGiam, ChiTietSanPham ct) {
        this.sl = sl;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
        this.ct = ct;
    }
    
    

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHang getGh() {
        return gh;
    }

    public void setGh(GioHang gh) {
        this.gh = gh;
    }

    public ChiTietSanPham getCt() {
        return ct;
    }

    public void setCt(ChiTietSanPham ct) {
        this.ct = ct;
    }
}
