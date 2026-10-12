package bioskop.model;

import bioskop.interfaces.BisaDipesan;
import bioskop.tiket.Tiket;

public class Pemesanan implements BisaDipesan {
    private static int totalPemesananHariIni = 0;
    private String idPemesanan;
    private Pelanggan pelanggan;
    private Tiket[] daftarTiket;
    private int jumlahTiketSaatIni;
    private double totalHarga;

    public Pemesanan(Pelanggan pelanggan, int kapasitasMaksimalTiket) {
        this.pelanggan = pelanggan;
        this.daftarTiket = new Tiket[kapasitasMaksimalTiket];
        this.jumlahTiketSaatIni = 0;
        this.totalHarga = 0.0;
        totalPemesananHariIni++; 
        this.idPemesanan = "TRX-00" + totalPemesananHariIni;
    }

    public void tambahTiket(Tiket tiket) {
        if (jumlahTiketSaatIni < daftarTiket.length) {
            daftarTiket[jumlahTiketSaatIni] = tiket;
            this.totalHarga += tiket.hitungHarga(); 
            jumlahTiketSaatIni++;
        } else {
            System.out.println("Kapasitas pemesanan tiket sudah maksimal!");
        }
    }

    
    @Override
    public boolean pesanTiket(int jumlahTiket) {
        if (jumlahTiket <= (daftarTiket.length - jumlahTiketSaatIni)) {
            System.out.println("Slot tersedia. Silakan lanjutkan pemilihan " + jumlahTiket + " kursi.");
            return true;
        } else {
            System.out.println("Maaf, jumlah pesanan melebihi sisa slot tiket Anda (" + (daftarTiket.length - jumlahTiketSaatIni) + " tersisa).");
            return false;
        }
    }

    @Override
    public void tampilkanDetailPemesanan() {
        System.out.println("\n=== DETAIL PEMESANAN ===");
        System.out.println("ID Pesanan   : " + this.idPemesanan);
        System.out.println("Nama Pemesan : " + pelanggan.getNama());
        System.out.println("Jumlah Tiket : " + this.jumlahTiketSaatIni);
        System.out.println("- - - Rincian Tiket - - -");
        
        for (int i = 0; i < jumlahTiketSaatIni; i++) {
            System.out.println((i + 1) + ". " + daftarTiket[i].toString());
        }
        
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Total Harga  : Rp" + this.totalHarga);
        System.out.println("========================");
    }


    public void terapkanDiskon(double persentase) {
        double potongan = this.totalHarga * (persentase / 100);
        this.totalHarga -= potongan;
        System.out.println("Diskon " + persentase + "% berhasil diterapkan.");
    }

    public void terapkanDiskon(int nominalVoucher) {
        this.totalHarga -= nominalVoucher;
        if (this.totalHarga < 0) {
            this.totalHarga = 0;
        }
        System.out.println("Voucher Rp" + nominalVoucher + " berhasil diterapkan.");
    }

    public double getTotalHarga() {
        return totalHarga;
    }
}