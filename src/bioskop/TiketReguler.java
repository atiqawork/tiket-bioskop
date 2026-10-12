
package bioskop;

public class TiketReguler extends Tiket {

    public TiketReguler(String kodeTiket, double hargaDasar,
                        Film film, String jadwal, Kursi kursi) {
        super(kodeTiket, hargaDasar, film, jadwal, kursi);
    }

    @Override
    public double hitungHarga() {
        return getHargaDasar();
    }

    @Override
    public String getJenisTiket() {
        return "Reguler";
    }
}
