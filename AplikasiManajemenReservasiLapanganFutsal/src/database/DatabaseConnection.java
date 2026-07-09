package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/db_reservasi_futsal";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Koneksi Database Berhasil.");

            }

        } catch (ClassNotFoundException e) {

            System.out.println("Driver MySQL tidak ditemukan.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Gagal terhubung ke database.");
            e.printStackTrace();

        }

        return connection;

    }

}