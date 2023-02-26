/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Admin
 */
public class ChucVu {
    private String idUuid;
    private String maCV;
    private String tenChucVu;

    public ChucVu() {
    }

    public ChucVu(String maCV, String tenChucVu) {
        this.maCV = maCV;
        this.tenChucVu = tenChucVu;
    }
    
    

    public ChucVu(String idUuid,String maString,String tenChucVu) {
        this.idUuid = idUuid;
        this.tenChucVu = tenChucVu;
        this.maCV = maString;
    }

    public ChucVu(String string) {
        this.tenChucVu = string;
    }

    public String getIdUuid() {
        return idUuid;
    }

    public void setIdUuid(String idUuid) {
        this.idUuid = idUuid;
    }
    
    

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }
    
    

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    @Override
    public String toString() {
        return this.tenChucVu;
    }
    
    
}
