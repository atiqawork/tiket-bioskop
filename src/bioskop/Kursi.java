
package bioskop;

public class Kursi {
    private int nomorKursi;

    public Kursi(int nomorKursi) {
        this.nomorKursi = nomorKursi;
    }

    public int getNomorKursi() {
        return nomorKursi;
    }

    @Override
    public String toString() {
        return "Kursi " + nomorKursi;
    }
}
