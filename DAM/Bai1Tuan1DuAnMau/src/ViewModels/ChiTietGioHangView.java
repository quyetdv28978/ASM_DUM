/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;


/**
 *
 * @author yugip
 */public class ChiTietGioHangView{
     private int sl;
    private double donGia, donGiaKhiGiam;
    private GioHangView gh;
    private ChiTietSPView ct;

    public ChiTietGioHangView() {
    }

    public ChiTietGioHangView(int sl, double donGia, double donGiaKhiGiam, GioHangView gh, ChiTietSPView ct) {
        this.sl = sl;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
        this.gh = gh;
        this.ct = ct;
    }

    public ChiTietGioHangView(int sl, double donGia, double donGiaKhiGiam) {
        this.sl = sl;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public ChiTietGioHangView(int sl, double donGia, double donGiaKhiGiam, ChiTietSPView ct) {
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

    public GioHangView getGh() {
        return gh;
    }

    public void setGh(GioHangView gh) {
        this.gh = gh;
    }

    public ChiTietSPView getCt() {
        return ct;
    }

    public void setCt(ChiTietSPView ct) {
        this.ct = ct;
    }
}
