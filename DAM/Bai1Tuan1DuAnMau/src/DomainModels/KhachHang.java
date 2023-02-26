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
public class KhachHang {
    private String id,Ma, Ten, Sdt, DiaChi;
    private Date ngaySinh;

    public KhachHang() {
    }

    public KhachHang(String id, String Ma, String Ten, String Sdt, String DiaChi, Date ngaySinh) {
        this.id = id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.ngaySinh = ngaySinh;
    }

    public KhachHang(String Ten, String Sdt, String DiaChi, Date ngaySinh) {
        this.Ten = Ten;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.ngaySinh = ngaySinh;
    }
    
    

    public KhachHang(String ma,String Ten, String Sdt, String DiaChi, Date ngaySinh) {
        this.Ma = ma;
        this.Ten = Ten;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.ngaySinh = ngaySinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return Ten;
    }
    
    
}
