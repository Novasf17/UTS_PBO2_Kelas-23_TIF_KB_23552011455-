/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Neng Nova Siti F
 */
public abstract class Aset {
    protected String alamat;
    protected double hargaSewa;

    public Aset(String alamat, double hargaSewa) {
        this.alamat = alamat;
        this.hargaSewa = hargaSewa;
    }

    public abstract double hitungPajak();

    public String getAlamat() {
        return alamat;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }
}

