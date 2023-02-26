/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author yugip
 */
public class ChiTietSanPham {

    private String id;
    private int namBH, soLuongTon;
    private String mota;
    private double gianhap, giaBan;
    private SanPham sp;
    private MauSac ms;
    private DongSanXuat dsx;
    private NhaSanXuat nsx;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String id, int namBH, String mota, int soLuongTon, double gianhap, double giaBan, SanPham sp, MauSac ms, DongSanXuat dsx, NhaSanXuat n) {
        this.id = id;
        this.namBH = namBH;
        this.mota = mota;
        this.soLuongTon = soLuongTon;
        this.gianhap = gianhap;
        this.giaBan = giaBan;
        this.sp = sp;
        this.ms = ms;
        this.dsx = dsx;
        this.nsx = n;
    }

    public ChiTietSanPham(String id, int soLuongTon, SanPham sp) {
        this.id = id;
        this.soLuongTon = soLuongTon;
        this.sp = sp;
    }

    
    
    public ChiTietSanPham(int namBH, String mota, int soLuongTon, double gianhap, double giaBan, SanPham sp, MauSac ms, DongSanXuat dsx, NhaSanXuat nsx) {
        this.namBH = namBH;
        this.mota = mota;
        this.soLuongTon = soLuongTon;
        this.gianhap = gianhap;
        this.giaBan = giaBan;
        this.sp = sp;
        this.ms = ms;
        this.dsx = dsx;
        this.nsx = nsx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGianhap() {
        return gianhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public DongSanXuat getDsx() {
        return dsx;
    }

    public void setDsx(DongSanXuat dsx) {
        this.dsx = dsx;
    }

    public NhaSanXuat getNsx() {
        return nsx;
    }

    public void setNsx(NhaSanXuat nsx) {
        this.nsx = nsx;
    }

    @Override
    public String toString() {
        return this.getSp().getTen();
    }

}
