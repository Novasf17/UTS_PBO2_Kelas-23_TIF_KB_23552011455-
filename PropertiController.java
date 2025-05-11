/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Neng Nova Siti F
 */
import java.sql.*;
import java.util.ArrayList;

public class PropertiController {
    public static ArrayList<Properti> getAllProperti() {
        ArrayList<Properti> list = new ArrayList<>();
        Connection conn = DBConnect.connect();
        try {
            String sql = "SELECT * FROM properti";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String jenis = rs.getString("jenis");
                String alamat = rs.getString("alamat");
                double harga = rs.getDouble("harga_sewa");
                Properti p = jenis.equals("Rumah") ? new Rumah(alamat, harga) : new Apartemen(alamat, harga);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
}
