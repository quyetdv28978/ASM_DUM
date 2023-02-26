/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Responsitoties.DUMinterface;
import Responsitoties.NhanVienResponsitories;
import ViewModels.ChucVuVIew;
import ViewModels.CuaHangView;
import ViewModels.NhanVienView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienSevices implements DUMinterface<NhanVienView>{
    private final serChucVu serchuVu = new serChucVu();
    private final CuaHangSer sercuahang = new CuaHangSer();
    public final NhanVienResponsitories nhanVienResponsitories = new NhanVienResponsitories();

    @Override
    public int addNV(NhanVienView nv) {
        NhanVienView nvv = (NhanVienView)nv;
        ChucVu cv = this.serchuVu.findNVM(nvv.getTenChucVu().getMa());
        CuaHang ch = this.sercuahang.findCHM(nvv.getTenDiaChi().getMa());
        NhanVien nvm = new NhanVien(nvv.getMa(), nvv.getTen(), nvv.getGioitinh(), nvv.getDiachi(), cv, ch, nvv.getNsDate());
        return this.nhanVienResponsitories.addNV(nvm);
    }

    @Override
    public NhanVienView findNV(String ma) {
        return null;
    }

    @Override
    public String timID(String ma) {
       return this.nhanVienResponsitories.timID(ma);
    }

    @Override
    public int updateNhanVien(NhanVienView l, String ma) {
        NhanVienView nvv = (NhanVienView)l;
        ChucVu cv = this.serchuVu.findNVM(nvv.getTenChucVu().getMa());
        CuaHang ch = this.sercuahang.findCHM(nvv.getTenDiaChi().getMa());
        NhanVien nv = new NhanVien(nvv.getTen(), nvv.getGioitinh(), nvv.getDiachi(), cv, ch, nvv.getNsDate());
        return this.nhanVienResponsitories.updateNhanVien(nv, ma);
    }

    @Override
    public int deleteNhanVien(String ma) {
        return this.nhanVienResponsitories.deleteNhanVien(ma);
    }

    @Override
    public List<NhanVienView> getAllNhanVien() {
        List<NhanVienView> listnvview = new ArrayList<>();
        for (NhanVien nhanVien : this.nhanVienResponsitories.getAllNhanVien()) {
            listnvview.add(new NhanVienView
        (nhanVien.getMaNV(), nhanVien.getTenNV(),
                nhanVien.isGioiTinh(), nhanVien.getDiaChi(),
                new ChucVuVIew(nhanVien.getChucVu().getMaCV(), nhanVien.getChucVu().getTenChucVu()),
                new CuaHangView(nhanVien.getCh().getMachString(), nhanVien.getCh().getTenCuaHang(), nhanVien.getCh().getDiaChiCuaHang()),
                nhanVien.getNgaString()));
        }
        return listnvview;
    }

}
