package bioskop.model;

public class Jadwal {
    private String jamTayang;
    private String tanggalTayang;

    public Jadwal(String jamTayang, String tanggalTayang) {
      this.jamTayang = jamTayang;
      this.tanggalTayang = tanggalTayang;
    }

    // Getter untuk jam tayang
    public String getJamTayang() {
        return jamTayang;
    }

    // Setter untuk jam tayang
    public void setJamTayang(String jamTayang) {
        this.jamTayang = jamTayang;
    }

    // Getter untuk tanggal tayang
    public String getTanggalTayang() {
        return tanggalTayang;
    }

    // Setter untuk tanggal tayang
    public void setTanggalTayang(String tanggalTayang) {
        this.tanggalTayang = tanggalTayang;
    }

    // Method getWaktu() ini yang dipanggil oleh class Tiket untuk mencetak struk
    public String getWaktu() {
        return this.tanggalTayang + " (" + this.jamTayang + ")";
    }

    public void tampilkanJadwal() {
        System.out.println("Tanggal Tayang : " + this.tanggalTayang);
        System.out.println("Jam Tayang     : " + this.jamTayang);
    }
    
    @Override
    public String toString() {
        return "Jadwal: " + getWaktu();
    }
}