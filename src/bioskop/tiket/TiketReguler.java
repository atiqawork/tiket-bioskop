package bioskop.tiket;
import bioskop.model.Film;
import bioskop.model.Jadwal;
import bioskop.model.Kursi;

public class TiketReguler extends Tiket {

    public TiketReguler(Film film, Jadwal jadwal, Kursi kursi) {
      super(film, jadwal, kursi); 
    }

    @Override
    public double hitungHarga() {
      double hargaDasar = film.getHargaDasar();
      return hargaDasar + (hargaDasar * PAJAK_PPN);
    }
}