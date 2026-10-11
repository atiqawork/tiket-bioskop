package bioskop;

public class Pemesanan implements BisaDipesan {
    private Pelanggan pelanggan;
    private Jadwal jadwal;
    private int jumlahTiket;
    private boolean berhasilDipesan;

    public Pemesanan(Pelanggan pelanggan, Jadwal jadwal) {
        this.pelanggan = pelanggan;
        this.jadwal = jadwal;
        this.jumlahTiket = 0;
        this.berhasilDipesan = false;
    }

    @Override
    public boolean pesanTiket(int jumlahTiket) {
        if (jumlahTiket <= 0) {
            System.out.println("Jumlah tiket harus lebih dari 0.");
            return false;
        }

        if (jumlahTiket > jadwal.getStudio().getKapasitas()) {
            System.out.println("Jumlah tiket melebihi kapasitas studio.");
            return false;
        }

        this.jumlahTiket = jumlahTiket;
        this.berhasilDipesan = true;

        System.out.println("Pemesanan tiket berhasil!");
        return true;
    }

    @Override
    public void tampilkanDetailPemesanan() {
        if (!berhasilDipesan) {
            System.out.println("Belum ada pemesanan yang berhasil.");
            return;
        }

        System.out.println("\n===== DETAIL PEMESANAN =====");
        pelanggan.tampilkanInfo();
        jadwal.tampilkanJadwal();
        System.out.println("Jumlah Tiket : " + jumlahTiket);
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }
}

