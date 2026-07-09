package main;

import service.LapanganService;
import service.ReservasiService;
import service.LaporanService;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static LapanganService lapanganService = new LapanganService();
    static ReservasiService reservasiService = new ReservasiService();
    static LaporanService laporanService = new LaporanService();

    public static void main(String[] args) {

        int pilih;

        do {

            System.out.println();
            System.out.println("==================================================");
            System.out.println("     APLIKASI MANAJEMEN RESERVASI LAPANGAN FUTSAL");
            System.out.println("==================================================");
            System.out.println("1. Menu Lapangan");
            System.out.println("2. Menu Reservasi");
            System.out.println("3. Menu Laporan");
            System.out.println("0. Keluar");
            System.out.println("==================================================");
            System.out.print("Pilih Menu : ");

            pilih = input.nextInt();

            switch (pilih) {

                case 1:
                    menuLapangan();
                    break;

                case 2:
                    menuReservasi();
                    break;

                case 3:
                    menuLaporan();
                    break;

                case 0:

                    System.out.println();
                    System.out.println("================================");
                    System.out.println("Terima kasih telah menggunakan");
                    System.out.println("Aplikasi Reservasi Futsal");
                    System.out.println("================================");
                    break;

                default:

                    System.out.println("Menu tidak tersedia.");

            }

        } while (pilih != 0);

    }

    // ============================
    // MENU LAPANGAN
    // ============================

    public static void menuLapangan() {

        int pilih;

        do {

            System.out.println();
            System.out.println("========== MENU LAPANGAN ==========");
            System.out.println("1. Tambah Lapangan");
            System.out.println("2. Lihat Lapangan");
            System.out.println("0. Kembali");
            System.out.print("Pilih : ");

            pilih = input.nextInt();

            switch (pilih) {

                case 1:

                    input.nextLine();

                    System.out.print("Nama Lapangan : ");
                    String nama = input.nextLine();

                    System.out.print("Jenis Lapangan : ");
                    String jenis = input.nextLine();

                    System.out.print("Harga / Jam : ");
                    double harga = input.nextDouble();

                    input.nextLine();

                    System.out.print("Status : ");
                    String status = input.nextLine();

                    lapanganService.tambahLapangan(
                            nama,
                            jenis,
                            harga,
                            status
                    );

                    break;

                case 2:

                    lapanganService.tampilLapangan();

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Pilihan salah.");

            }

        } while (pilih != 0);

    }

        // ============================
    // MENU RESERVASI
    // ============================

    public static void menuReservasi() {

        int pilih;

        do {

            System.out.println();
            System.out.println("========== MENU RESERVASI ==========");
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Lihat Reservasi");
            System.out.println("0. Kembali");
            System.out.print("Pilih : ");

            pilih = input.nextInt();

            switch (pilih) {

                case 1:

                    System.out.print("ID Lapangan : ");
                    int idLapangan = input.nextInt();

                    input.nextLine();

                    System.out.print("Nama Pelanggan : ");
                    String nama = input.nextLine();

                    System.out.print("Tanggal (yyyy-mm-dd) : ");
                    String tanggal = input.nextLine();

                    System.out.print("Jam Mulai (HH:mm:ss) : ");
                    String jam = input.nextLine();

                    System.out.print("Durasi (Jam) : ");
                    int durasi = input.nextInt();

                    reservasiService.tambahReservasi(
                            idLapangan,
                            nama,
                            tanggal,
                            jam,
                            durasi
                    );

                    break;

                case 2:

                    reservasiService.tampilReservasi();

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Pilihan tidak tersedia.");

            }

        } while (pilih != 0);

    }

        // ============================
    // MENU LAPORAN
    // ============================

    public static void menuLaporan() {

        int pilih;

        do {

            System.out.println();
            System.out.println("========== MENU LAPORAN ==========");
            System.out.println("1. Tampilkan Laporan");
            System.out.println("2. Cari Laporan");
            System.out.println("0. Kembali");
            System.out.print("Pilih : ");

            pilih = input.nextInt();

            switch (pilih) {

                case 1:

                    laporanService.tampilLaporan();

                    break;

                case 2:

                    input.nextLine();

                    System.out.print("Masukkan Nama Pelanggan : ");
                    String nama = input.nextLine();

                    laporanService.cariLaporan(nama);

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Pilihan tidak tersedia.");

            }

        } while (pilih != 0);

    }

}