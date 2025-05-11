/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Neng Nova Siti F
 */
public class Properti extends Aset {
    protected String jenis;

    public Properti(String jenis, String alamat, double hargaSewa) {
        super(alamat, hargaSewa);
        this.jenis = jenis;
    }

    @Override
    public double hitungPajak() {
        return hargaSewa * 0.1;
    }

    public String getJenis() {
        return jenis;
    }
}

    
