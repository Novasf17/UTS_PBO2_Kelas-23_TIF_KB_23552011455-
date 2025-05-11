/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Neng Nova Siti F
 */
public class Transaksi {
    private int id;
    private Properti properti;
    private Penyewa penyewa;
    private int durasi;
    private double total;

    public Transaksi(int id, Properti properti, Penyewa penyewa, int durasi) {
        this.id = id;
        this.properti = properti;
        this.penyewa = penyewa;
        this.durasi = durasi;
        this.total = properti.getHargaSewa() * durasi;
    }

    public int getId() { return id; }
    public Properti getProperti() { return properti; }
    public Penyewa getPenyewa() { return penyewa; }
    public int getDurasi() { return durasi; }
    public double getTotal() { return total; }
}

