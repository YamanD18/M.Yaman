public class Mahasiswa {
    String nim;
    String nama;
    int nilai;
    char grade;

    // Constructor
    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.grade = hitungGrade();
    }

    // Method menentukan grade
    char hitungGrade() {
        if (nilai < 0 || nilai > 100) {
            System.out.println("Input nilai anda salah");
            return '-';
        } else if (nilai >= 80) {
            return 'A';
        } else if (nilai >= 70) {
            return 'B';
        } else if (nilai >= 60) {
            return 'C';
        } else if (nilai >= 50) {
            return 'D';
        } else {
            return 'E';
        }
    }

    // Status kelulusan
    boolean isLulus() {
        return (grade == 'A' || grade == 'B' || grade == 'C');
    }

    // Tampilkan data
    void tampilkan() {
        System.out.println("NIM : " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade: " + grade);
        System.out.println("=====================================");
    }
} 
    

