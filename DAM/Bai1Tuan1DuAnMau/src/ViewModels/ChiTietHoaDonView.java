/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;

/**
 *
 * @author yugip
 */
public class ChiTietHoaDonView {
     private HoaDonView hd;
    private ChiTietSPView ct;
    private int sl;
    private double donGia;

    public ChiTietHoaDonView() {
    }

    public ChiTietHoaDonView(HoaDonView hd, ChiTietSPView ct, int sl, double donGia) {
        this.hd = hd;
        this.ct = ct;
        this.sl = sl;
        this.donGia = donGia;
    }

    

    public HoaDonView getHd() {
        return hd;
    }

    public void setHd(HoaDonView hd) {
        this.hd = hd;
    }

    public ChiTietSPView getCt() {
        return ct;
    }

    public void setCt(ChiTietSPView ct) {
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
