/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField tfAlamat, tfHarga;
    private JComboBox<String> cbJenis;

    public MainFrame() {
        setTitle("Aplikasi Kasir Properti");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // === Tabel ===
        model = new DefaultTableModel();
        model.addColumn("Jenis");
        model.addColumn("Alamat");
        model.addColumn("Harga Sewa");
        model.addColumn("Pajak");
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // === Form Tambah Properti ===
        JPanel formPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        cbJenis = new JComboBox<>(new String[] { "Rumah", "Apartemen" });
        tfAlamat = new JTextField();
        tfHarga = new JTextField();
        JButton btnTambah = new JButton("Tambah Properti");

        formPanel.add(new JLabel("Jenis"));
        formPanel.add(new JLabel("Alamat"));
        formPanel.add(new JLabel("Harga Sewa"));
        formPanel.add(new JLabel(""));

        formPanel.add(cbJenis);
        formPanel.add(tfAlamat);
        formPanel.add(tfHarga);
        formPanel.add(btnTambah);

        add(formPanel, BorderLayout.SOUTH);

        // === Event Tambah Data ===
        btnTambah.addActionListener(e -> tambahProperti());

        // Tampilkan data awal
        tampilkanProperti();
    }

    private void tampilkanProperti() {
        model.setRowCount(0); // clear table
        ArrayList<Properti> data = PropertiController.getAllProperti();
        for (Properti p : data) {
            model.addRow(new Object[] {
                p.getJenis(), p.getAlamat(), p.getHargaSewa(), p.hitungPajak()
            });
        }
    }

    private void tambahProperti() {
        String jenis = cbJenis.getSelectedItem().toString();
        String alamat = tfAlamat.getText();
        double harga;

        try {
            harga = Double.parseDouble(tfHarga.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga harus berupa angka!");
            return;
        }

        try (Connection conn = DBConnect.connect()) {
            String sql = "INSERT INTO properti (jenis, alamat, harga_sewa) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jenis);
            ps.setString(2, alamat);
            ps.setDouble(3, harga);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Properti berhasil ditambahkan!");
            tampilkanProperti();

            tfAlamat.setText("");
            tfHarga.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}

