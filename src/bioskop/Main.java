package bioskop;

import bioskop.enums.GenreFilm;
import bioskop.enums.StatusKursi;
import bioskop.interfaces.BisaDibayar;
import bioskop.model.Film;
import bioskop.model.Jadwal;
import bioskop.model.Kursi;
import bioskop.model.Pelanggan;
import bioskop.model.Pemesanan;
import bioskop.model.Studio;
import bioskop.pembayaran.PembayaranDigital;
import bioskop.pembayaran.PembayaranTunai;
import bioskop.services.DaftarFilm;
import bioskop.tiket.Tiket;
import bioskop.tiket.TiketReguler;
import bioskop.tiket.TiketVIP;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("===========================================");
    System.out.println("   SELAMAT DATANG DI BIOSKOP TI UNRI");
    System.out.println("===========================================");

    System.out.print("Masukkan Nama Anda: ");
    String nama = scanner.nextLine();
    
    int umur = 0;
    double saldoAwal = 0.0;
    String namaWallet = "";

    while (true) {
      try {
        System.out.print("Masukkan Umur Anda: ");
        umur = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan nama E-Wallet (DANA/OVO/GoPay): ");
        namaWallet = scanner.nextLine();
        System.out.print("Masukkan Saldo E-Wallet: Rp");
        saldoAwal = Double.parseDouble(scanner.nextLine());
        break; 
      } catch (NumberFormatException e) {
        System.out.println("Input tidak valid! Harap masukkan angka."); //Penanganan error ketika pengguna memasukkan huruf
      }
    }

    Pelanggan pelanggan = new Pelanggan(nama, umur,namaWallet, saldoAwal);//inisiasi pelanggan
    
    DaftarFilm katalogFilm = new DaftarFilm(5); //penambahan film
    katalogFilm.tambahFilm(new Film("Spider-Man: Across the Spider-Verse", GenreFilm.ACTION, 13, 140, 40000.0));
    katalogFilm.tambahFilm(new Film("The Nun II", GenreFilm.HORROR, 17, 110, 45000.0));
    katalogFilm.tambahFilm(new Film("Oppenheimer", GenreFilm.DRAMA, 13, 180, 50000.0));
    katalogFilm.tambahFilm(new Film("The Amazing Spider-Man", GenreFilm.ACTION, 14, 127, 50000.0));
    katalogFilm.tambahFilm(new Film("Lala Land", GenreFilm.ROMANCE, 18, 140, 75000.0));

    Jadwal jadwal1 = new Jadwal("13:00 WIB", "2026-10-15");
    Studio studio1 = new Studio("TI-C", 5, 5);

    boolean aplikasiJalan = true;
    
    while (aplikasiJalan) { //perulangan menu utama
      System.out.println("\n--- MENU UTAMA ---");
      System.out.println("1. Pesan Tiket");
      System.out.println("2. Cek Saldo E-Wallet");
      System.out.println("3. Keluar");
      System.out.print("Pilih menu (1/2/3): ");
      
      String pilihanMenu = scanner.nextLine();

      switch (pilihanMenu) {
        case "1":
          katalogFilm.tampilkanDaftarFilm();
          System.out.print("Pilih Film (masukkan nomor): ");
          System.out.println();
          Film filmPilihan = null;
          try {
            int pilihFilm = Integer.parseInt(scanner.nextLine());
            filmPilihan = katalogFilm.getFilmBerdasarkanPilihan(pilihFilm);
          } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
          }
          
          if (filmPilihan == null) {
            System.out.println("Film tidak valid.");
            continue; 
          }

          filmPilihan.tampilkanInfo();

          if (pelanggan.getUmur() < filmPilihan.getBatasUmur()) {
            System.out.println("Maaf, umur Anda tidak mencukupi untuk menonton film ini.");
            continue; 
          }

          int jumlahTiket = 0;
          try {
            System.out.print("\nMasukkan jumlah tiket yang ingin dibeli: ");
            jumlahTiket = Integer.parseInt(scanner.nextLine());
            if (jumlahTiket <= 0) throw new NumberFormatException();
          } catch (NumberFormatException e) {
            System.out.println("Jumlah tiket harus berupa angka positif!");
            continue;
          }

          Pemesanan pesanan = new Pemesanan(pelanggan, jumlahTiket);
          
          if (!pesanan.pesanTiket(jumlahTiket)) {
            continue;
          }

          for (int i = 0; i < jumlahTiket; i++) {
            System.out.println("\n--- TIKET KE-" + (i+1) + " ---");
            studio1.tampilkanLayoutKursi();
            
            Kursi kursiPilihan = null;
            
            while (true) {
              System.out.print("Pilih Kursi (misal A1): ");
              String nomorKursi = scanner.nextLine().toUpperCase();
              kursiPilihan = studio1.getKursi(nomorKursi);
              
              if (kursiPilihan == null) {
                System.out.println("Format salah/kursi tidak ada!");
              } else if (!kursiPilihan.isTersedia()) {
                System.out.println("Kursi TERISI. Pilih yang lain.");
              } else {
                kursiPilihan.setStatus(StatusKursi.TERISI);
                System.out.println("Kursi " + kursiPilihan.getNomor() + " diamankan.");
                break;
              }
            }

            System.out.println("Tipe Tiket: 1. Reguler | 2. VIP (+Rp50k)");
            System.out.print("Pilih Tipe (1/2): ");
            String tipeTiket = scanner.nextLine();

            Tiket tiket;
            if (tipeTiket.equals("2")) {
              tiket = new TiketVIP(filmPilihan, jadwal1, kursiPilihan); 
            } else {
              tiket = new TiketReguler(filmPilihan, jadwal1, kursiPilihan);
            }
            
            pesanan.tambahTiket(tiket);
          }

          pesanan.tampilkanDetailPemesanan(); 
          
          System.out.print("Punya voucher nominal? (y/n): ");
          if(scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.print("Masukkan nominal: Rp");
            try {
              int nom = Integer.parseInt(scanner.nextLine());
              pesanan.terapkanDiskon(nom); 
            } catch (Exception e) {}
          } else {
            System.out.print("Member? diskon 10% (y/n): ");
            if(scanner.nextLine().equalsIgnoreCase("y")) {
              pesanan.terapkanDiskon(10.0); 
            }
          }

          double totalAkhir = pesanan.getTotalHarga();
          System.out.println("\nHarus dibayar: Rp" + totalAkhir);

          System.out.println("1. E-Wallet (Saldo: Rp" + pelanggan.getSaldo() + ") | 2. Tunai");
          System.out.print("Pilih Pembayaran (1/2): ");
          String metode = scanner.nextLine();

          BisaDibayar pembayaran = null;
          boolean sukses = false;

          if (metode.equals("1")) {
            pembayaran = new PembayaranDigital(pelanggan, "DANA");
            sukses = pembayaran.prosesPembayaran(totalAkhir);
            if(sukses) pembayaran.cetakStruk(totalAkhir, 0);
            
          } else if (metode.equals("2")) {
            System.out.print("Uang tunai pelanggan: Rp");
            double uangTunai = Double.parseDouble(scanner.nextLine());
            
            PembayaranTunai bayarTunai = new PembayaranTunai();
            bayarTunai.setUangDiberikan(uangTunai);
            
            sukses = bayarTunai.prosesPembayaran(totalAkhir);
            if(sukses) {
              bayarTunai.cetakStruk(totalAkhir, (uangTunai - totalAkhir));
              pembayaran = bayarTunai; 
              }
          } else {
            System.out.println("Metode batal.");
            continue;
          }

          if (sukses) {
            System.out.println("\n[!] PEMESANAN BERHASIL [!]");
          }
          break;
          
          case "2":
            System.out.println("Saldo E-Wallet: Rp" + pelanggan.getSaldo());
            break;
            
          case "3":
            System.out.println("Keluar dari aplikasi. Terima kasih!");
            aplikasiJalan = false;
            break;
            
          default:
            System.out.println("Pilihan salah.");
      }
    }
    scanner.close();
  }
}