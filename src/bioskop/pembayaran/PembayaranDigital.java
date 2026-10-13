package bioskop.pembayaran;

import bioskop.interfaces.BisaDibayar;
import bioskop.model.Pelanggan;

public class PembayaranDigital implements BisaDibayar {
  private Pelanggan pelanggan;
  private String namaEWallet;

  public PembayaranDigital(Pelanggan pelanggan, String namaEWallet) {
    this.pelanggan = pelanggan;
    this.namaEWallet = namaEWallet;
  }

  @Override
  public boolean prosesPembayaran(double totalHarga) {
    System.out.println("Memproses pembayaran dengan " + namaEWallet + "...");
    if (pelanggan.getSaldo() >= totalHarga) {
      pelanggan.kurangiSaldo(totalHarga);
      System.out.println("Pembayaran berhasil!");
      return true;
    } else {
      System.out.println("Saldo tidak mencukupi!");
      return false;
    }
  }

  @Override
  public void cetakStruk(double uangBayar, double kembalian) {
    System.out.println("=== STRUK PEMBAYARAN DIGITAL ===");
    System.out.println("Metode: " + namaEWallet);
    System.out.println("Sisa Saldo: Rp" + pelanggan.getSaldo());
    System.out.println("================================");
  }
}