package bioskop.tiket;

import bioskop.model.Film;
import bioskop.model.Jadwal;
import bioskop.model.Kursi;

public abstract class Tiket {
  protected Film film;
  protected Jadwal jadwal;
  protected Kursi kursi;
  
  public static final double PAJAK_PPN = 0.11; // Pajak 11%

  public Tiket(Film film, Jadwal jadwal, Kursi kursi) {
    this.film = film;
    this.jadwal = jadwal;
    this.kursi = kursi;
  }

  public abstract double hitungHarga();

  @Override
  public String toString() {
    return String.format("Tiket: %s | Jadwal: %s | Kursi: %s", film.getJudul(), jadwal.getWaktu(), kursi.getNomor());
  }
}