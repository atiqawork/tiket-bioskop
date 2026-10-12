package bioskop.pembayaran;

import bioskop.interfaces.BisaDibayar;

public class PembayaranTunai implements BisaDibayar {
    
    private double uangDiberikan; 
    
    public PembayaranTunai() {
        this.uangDiberikan = 0;
    }

    @Override
    public boolean prosesPembayaran(double totalHarga) {
        
        System.out.println("Memproses pembayaran tunai di kasir...");
        if (uangDiberikan >= totalHarga) {
            System.out.println("Pembayaran Tunai berhasil.");
            return true;
        } else {
            System.out.println("Maaf, uang tunai yang diberikan kurang!");
            return false;
        }
    }
    
    public void setUangDiberikan(double uangDiberikan) {
        this.uangDiberikan = uangDiberikan;
    }

    @Override
    public void cetakStruk(double totalHarga, double kembalian) {
        System.out.println("================================");
        System.out.println("       STRUK PEMBAYARAN TUNAI   ");
        System.out.println("================================");
        System.out.println("Total Tagihan : Rp" + totalHarga);
        System.out.println("Uang Tunai    : Rp" + uangDiberikan);
        System.out.println("Kembalian     : Rp" + kembalian);
        System.out.println("================================");
        System.out.println("Terima kasih atas kunjungannya!");
    }
}