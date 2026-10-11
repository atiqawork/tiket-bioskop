package bioskop;

public class Studio {
    private String namaStudio;
    private int kapasitas;
    public Studio(String namaStudio, int kapasitas) {
        this.namaStudio = namaStudio;
        this.kapasitas = kapasitas;
    }
    public String getNamaStudio() {
        return namaStudio;
    }
    public int getKapasitas() {
        return kapasitas;
    }
    public void tampilkanInfo() {
        System.out.println("Nama Studio : " + namaStudio);
        System.out.println("Kapasitas   : " + kapasitas + " kursi");
    }
}
