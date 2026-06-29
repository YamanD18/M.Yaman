import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "students.csv";
        String line;
        String csvSplitBy = ",";

        int jumlahBaris = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                for (String value : data) {
                    System.out.print(value + "\t");
                }
                System.out.println();

                jumlahBaris++;
            }

            System.out.println("\nJumlah seluruh baris = " + jumlahBaris);
            System.out.println("Jumlah data mahasiswa = " + (jumlahBaris - 1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}