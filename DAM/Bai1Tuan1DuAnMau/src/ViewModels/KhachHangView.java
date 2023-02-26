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
public class KhachHangView {
    private String ma, ten, diachi, sdt;
    private Date ngS;

    public KhachHangView() {
    }

    public KhachHangView(String ten, String diachi, String sdt, Date ngS) {
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngS = ngS;
    }
    
    

    public KhachHangView(String ma, String ten, String diachi, String sdt, Date ngS) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngS = ngS;
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

    public Date getNgS() {
        return ngS;
    }

    public void setNgS(Date ngS) {
        this.ngS = ngS;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    
}
