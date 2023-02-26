/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author yugip
 */
public class ChiTietSPView {
       private String id;
    private int namBH,soLuongTon;
    private String  mota;
    private double gianhap, giaBan;
    private SanPhamView sp;
    private MauSacView ms;
    private DongSanXuatView dsx;
    private NhaSanXuatView nsx;

    public ChiTietSPView() {
    }

    public ChiTietSPView(String id, int namBH, String mota, int soLuongTon, double gianhap, double giaBan, SanPhamView sp, MauSacView ms, DongSanXuatView dsx, NhaSanXuatView n) {
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

    public ChiTietSPView(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public ChiTietSPView(int soLuongTon, double gianhap, double giaBan, SanPhamView sp) {
        this.soLuongTon = soLuongTon;
        this.gianhap = gianhap;
        this.giaBan = giaBan;
        this.sp = sp;
    }
    
    

    public ChiTietSPView(int namBH, String mota, int soLuongTon, double gianhap, double giaBan, SanPhamView sp, MauSacView ms, DongSanXuatView dsx, NhaSanXuatView nsx) {
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

    public SanPhamView getSp() {
        return sp;
    }

    public void setSp(SanPhamView sp) {
        this.sp = sp;
    }

    public MauSacView getMs() {
        return ms;
    }

    public void setMs(MauSacView ms) {
        this.ms = ms;
    }

    public DongSanXuatView getDsx() {
        return dsx;
    }

    public void setDsx(DongSanXuatView dsx) {
        this.dsx = dsx;
    }

    public NhaSanXuatView getNsx() {
        return nsx;
    }

    public void setNsx(NhaSanXuatView nsx) {
        this.nsx = nsx;
    }

    @Override
    public String toString() {
        return "ChiTietSanPhamView{" + "id=" + id + ", namBH=" + namBH + ", mota=" + mota + ", soLuongTon=" + soLuongTon + ", gianhap=" + gianhap + ", giaBan=" + giaBan + ", sp=" + sp + ", ms=" + ms + ", dsx=" + dsx + ", nsx=" + nsx + '}';
    }
}
