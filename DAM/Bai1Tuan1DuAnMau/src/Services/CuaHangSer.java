/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.CuaHang;
import Responsitoties.CuaHangRes;
import ViewModels.CuaHangView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class CuaHangSer implements DUMService<CuaHangView>{
    private final CuaHangRes chres = new CuaHangRes();

    @Override
    public int addNV(CuaHangView nv) {
        CuaHangView hv = (CuaHangView)nv;
        CuaHang ch = new CuaHang(hv.getMa(), hv.getTen(), hv.getDiachi());
        return this.chres.addNV(ch);
    }

    @Override
    public CuaHangView findNV(String ma) {
        CuaHang c = this.chres.findNV(ma);
        return new CuaHangView(c.getMachString(), c.getTenCuaHang(), c.getDiaChiCuaHang());
    }

    @Override
    public int updateNhanVien(CuaHangView ch , String l) {
        CuaHangView nv = (CuaHangView)ch;
        return this.chres.updateNhanVien(new CuaHang(nv.getMa(), nv.getTen(), nv.getDiachi()), l);
    }

    @Override
    public int deleteNhanVien(String o) {
        return this.chres.deleteNhanVien(o);
    }

    @Override
    public List<CuaHangView> getAllNhanVien() {
        List<CuaHangView> listCH = new ArrayList<>();
        for (CuaHang cuaHangView : this.chres.getAllNhanVien()) {
            listCH.add(new CuaHangView(cuaHangView.getMachString(), cuaHangView.getTenCuaHang(), cuaHangView.getDiaChiCuaHang()));
        }
        return listCH;
    }

    @Override
    public String timID(String ma) {
        return this.chres.timID(ma);
    }
    
     public CuaHang findCHM(String ma) {
         return this.chres.findNV(ma);
     }
}
