package Service;

import java.util.ArrayList;
import java.util.Scanner;
import model.MahasiswaAktif;

public class MahasiswaService implements DataMahasiswa {

    ArrayList<MahasiswaAktif> list = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    @Override
    public void tambahData() {
        System.out.println("\n=== Tambah Data ===");

        System.out.print("NIM: ");
        String nim = input.nextLine();

        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Kelas: ");
        String kelas = input.nextLine();
        input.nextLine(); // buang newline

        MahasiswaAktif m = new MahasiswaAktif();
        m.setNim(nim);
        m.setNama(nama);
        m.setKelas(kelas);

        list.add(m);

        System.out.println("Data berhasil ditambahkan!");
    }

    @Override
    public void tampilData() {
        System.out.println("\n=== Data Mahasiswa ===");

        if (list.isEmpty()) {
            System.out.println("Data kosong!");
        } else {
            for (MahasiswaAktif m : list) {
                m.tampil();
            }
            System.out.println("Total data: " + list.size());
        }
    }

    // method tambahan
    public void hapusData() {
        System.out.println("\n=== Hapus Data ===");

        if (list.isEmpty()) {
            System.out.println("Data kosong!");
            return;
        }

        list.remove(0);
        System.out.println("Data pertama berhasil dihapus!");
    }
}