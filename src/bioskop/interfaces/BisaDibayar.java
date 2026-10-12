package bioskop.interfaces;

public interface BisaDibayar {
  boolean  prosesPembayaran(double totalHarga);
  void cetakStruk(double uangBayar, double kembalian);
}