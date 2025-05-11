/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Neng Nova Siti F
 */
public class Apartemen extends Properti {
    public Apartemen(String alamat, double hargaSewa) {
        super("Apartemen", alamat, hargaSewa);
    }

    @Override
    public double hitungPajak() {
        return hargaSewa * 0.12;
    }
}
