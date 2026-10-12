package bioskop.model;

public class Jadwal {
    // Atribut private untuk menerapkan Enkapsulasi
    private String jamTayang;
    private String tanggalTayang;

    // Constructor dengan Shadowing (keyword this)
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

    // Method untuk menampilkan informasi jadwal secara rapi
    public void tampilkanJadwal() {
        System.out.println("Tanggal Tayang : " + this.tanggalTayang);
        System.out.println("Jam Tayang     : " + this.jamTayang);
    }
    
    // Overriding method toString bawaan Object
    @Override
    public String toString() {
        return "Jadwal: " + getWaktu();
    }
}