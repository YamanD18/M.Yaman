import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String csvFile = "students.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            bw.write("NIM,NAMA,UMUR,PRODI");
            bw.newLine();

            System.out.print("Masukkan jumlah mahasiswa: ");
            int jumlah = input.nextInt();
            input.nextLine();

            for (int i = 1; i <= jumlah; i++) {

                System.out.println("\nData Mahasiswa ke-" + i);

                System.out.print("NIM   : ");
                String nim = input.nextLine();

                System.out.print("Nama  : ");
                String nama = input.nextLine();

                System.out.print("Umur  : ");
                String umur = input.nextLine();

                System.out.print("Prodi : ");
                String prodi = input.nextLine();

                bw.write(nim + "," + nama + "," + umur + "," + prodi);
                bw.newLine();
            }

            System.out.println("\nData berhasil disimpan ke students.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }

        input.close();
    }
}
