package bioskop.model;

import bioskop.enums.StatusKursi;

public class Studio {
    private String namaStudio;
    private Kursi[][] denahKursi;

    public Studio(String namaStudio, int baris, int kolom) {
        this.namaStudio = namaStudio;
        this.denahKursi = new Kursi[baris][kolom];
        inisialisasiKursi();
    }

    private void inisialisasiKursi() {
        for (int i = 0; i < denahKursi.length; i++) {
            for (int j = 0; j < denahKursi[i].length; j++) {
                char barisChar = (char) ('A' + i);
                String nomor = barisChar + String.valueOf(j + 1);
                denahKursi[i][j] = new Kursi(nomor);
            }
        }
    }

    public void tampilkanLayoutKursi() {
        System.out.println("=== LAYOUT STUDIO " + namaStudio + " ===");
        System.out.println("        [ L A Y A R ]        \n");
        for (int i = 0; i < denahKursi.length; i++) {
            for (int j = 0; j < denahKursi[i].length; j++) {
                Kursi k = denahKursi[i][j];
                if (k.getStatus() == StatusKursi.TERISI) {
                    System.out.print("[ XX ] ");
                } else {
                    System.out.print("[ " + k.getNomor() + " ] ");
                }
            }
            System.out.println(); 
        }
    }

    public Kursi getKursi(String nomorInput) {
        try {
            char barisChar = nomorInput.charAt(0);
            int barisIndex = barisChar - 'A'; 
            
            int kolomIndex = Integer.parseInt(nomorInput.substring(1)) - 1; 

            if (barisIndex >= 0 && barisIndex < denahKursi.length && 
                kolomIndex >= 0 && kolomIndex < denahKursi[0].length) {
                return denahKursi[barisIndex][kolomIndex];
            }
        } catch (Exception e) {
            return null;
        }
        return null; 
    }
}