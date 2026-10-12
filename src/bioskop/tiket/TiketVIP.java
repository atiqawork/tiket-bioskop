package bioskop.tiket;
import bioskop.model.Film;
import bioskop.model.Jadwal;
import bioskop.model.Kursi;

public class TiketVIP extends Tiket {
    private final double BIAYA_FASILITAS_VIP = 50000.0;

    public TiketVIP(Film film, Jadwal jadwal, Kursi kursi) {
        super(film, jadwal, kursi);
    }

    @Override
    public double hitungHarga() {
        double hargaDasar = film.getHargaDasar();
        double totalSementara = hargaDasar + BIAYA_FASILITAS_VIP;
        return totalSementara + (totalSementara * PAJAK_PPN);
    }
}