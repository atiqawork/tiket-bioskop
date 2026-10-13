package bioskop.model;

import bioskop.enums.GenreFilm;

public class Film {
    private String judul;
    private GenreFilm genre;
    private int batasUmur;
    private int durasiMenit; 
    private double hargaDasar;

    //konstruktor
    public Film(String judul, GenreFilm genre, int batasUmur, int durasiMenit, double hargaDasar) {
        this.judul = judul;
        this.genre = genre;
        this.batasUmur = batasUmur;
        this.durasiMenit = durasiMenit;
        this.hargaDasar = hargaDasar;
    }

    public void tampilkanInfo() {
        System.out.println("=== INFO FILM ===");
        System.out.println("Judul       : " + this.judul);
        System.out.println("Genre       : " + this.genre);
        System.out.println("Durasi      : " + this.durasiMenit + " menit");
        System.out.println("Batas Umur  : " + this.batasUmur + "+");
        System.out.println("Harga Dasar : Rp" + this.hargaDasar);
        System.out.println("=================");
    }

    public String getJudul() {
        return judul;
    }

    public GenreFilm getGenre() {
        return genre;
    }

    public int getBatasUmur() {
        return batasUmur;
    }

    public int getDurasiMenit() {
        return durasiMenit;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }
    
    @Override
    public String toString() {
        return this.judul + " (" + this.durasiMenit + " mnt) - " + this.genre;
    }
}