package service;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LaporanService {

    private Connection conn;

    public LaporanService() {

        conn = DatabaseConnection.getConnection();

    }

    /*
     * Menampilkan seluruh laporan
     * menggunakan VIEW
     */
    public void tampilLaporan() {

        String sql =
                "SELECT * FROM v_laporan_reservasi";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println();
            System.out.println("===============================================================");
            System.out.println("              LAPORAN RESERVASI FUTSAL");
            System.out.println("===============================================================");

            System.out.printf(
                    "%-5s %-15s %-12s %-18s %-12s %-10s %-8s %-12s\n",
                    "ID",
                    "Lapangan",
                    "Jenis",
                    "Pelanggan",
                    "Tanggal",
                    "Jam",
                    "Durasi",
                    "Total"
            );

            System.out.println("-------------------------------------------------------------------------------");

            boolean adaData = false;

            while (rs.next()) {

                adaData = true;

                System.out.printf(
                        "%-5d %-15s %-12s %-18s %-12s %-10s %-8d Rp %,.0f\n",

                        rs.getInt("id_reservasi"),

                        rs.getString("nama_lapangan"),

                        rs.getString("jenis_lapangan"),

                        rs.getString("nama_pelanggan"),

                        rs.getString("tanggal"),

                        rs.getString("jam_mulai"),

                        rs.getInt("durasi"),

                        rs.getDouble("total_bayar")

                );

            }

            if (!adaData) {

                System.out.println("Belum ada data laporan.");

            }

        } catch (SQLException e) {

            System.out.println("Gagal menampilkan laporan.");

            System.out.println(e.getMessage());

        }

    }

        /*
     * Mencari laporan berdasarkan nama pelanggan
     * menggunakan VIEW v_laporan_reservasi
     */
    public void cariLaporan(String namaPelanggan) {

        String sql =
                "SELECT * FROM v_laporan_reservasi " +
                "WHERE nama_pelanggan LIKE ?";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, "%" + namaPelanggan + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println();
            System.out.println("===============================================================");
            System.out.println("              HASIL PENCARIAN LAPORAN");
            System.out.println("===============================================================");

            boolean ditemukan = false;

            while (rs.next()) {

                ditemukan = true;

                System.out.printf(
                        "%-5d %-15s %-12s %-18s %-12s %-10s %-8d Rp %,.0f\n",

                        rs.getInt("id_reservasi"),

                        rs.getString("nama_lapangan"),

                        rs.getString("jenis_lapangan"),

                        rs.getString("nama_pelanggan"),

                        rs.getString("tanggal"),

                        rs.getString("jam_mulai"),

                        rs.getInt("durasi"),

                        rs.getDouble("total_bayar")

                );

            }

            if (!ditemukan) {

                System.out.println("Data tidak ditemukan.");

            }

        } catch (SQLException e) {

            System.out.println("Terjadi kesalahan.");
            System.out.println(e.getMessage());

        }

    }

}