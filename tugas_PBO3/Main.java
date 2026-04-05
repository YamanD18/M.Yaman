import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> list = new ArrayList<>();

        int jumlah;
        System.out.print("Masukkan jumlah mahasiswa: ");
        jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = input.nextLine();
            System.out.print("Nama  : ");
            String nama = input.nextLine();
            System.out.print("Nilai : ");
            int nilai = input.nextInt();
            input.nextLine();

            list.add(new Mahasiswa(nim, nama, nilai));
        }

        int totalNilai = 0;
        int lulus = 0, tidakLulus = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0;

        String namaLulus = "";
        String namaTidakLulus = "";

        System.out.println("\n=====================================");
        for (Mahasiswa mhs : list) {
            mhs.tampilkan();

            totalNilai += mhs.nilai;

            if (mhs.isLulus()) {
                lulus++;
                namaLulus += mhs.nama + ", ";
            } else {
                tidakLulus++;
                namaTidakLulus += mhs.nama + ", ";
            }

            switch (mhs.grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
                case 'E': countE++; break;
            }
        }

        double rata = (double) totalNilai / jumlah;

        if (!namaLulus.isEmpty()) {
            namaLulus = namaLulus.substring(0, namaLulus.length() - 2);
        }
        if (!namaTidakLulus.isEmpty()) {
            namaTidakLulus = namaTidakLulus.substring(0, namaTidakLulus.length() - 2);
        }

        System.out.println("Jumlah Mahasiswa : " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus + " yaitu " + namaLulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + " yaitu " + namaTidakLulus);
        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + countA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B = " + countB);
        System.out.println("Jumlah Mahasiswa dengan Nilai C = " + countC);
        System.out.println("Jumlah Mahasiswa dengan Nilai D = " + countD);
        System.out.println("Jumlah Mahasiswa dengan Nilai E = " + countE);
        System.out.println("Rata-rata nilai mahasiswa adalah : " + rata);
    }
}