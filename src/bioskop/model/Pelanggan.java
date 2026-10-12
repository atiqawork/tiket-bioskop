package bioskop.model;

public class Pelanggan {
    private String nama;
    private int umur;
    private double saldo;
    private String namaWallet;

    public Pelanggan(String nama, int umur, String namaWallet, double saldoAwal) {
        this.nama = nama;
        this.umur = umur;
        this.saldo = saldoAwal;
        this.namaWallet = namaWallet;
    }

    public String getNama(){
      return nama;
    }

    public int getUmur() {
        return umur;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNamaWallet(){
      return namaWallet;
    }

    public void tambahSaldo(double nominal) {
        if (nominal > 0) {
            this.saldo += nominal;
        }
    }

    public void kurangiSaldo(double nominal) {
        if (nominal <= this.saldo) {
            this.saldo -= nominal;
        }
    }
}