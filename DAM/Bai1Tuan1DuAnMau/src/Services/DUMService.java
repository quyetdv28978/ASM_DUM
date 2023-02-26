/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.util.List;

/**
 *
 * @author yugip
 */
public interface DUMService<Q> {

    public int addNV(Q nv);

    public Q findNV(String ma);

    public String timID(String ma);

    public int updateNhanVien(Q l, String ma);

    public int deleteNhanVien(String ma);

    public List<Q> getAllNhanVien();
}
