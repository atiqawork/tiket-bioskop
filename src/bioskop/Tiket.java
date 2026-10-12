
package bioskop;

public abstract class Tiket {
    private String kodeTiket;
    private double hargaDasar;
    private Film film;
    private String jadwal;
    private Kursi kursi;

    public Tiket(String kodeTiket, double hargaDasar,
                 Film film, String jadwal, Kursi kursi) {
        this.kodeTiket = kodeTiket;
        this.hargaDasar = hargaDasar;
        this.film = film;
        this.jadwal = jadwal;
        this.kursi = kursi;
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    public Film getFilm() {
        return film;
    }

    public String getJadwal() {
        return jadwal;
    }

    public Kursi getKursi() {
        return kursi;
    }

    public abstract double hitungHarga();

    public abstract String getJenisTiket();
}
