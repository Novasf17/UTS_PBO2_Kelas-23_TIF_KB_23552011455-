/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Neng Nova Siti F
 */
public class Rumah extends Properti {
    public Rumah(String alamat, double hargaSewa) {
        super("Rumah", alamat, hargaSewa);
    }

    @Override
    public double hitungPajak() {
        return hargaSewa * 0.08;
    }
}
