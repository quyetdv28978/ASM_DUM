/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class NhanVien {
    private String id;
    private String maNV;
    private String tenNV;
    private boolean gioiTinh;
    private String diaChi;
    private ChucVu chucVu;
    private CuaHang ch;
    private Date ngaString;
    
    

    public NhanVien() {
    }

    public NhanVien(String tenNV, boolean gioiTinh, String diaChi, ChucVu chucVu, CuaHang ch, Date ngaString) {
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.ch = ch;
        this.ngaString = ngaString;
    }
    
    

    public NhanVien(String id, String maNV, String tenNV, boolean gioiTinh, String diaChi, ChucVu chucVu, CuaHang ch, Date ns) {
        this.id = id;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.ch = ch;
        this.ngaString = ns;
    }
    
    

    public NhanVien(String maNV, String tenNV, boolean gioiTinh, String diaChi, ChucVu chucVu, CuaHang ch, Date ngs) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.ch = ch;
        this.ngaString = ngs;
    }

    public NhanVien(String maNV, String tenNV, boolean gioiTinh, String diaChi) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

 

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public CuaHang getCh() {
        return ch;
    }

    public void setCh(CuaHang ch) {
        this.ch = ch;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public Date getNgaString() {
        return ngaString;
    }

    public void setNgaString(Date ngaString) {
        this.ngaString = ngaString;
    }

    

    @Override
    public String toString() {
        return tenNV;
                }
}
