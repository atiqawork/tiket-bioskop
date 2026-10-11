package bioskop;

public class Film {
    private String judul;
    private String genre;
    private int durasi;

    public Film(String judul, String genre, int durasi) {
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
    }

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurasi() {
        return durasi;
    }

    public void tampilkanInfo() {
        System.out.println("Judul Film : " + judul);
        System.out.println("Genre      : " + genre);
        System.out.println("Durasi     : " + durasi + " menit");
    }
}
