import java.sql.*;
import java.util.Scanner;

public class RetailApp {

    // Konfigurasi Database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/toko_retail";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            int pilihan;

            do {

                System.out.println();
                System.out.println("┌──────────────────────────────────────────────┐");
                System.out.println("│              MENU TOKO RETAIL                │");
                System.out.println("├──────────────────────────────────────────────┤");
                System.out.println("│ 1. Tampil Semua Data                         │");
                System.out.println("│ 2. Tambah Data                               │");
                System.out.println("│ 3. Cari Data                                 │");
                System.out.println("│ 4. Ubah Data                                 │");
                System.out.println("│ 5. Hapus Data                                │");
                System.out.println("│ 0. Keluar                                    │");
                System.out.println("└──────────────────────────────────────────────┘");

                System.out.print("Pilihan : ");
                pilihan = sc.nextInt();
                sc.nextLine();

                switch (pilihan) {

                    case 1:
                        tampilData();
                        break;

                    case 2:
                        tambahData();
                        break;

                    case 3:
                        cariData();
                        break;

                    case 4:
                        ubahData();
                        break;

                    case 5:
                        hapusData();
                        break;

                    case 0:
                        System.out.println("\nTerima kasih...");
                        break;

                    default:
                        System.out.println("\nPilihan tidak tersedia!");

                }

            } while (pilihan != 0);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // TAMPIL DATA
    // ==========================

private static void tampilData() throws SQLException {

    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM v_barang");

    System.out.println();
    System.out.println("+----+----------+----------------------+----------+--------+--------------+");
    System.out.println("|                     DAFTAR BARANG TOKO RETAIL YAMAN                     |");
    System.out.println("+----+----------+----------------------+----------+--------+--------------+");
    System.out.printf("| %-2s | %-8s | %-20s | %-8s | %-6s | %-12s |\n",
            "#", "Kode", "Nama Barang", "Harga", "Stok", "Total Nilai");
    System.out.println("+----+----------+----------------------+----------+--------+--------------+");

    int no = 1;

    while (rs.next()) {

        System.out.printf("| %-2d | %-8s | %-20s | %8d | %6d | %12d |\n",
                no++,
                rs.getString("kode_barang"),
                rs.getString("nama_barang"),
                rs.getInt("harga_barang"),
                rs.getInt("stok_barang"),
                rs.getInt("total_nilai"));
    }

    System.out.println("+----+----------+----------------------+----------+--------+--------------+");
    System.out.println("Total: " + (no - 1) + " barang");
}
    // ==========================
    // TAMBAH DATA
    // ==========================

    private static void tambahData() throws SQLException {

        System.out.println("\n===== TAMBAH DATA =====");

        System.out.print("Kode Barang  : ");
        String kode = sc.nextLine();

        System.out.print("Nama Barang  : ");
        String nama = sc.nextLine();

        System.out.print("Harga Barang : ");
        int harga = sc.nextInt();

        System.out.print("Stok Barang  : ");
        int stok = sc.nextInt();
        sc.nextLine();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tbl_barang VALUES (?,?,?,?)");

        ps.setString(1, kode);
        ps.setString(2, nama);
        ps.setInt(3, harga);
        ps.setInt(4, stok);

        ps.executeUpdate();

        System.out.println("\nData berhasil ditambahkan.");

    }


    // ==========================
    // CARI DATA
    // ==========================
    private static void cariData() throws SQLException {

        System.out.print("\nMasukkan Kode Barang : ");
        String kode = sc.nextLine();

        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM tbl_barang WHERE kode_barang=?");

        ps.setString(1, kode);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("\n===== DATA BARANG =====");

            System.out.println("Kode Barang : " + rs.getString("kode_barang"));
            System.out.println("Nama Barang : " + rs.getString("nama_barang"));
            System.out.println("Harga       : " + rs.getInt("harga_barang"));
            System.out.println("Stok        : " + rs.getInt("stok_barang"));

        } else {

            System.out.println("\nData tidak ditemukan.");

        }

    }

    // ==========================
    // UBAH DATA
    // ==========================

    private static void ubahData() throws SQLException {

        System.out.print("\nMasukkan Kode Barang : ");
        String kode = sc.nextLine();

        System.out.print("Nama Baru  : ");
        String nama = sc.nextLine();

        System.out.print("Harga Baru : ");
        int harga = sc.nextInt();

        System.out.print("Stok Baru  : ");
        int stok = sc.nextInt();
        sc.nextLine();

        PreparedStatement ps = conn.prepareStatement(
                "UPDATE tbl_barang SET nama_barang=?, harga_barang=?, stok_barang=? WHERE kode_barang=?");

        ps.setString(1, nama);
        ps.setInt(2, harga);
        ps.setInt(3, stok);
        ps.setString(4, kode);

        int hasil = ps.executeUpdate();

        if (hasil > 0)
            System.out.println("\nData berhasil diubah.");
        else
            System.out.println("\nData tidak ditemukan.");

    }

    // ==========================
    // HAPUS DATA
    // ==========================

    private static void hapusData() throws SQLException {

        System.out.print("\nMasukkan Kode Barang : ");
        String kode = sc.nextLine();

        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM tbl_barang WHERE kode_barang=?");

        ps.setString(1, kode);

        int hasil = ps.executeUpdate();

        if (hasil > 0)
            System.out.println("\nData berhasil dihapus.");
        else
            System.out.println("\nData tidak ditemukan.");

    }

}