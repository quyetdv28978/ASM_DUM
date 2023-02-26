/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import Responsitoties.resChucVuj;
import ViewModels.ChucVuVIew;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class serChucVu implements DUMService<ChucVuVIew> {

    private final resChucVuj res = new resChucVuj();

    @Override
    public ChucVuVIew findNV(String ma) {
        ChucVu cv = this.res.findNV(ma);
        return new ChucVuVIew(cv.getMaCV(), cv.getTenChucVu());
    }

    @Override
    public String timID(String ma) {
       return this.res.timID(ma);
    }

    @Override
    public int deleteNhanVien(String ma) {
        return this.res.deleteNhanVien(ma);
    }

    @Override
    public List<ChucVuVIew> getAllNhanVien() {
        List<ChucVuVIew> ListCVView = new ArrayList<>();
        for (ChucVu object : this.res.getAllNhanVien()) {
            ListCVView.add(new ChucVuVIew(object.getMaCV(), object.getTenChucVu()));
        }
        return ListCVView;
    }

    @Override
    public int addNV(ChucVuVIew nv) {
        ChucVu cv = new ChucVu(((ChucVuVIew) nv).getMa(), ((ChucVuVIew) nv).getTen());
        return this.res.addNV(cv);
    }

    @Override
    public int updateNhanVien(ChucVuVIew l, String ma) {
        ChucVu cv = new ChucVu(((ChucVuVIew) l).getMa(), ((ChucVuVIew) l).getTen());
        return this.res.updateNhanVien(cv, ma);
    }
    
    public ChucVu findNVM(String ma) {
        return this.res.findNV(ma);
    }

}
