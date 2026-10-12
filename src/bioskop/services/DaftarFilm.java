package bioskop.services;

import bioskop.model.Film;

public class DaftarFilm {
    // Array untuk menyimpan daftar film (Encapsulation)
    private Film[] listFilm;
    private int jumlahFilmSaatIni;
    private final int KAPASITAS_MAKSIMAL; // Penggunaan keyword final

    // Constructor
    public DaftarFilm(int kapasitas) {
        this.KAPASITAS_MAKSIMAL = kapasitas;
        this.listFilm = new Film[KAPASITAS_MAKSIMAL];
        this.jumlahFilmSaatIni = 0;
    }

    // Method untuk menambahkan film ke dalam array
    public void tambahFilm(Film filmBaru) {
        if (jumlahFilmSaatIni < KAPASITAS_MAKSIMAL) {
            listFilm[jumlahFilmSaatIni] = filmBaru;
            jumlahFilmSaatIni++;
            // System.out.println("Film '" + filmBaru.getJudul() + "' berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas daftar film sudah penuh!");
        }
    }

    // Method untuk menampilkan semua film yang ada
    public void tampilkanDaftarFilm() {
        System.out.println("\n=== DAFTAR FILM SEDANG TAYANG ===");
        if (jumlahFilmSaatIni == 0) {
            System.out.println("Belum ada film yang ditambahkan.");
            return; // Pernyataan loncat
        }

        // Perulangan (For-loop)
        for (int i = 0; i < jumlahFilmSaatIni; i++) {
            Film f = listFilm[i];
            System.out.println((i + 1) + ". " + f.getJudul() + 
                              " | Genre: " + f.getGenre() + 
                              " | Batas Umur: " + f.getBatasUmur() + "+");
        }
    }
    
    // Getter untuk mengambil objek Film berdasarkan index/nomor urut
    public Film getFilmBerdasarkanPilihan(int nomorPilihan) {
        int indexArray = nomorPilihan - 1; // Karena index array dimulai dari 0
        if (indexArray >= 0 && indexArray < jumlahFilmSaatIni) {
            return listFilm[indexArray];
        }
        return null; // Mengembalikan null jika pilihan tidak valid
    }
}