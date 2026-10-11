package bioskop;

import java.util.ArrayList;

public class DaftarFilm {
    private ArrayList<Film> daftarFilm;

    public DaftarFilm() {
        daftarFilm = new ArrayList<>();
    }

    public void tambahFilm(Film film) {
        daftarFilm.add(film);
        System.out.println("Film berhasil ditambahkan!");
    }

    public void tampilkanDaftarFilm() {
        if (daftarFilm.isEmpty()) {
            System.out.println("Belum ada film tersedia.");
            return;
        }

        System.out.println("===== DAFTAR FILM =====");

        for (int i = 0; i < daftarFilm.size(); i++) {
            System.out.println("\nFilm ke-" + (i + 1));
            daftarFilm.get(i).tampilkanInfo();
        }
    }

    public Film cariFilm(String judul) {
        for (Film film : daftarFilm) {
            if (film.getJudul().equalsIgnoreCase(judul)) {
                return film;
            }
        }

        return null;
    }

    public int getJumlahFilm() {
        return daftarFilm.size();
    }
}

