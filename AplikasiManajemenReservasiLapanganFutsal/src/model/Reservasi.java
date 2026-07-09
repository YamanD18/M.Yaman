package model;

public class Reservasi extends Data {

    private int idLapangan;
    private String namaPelanggan;
    private String tanggal;
    private String jamMulai;
    private int durasi;
    private double totalBayar;

    public Reservasi() {

    }

    public Reservasi(int id,
                      int idLapangan,
                      String namaPelanggan,
                      String tanggal,
                      String jamMulai,
                      int durasi,
                      double totalBayar) {

        super(id);

        this.idLapangan = idLapangan;
        this.namaPelanggan = namaPelanggan;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.durasi = durasi;
        this.totalBayar = totalBayar;

    }

    public int getIdLapangan() {
        return idLapangan;
    }

    public void setIdLapangan(int idLapangan) {
        this.idLapangan = idLapangan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    @Override
    public void tampilData() {

        System.out.println("-------------------------------------------");
        System.out.println("ID Reservasi      : " + id);
        System.out.println("ID Lapangan       : " + idLapangan);
        System.out.println("Nama Pelanggan    : " + namaPelanggan);
        System.out.println("Tanggal           : " + tanggal);
        System.out.println("Jam Mulai         : " + jamMulai);
        System.out.println("Durasi            : " + durasi + " Jam");
        System.out.println("Total Bayar       : Rp." + totalBayar);

    }

}