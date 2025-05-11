/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Neng Nova Siti F
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection connect() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/kasir_properti", "root", ""
            );
        } catch (SQLException e) {
            System.out.println("Gagal konek: " + e.getMessage());
            return null;
        }
    }
    String url = "jdbc:mysql://localhost:3307/kasir_properti";
String user = "root";
String password = ""; // kosongkan saja

}


