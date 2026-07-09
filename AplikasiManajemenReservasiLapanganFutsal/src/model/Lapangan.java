package model;

public class Lapangan extends Data {

    private String namaLapangan;
    private String jenisLapangan;
    private double hargaPerJam;
    private String statusLapangan;

    public Lapangan() {

    }

    public Lapangan(int id,
                     String namaLapangan,
                     String jenisLapangan,
                     double hargaPerJam,
                     String statusLapangan) {

        super(id);

        this.namaLapangan = namaLapangan;
        this.jenisLapangan = jenisLapangan;
        this.hargaPerJam = hargaPerJam;
        this.statusLapangan = statusLapangan;

    }

    public String getNamaLapangan() {
        return namaLapangan;
    }

    public void setNamaLapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    public String getJenisLapangan() {
        return jenisLapangan;
    }

    public void setJenisLapangan(String jenisLapangan) {
        this.jenisLapangan = jenisLapangan;
    }

    public double getHargaPerJam() {
        return hargaPerJam;
    }

    public void setHargaPerJam(double hargaPerJam) {
        this.hargaPerJam = hargaPerJam;
    }

    public String getStatusLapangan() {
        return statusLapangan;
    }

    public void setStatusLapangan(String statusLapangan) {
        this.statusLapangan = statusLapangan;
    }

    @Override
    public void tampilData() {

        System.out.println("-------------------------------------");
        System.out.println("ID             : " + id);
        System.out.println("Nama Lapangan  : " + namaLapangan);
        System.out.println("Jenis          : " + jenisLapangan);
        System.out.println("Harga/Jam      : " + hargaPerJam);
        System.out.println("Status         : " + statusLapangan);

    }

}