/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Set;

/**
 *
 * @author yugip
 */
public class HoaDonChiTiet {
    private HoaDon hd;
    private ChiTietSanPham ct;
    private int sl;
    private double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon hd, ChiTietSanPham ct, int sl, double donGia) {
        this.hd = hd;
        this.ct = ct;
        this.sl = sl;
        this.donGia = donGia;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public ChiTietSanPham getCt() {
        return ct;
    }

    public void setCt(ChiTietSanPham ct) {
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
}
