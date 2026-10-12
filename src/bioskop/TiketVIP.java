
package bioskop;

public class TiketVIP extends Tiket {

    public TiketVIP(String kodeTiket, double hargaDasar,
                    Film film, String jadwal, Kursi kursi) {
        super(kodeTiket, hargaDasar, film, jadwal, kursi);
    }

    @Override
    public double hitungHarga() {
        return getHargaDasar() * 1.5;
    }

    @Override
    public String getJenisTiket() {
        return "VIP";
    }
}
