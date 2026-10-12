package bioskop.model;

import bioskop.enums.StatusKursi;

public class Kursi {
    private String nomor;
    private StatusKursi status;

    public Kursi(String nomor) {
        this.nomor = nomor;
        this.status = StatusKursi.TERSEDIA; 
    }

    public String getNomor() {
        return nomor;
    }

    public StatusKursi getStatus() {
        return status;
    }

    public void setStatus(StatusKursi status) {
        this.status = status;
    }

    public boolean isTersedia() {
        return this.status == StatusKursi.TERSEDIA;
    }
}