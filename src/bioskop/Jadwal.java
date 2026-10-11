package bioskop;

public class Jadwal {
    private Film film;
    private Studio studio;
    private String tanggal;
    private String jamTayang;

    public Jadwal(Film film, Studio studio,
                  String tanggal, String jamTayang) {
        this.film = film;
        this.studio = studio;
        this.tanggal = tanggal;
        this.jamTayang = jamTayang;
    }

    public Film getFilm() {
        return film;
    }

    public Studio getStudio() {
        return studio;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJamTayang() {
        return jamTayang;
    }

    public void tampilkanJadwal() {
        System.out.println("JADWAL BIOSKOP");
        film.tampilkanInfo();
        studio.tampilkanInfo();
        System.out.println("Tanggal     : " + tanggal);
        System.out.println("Jam Tayang  : " + jamTayang);
    }
}
