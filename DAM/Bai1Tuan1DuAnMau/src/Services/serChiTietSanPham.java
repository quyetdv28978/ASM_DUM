/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChiTietSanPham;
import DomainModels.DongSanXuat;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Responsitoties.ResChiTietSanPham;
import ViewModels.ChiTietSPView;
import ViewModels.DongSanXuatView;
import ViewModels.MauSacView;
import ViewModels.NhaSanXuatView;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yugip
 */
public class serChiTietSanPham implements DUMService<ChiTietSPView> {

    private final ResChiTietSanPham ct = new ResChiTietSanPham();

    @Override
    public int addNV(ChiTietSPView nv) {
        ChiTietSPView view = (ChiTietSPView) nv;
        ChiTietSanPham ct1 = new ChiTietSanPham(view.getNamBH(), view.getMota(), view.getSoLuongTon(),
                view.getGianhap(), view.getGiaBan(),
                new SanPham(view.getSp().getMa(), view.getSp().getTen()),
                new MauSac(view.getMs().getMa(), view.getMs().getTen()),
                new DongSanXuat(view.getDsx().getMa(), view.getDsx().getTen()),
                new NhaSanXuat(view.getNsx().getMa(), view.getNsx().getTen()));

        return this.ct.addNV(ct1);
    }

    @Override
    public ChiTietSPView findNV(String ma) {
        ChiTietSanPham cts = this.ct.findNV(ma);
        return new ChiTietSPView(cts.getId(), cts.getNamBH(), cts.getMota(), cts.getSoLuongTon(),
                cts.getGianhap(), cts.getGiaBan(),
                new SanPhamView(cts.getSp().getMa(), cts.getSp().getTen()),
                new MauSacView(cts.getMs().getMa(), cts.getMs().getTen()),
                new DongSanXuatView(cts.getDsx().getMa(), cts.getDsx().getTen()),
                new NhaSanXuatView(cts.getNsx().getMa(), cts.getNsx().getTen()));
    }

    public ChiTietSPView finChiTietSanPham(String ma) {
        ChiTietSanPham cts = this.ct.finCTSP(ma);
        return new ChiTietSPView(cts.getId(), cts.getNamBH(), cts.getMota(), cts.getSoLuongTon(),
                cts.getGianhap(), cts.getGiaBan(),
                new SanPhamView(cts.getSp().getMa(), cts.getSp().getTen()),
                new MauSacView(cts.getMs().getMa(), cts.getMs().getTen()),
                new DongSanXuatView(cts.getDsx().getMa(), cts.getDsx().getTen()),
                new NhaSanXuatView(cts.getNsx().getMa(), cts.getNsx().getTen()));
    }

    @Override
    public String timID(String ma) {
        return this.ct.timID(ma);
    }

    @Override
    public int updateNhanVien(ChiTietSPView l, String ma) {
        ChiTietSPView view = (ChiTietSPView) l;
        ChiTietSanPham ct1 = new ChiTietSanPham(view.getNamBH(), view.getMota(), view.getSoLuongTon(),
                view.getGianhap(), view.getGiaBan(),
                new SanPham(view.getSp().getMa(), view.getSp().getTen()),
                new MauSac(view.getMs().getMa(), view.getMs().getTen()),
                new DongSanXuat(view.getDsx().getMa(), view.getDsx().getTen()),
                new NhaSanXuat(view.getNsx().getMa(), view.getNsx().getTen()));
        return this.ct.updateNhanVien(ct1, ma);
    }

    @Override
    public int deleteNhanVien(String ma) {
        return this.ct.deleteNhanVien(ma);
    }

    @Override
    public List<ChiTietSPView> getAllNhanVien() {
        List<ChiTietSPView> listSp = new ArrayList<>();
        for (ChiTietSanPham chiTietSanPham : this.ct.getAllNhanVien()) {
            listSp.add(new ChiTietSPView(chiTietSanPham.getId(), chiTietSanPham.getNamBH(), chiTietSanPham.getMota(),
                    chiTietSanPham.getSoLuongTon(), chiTietSanPham.getGianhap(),
                    chiTietSanPham.getGiaBan(),
                    new SanPhamView(chiTietSanPham.getSp().getMa(), chiTietSanPham.getSp().getTen()),
                    new MauSacView(chiTietSanPham.getMs().getMa(), chiTietSanPham.getMs().getTen()),
                    new DongSanXuatView(chiTietSanPham.getDsx().getMa(), chiTietSanPham.getDsx().getTen()),
                    new NhaSanXuatView(chiTietSanPham.getNsx().getMa(), chiTietSanPham.getNsx().getTen())));
        }
        return listSp;
    }

    public String getIDNHieu(String name, String ma) {
        return this.ct.getIDNHieu(name, ma);
    }
}
