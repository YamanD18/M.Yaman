package Main;

import java.util.Scanner;
import Service.MahasiswaService;

public class MainApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MahasiswaService service = new MahasiswaService();

        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    service.tambahData();
                    break;
                case 2:
                    service.tampilData();
                    break;
                case 3:
                    service.hapusData();
                    break;
                case 4:
                    System.out.println("Keluar program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        input.close();
    }
}