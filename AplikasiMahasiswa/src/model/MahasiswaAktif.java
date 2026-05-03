package model;

public class MahasiswaAktif extends Mahasiswa<String, String, String> {

    @Override
    public void tampil() {
        System.out.println("Mahasiswa Aktif:");
        System.out.println(getNim() + " - " + getNama() + " - " + getKelas());
    }
}