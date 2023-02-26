/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungna29
 */
public class DBConnection {//Lớp này giải quyết kết nối xử lý truy vấn

    private static Connection conn;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi Driver");
        }
    }

    //1. Mở kết nối
    public static Connection openDbConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041;trustServerCertificate = true; user = sa; password = 1");
        } catch (SQLException ex) {
            return null;
        }
    }

    //2. Thực thi truy vấn Thêm, Sửa , Xoá
    public static int ExcuteDungna(String sql, Object... args) {
        PreparedStatement pstm=null;
        try {
            try {
                pstm = DBConnection.openDbConnection().prepareStatement(sql);
                for (int i = 0; i < args.length; i++) {
                    pstm.setObject(i+1, args[i]);
                }
                return pstm.executeUpdate();
            }
             finally{
                pstm.close();
            }
                
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Lỗi tại ExcuteDungna");
            return 0;
        }
    }
}
