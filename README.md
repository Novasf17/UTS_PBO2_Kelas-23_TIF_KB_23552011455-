# UTS_PBO2_Kelas-23_TIF_KB_23552011455- Neng Nova Siti Fathonah
Repository untuk tugas UTS PBO2 

# Kasir Properti System

## Deskripsi

Kasir Properti System adalah aplikasi simulasi untuk mencatat dan memproses penjualan properti seperti rumah dan apartemen. Aplikasi ini dibangun dengan konsep **Object-Oriented Programming (OOP)** menggunakan bahasa **Java**.

Aplikasi ini juga dilengkapi dengan konsep abstraksi, enkapsulasi, inheritance, dan polymorphism untuk memperkuat implementasi OOP.

---

## Fitur

- Menampilkan daftar properti (rumah & apartemen)
- Mencatat transaksi penjualan properti
- Menampilkan detail transaksi
- Penerapan prinsip OOP yang kuat

---

## Konsep OOP

| Konsep        | Implementasi                                                                 |
|---------------|------------------------------------------------------------------------------|
| Abstraction   | Kelas `Property` bersifat abstrak dan tidak dapat diinstansiasi langsung     |
| Encapsulation | Atribut kelas disembunyikan dan hanya dapat diakses melalui getter/setter    |
| Inheritance   | Kelas `House` dan `Apartment` mewarisi `Property`                            |
| Polymorphism  | Method `displayInfo()` diturunkan dengan perilaku berbeda di tiap subclass   |

---

## Struktur Folder

src/
├── com/
│ └── mycompany/
│ └── kasirproperti/
│ ├── Apartemen.java
│ ├── Aset.java
│ ├── DBConnect.java
│ ├── Koneksi.java
│ ├── MainFrame.java
│ ├── Penyewa.java
│ ├── Properti.java
│ └── PropertiController.java

---

## Penerapan Konsep OOP

### 1. Inheritance (Pewarisan)
Hierarki kelas properti:
```java
// Abstract parent class
public abstract class Aset {
    protected String alamat;
    protected double hargaSewa;
    
    public Aset(String alamat, double hargaSewa) {
        this.alamat = alamat;
        this.hargaSewa = hargaSewa;
    }
    
    public abstract double hitungPajak();
}

// Intermediate class
public class Properti extends Aset {
    protected String jenis;
    
    public Properti(String jenis, String alamat, double hargaSewa) {
        super(alamat, hargaSewa);
        this.jenis = jenis;
    }
    
    @Override
    public double hitungPajak() {
        return hargaSewa * 0.1; // Pajak default 10%
    }
}

// Child class
public class Apartemen extends Properti {
    public Apartemen(String alamat, double hargaSewa) {
        super("Apartemen", alamat, hargaSewa);
    }
    
    @Override
    public double hitungPajak() {
        return hargaSewa * 0.12; // Pajak khusus apartemen 12%
    }
}

Penjelasan

Aset sebagai abstract base class mendefinisikan struktur dasar

Properti menambahkan atribut jenis dan implementasi default hitungPajak()

Apartemen override method hitungPajak() dengan perhitungan khusus

Polymorphism
Implementasi pada controller dan GUI:

// PropertiController.java
public static ArrayList<Properti> getAllProperti() {
    ArrayList<Properti> list = new ArrayList<>();
    // ...
    while (rs.next()) {
        String jenis = rs.getString("jenis");
        Properti p = jenis.equals("Rumah") 
            ? new Rumah(alamat, harga) 
            : new Apartemen(alamat, harga);
        list.add(p);
    }
    return list;
}

// MainFrame.java
private void tampilkanProperti() {
    model.setRowCount(0);
    for (Properti p : PropertiController.getAllProperti()) {
        model.addRow(new Object[] {
            p.getJenis(), 
            p.getAlamat(), 
            p.getHargaSewa(), 
            p.hitungPajak() // Polymorphic call
        });
    }
}


 Encapsulation
Implementasi pada kelas Penyewa:
public class Penyewa {
    private int id;
    private String nama;
    private String kontak;
    
    public Penyewa(int id, String nama, String kontak) {
        this.id = id;
        this.nama = nama;
        this.kontak = kontak;
    }
    
    // Getter methods
    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getKontak() { return kontak; }
    
    // Setter dengan validasi
    public void setNama(String nama) {
        if(nama != null && !nama.isEmpty()) {
            this.nama = nama;
        }
    }
}

 Abstraction
Implementasi koneksi database:

java
public class DBConnect {
    // Hide connection details
    public static Connection connect() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/kasir_properti", 
                "root", 
                ""
            );
        } catch (SQLException e) {
            System.out.println("Gagal konek: " + e.getMessage());
            return null;
        }
    }
}
Penjelasan:

Detail koneksi database disembunyikan

Pengguna hanya perlu memanggil DBConnect.connect()

Database Schema
CREATE TABLE properti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jenis VARCHAR(20) NOT NULL,
    alamat TEXT NOT NULL,
    harga_sewa DOUBLE NOT NULL
);

 Pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.kasir</groupId>
    <artifactId>kasir-properti</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>
</project>


Main

public class Main {
    public static void main(String[] args) {
        Property house = new House("Rumah Tipe 45", 500_000_000, 2);
        Property apartment = new Apartment("Apartemen Green Lake", 750_000_000, 1203);

        Transaction t1 = new Transaction(house, "Andi");
        Transaction t2 = new Transaction(apartment, "Sari");

        t1.processTransaction();
        t2.processTransaction();
    }
}

Database Structure
CREATE TABLE properti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jenis ENUM('Rumah', 'Apartemen') NOT NULL,
    alamat VARCHAR(255) NOT NULL,
    harga_sewa DECIMAL(15,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


✅ Tujuan Proyek
Melatih penggunaan konsep OOP dalam simulasi dunia nyata

Mengenal konsep pewarisan, enkapsulasi, abstraksi, dan polimorfisme di Java

Belajar membuat struktur program yang reusable dan scalabl

Nama : Neng Nova Siti Fathonah
NIM : 23552011455









