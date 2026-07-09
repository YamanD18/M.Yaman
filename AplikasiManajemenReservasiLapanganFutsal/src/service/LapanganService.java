package service;

import database.DatabaseConnection;
import model.Lapangan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LapanganService {

    private Connection conn;

    public LapanganService() {
        conn = DatabaseConnection.getConnection();
    }

    public void tambahLapangan(
            String nama,
            String jenis,
            double harga,
            String status
    ){

        String sql =
                "INSERT INTO lapangan " +
                "(nama_lapangan,jenis_lapangan,harga_per_jam,status_lapangan) " +
                "VALUES(?,?,?,?)";

        try{

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1,nama);
            ps.setString(2,jenis);
            ps.setDouble(3,harga);
            ps.setString(4,status);

            int hasil = ps.executeUpdate();

            if(hasil>0){

                System.out.println();
                System.out.println("=================================");
                System.out.println("DATA BERHASIL DISIMPAN");
                System.out.println("=================================");

            }

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

    }
        public void tampilLapangan(){

        String sql =
                "SELECT * FROM lapangan";

        try{

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println();
            System.out.println("============== DATA LAPANGAN ==============");

            while(rs.next()){

                Lapangan lapangan =
                        new Lapangan();

                lapangan.setId(
                        rs.getInt("id_lapangan")
                );

                lapangan.setNamaLapangan(
                        rs.getString("nama_lapangan")
                );

                lapangan.setJenisLapangan(
                        rs.getString("jenis_lapangan")
                );

                lapangan.setHargaPerJam(
                        rs.getDouble("harga_per_jam")
                );

                lapangan.setStatusLapangan(
                        rs.getString("status_lapangan")
                );

                lapangan.tampilData();

                System.out.println();

            }

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

    }
}
