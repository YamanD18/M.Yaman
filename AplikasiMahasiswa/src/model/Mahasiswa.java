package model;

public class Mahasiswa<T, U, V> {
    private T nim;
    private U nama;
    private V kelas;

    public void setNim(T nim) {
        this.nim = nim;
    }

    public void setNama(U nama) {
        this.nama = nama;
    }

    public void setKelas(V kelas) {
        this.kelas = kelas;
    }

    public T getNim() {
        return nim;
    }

    public U getNama() {
        return nama;
    }

    public V getKelas() {
        return kelas;
    }

    public void tampil() {
        System.out.println(nim + " - " + nama + " - " + kelas);
    }
}