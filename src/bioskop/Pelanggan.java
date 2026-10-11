package bioskop;

public class Pelanggan {
    private String nama;
    private String nomorTelepon;

    public Pelanggan(String nama, String nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Pelanggan : " + nama);
        System.out.println("Nomor Telepon  : " + nomorTelepon);
    }
}

