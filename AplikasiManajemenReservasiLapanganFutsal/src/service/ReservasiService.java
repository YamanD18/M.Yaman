package service;

import database.DatabaseConnection;
import model.Reservasi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservasiService {

    private Connection conn;

    public ReservasiService() {

        conn = DatabaseConnection.getConnection();

    }

    /*
     * Menambah reservasi menggunakan
     * Stored Procedure : tambah_reservasi
     */
    public void tambahReservasi(
            int idLapangan,
            String namaPelanggan,
            String tanggal,
            String jamMulai,
            int durasi
    ) {

        String sql = "{CALL tambah_reservasi(?,?,?,?,?)}";

        try {

            CallableStatement cs =
                    conn.prepareCall(sql);

            cs.setInt(1, idLapangan);
            cs.setString(2, namaPelanggan);
            cs.setString(3, tanggal);
            cs.setString(4, jamMulai);
            cs.setInt(5, durasi);

            int hasil = cs.executeUpdate();

            if (hasil > 0) {

                System.out.println();
                System.out.println("===============================");
                System.out.println("RESERVASI BERHASIL DISIMPAN");
                System.out.println("===============================");

            }

        } catch (SQLException e) {

            System.out.println("Gagal menambah reservasi.");
            System.out.println(e.getMessage());

        }

    }
        /*
     * Menampilkan seluruh data reservasi
     */
    public void tampilReservasi() {

        String sql = "SELECT * FROM reservasi ORDER BY id_reservasi";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("                  DATA RESERVASI FUTSAL");
            System.out.println("==============================================================");

            boolean adaData = false;

            while (rs.next()) {

                adaData = true;

                Reservasi reservasi = new Reservasi();

                reservasi.setId(
                        rs.getInt("id_reservasi")
                );

                reservasi.setIdLapangan(
                        rs.getInt("id_lapangan")
                );

                reservasi.setNamaPelanggan(
                        rs.getString("nama_pelanggan")
                );

                reservasi.setTanggal(
                        rs.getString("tanggal")
                );

                reservasi.setJamMulai(
                        rs.getString("jam_mulai")
                );

                reservasi.setDurasi(
                        rs.getInt("durasi")
                );

                reservasi.setTotalBayar(
                        rs.getDouble("total_bayar")
                );

                reservasi.tampilData();

                System.out.println();

            }

            if (!adaData) {

                System.out.println("Belum ada data reservasi.");

            }

        } catch (SQLException e) {

            System.out.println("Terjadi kesalahan saat mengambil data reservasi.");
            System.out.println(e.getMessage());

        }

    }
        /*
     * Mencari reservasi berdasarkan nama pelanggan
     */

    /*
     * Mencari reservasi berdasarkan nama pelanggan
     */
    public void cariReservasi(String nama) {

        String sql =
                "SELECT * FROM reservasi " +
                "WHERE nama_pelanggan LIKE ?";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, "%" + nama + "%");

            ResultSet rs = ps.executeQuery();

            boolean ditemukan = false;

            System.out.println();
            System.out.println("============== HASIL PENCARIAN ==============");

            while (rs.next()) {

                ditemukan = true;

                Reservasi reservasi = new Reservasi();

                reservasi.setId(
                        rs.getInt("id_reservasi")
                );

                reservasi.setIdLapangan(
                        rs.getInt("id_lapangan")
                );

                reservasi.setNamaPelanggan(
                        rs.getString("nama_pelanggan")
                );

                reservasi.setTanggal(
                        rs.getString("tanggal")
                );

                reservasi.setJamMulai(
                        rs.getString("jam_mulai")
                );

                reservasi.setDurasi(
                        rs.getInt("durasi")
                );

                reservasi.setTotalBayar(
                        rs.getDouble("total_bayar")
                );

                reservasi.tampilData();
                System.out.println();

            }

            if (!ditemukan) {

                System.out.println("Data reservasi dengan nama \"" + nama + "\" tidak ditemukan.");

            }

        } catch (SQLException e) {

            System.out.println("Terjadi kesalahan saat mencari data.");
            System.out.println(e.getMessage());

        }

    }
}
