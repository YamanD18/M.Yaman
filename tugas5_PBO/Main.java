import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Student
        System.out.println("=== INPUT STUDENT ===");
        System.out.print("Nama: ");
        String sName = input.nextLine();
        System.out.print("Alamat: ");
        String sAddress = input.nextLine();

        Student student = new Student(sName, sAddress);

        System.out.print("Jumlah mata kuliah: ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Nama MK: ");
            String mk = input.nextLine();
            System.out.print("Nilai: ");
            int nilai = input.nextInt();
            input.nextLine();

            student.addCourseGrade(mk, nilai);
        }

        System.out.println("\n" + student);
        student.printGrades();
        System.out.println("Rata-rata: " + student.getAverageGrade());

        // Input Teacher
        System.out.println("\n=== INPUT TEACHER ===");
        System.out.print("Nama: ");
        String tName = input.nextLine();
        System.out.print("Alamat: ");
        String tAddress = input.nextLine();

        Teacher teacher = new Teacher(tName, tAddress);

        System.out.print("Jumlah MK diajar: ");
        int mkCount = input.nextInt();
        input.nextLine();

        for (int i = 0; i < mkCount; i++) {
            System.out.print("Nama MK: ");
            String mk = input.nextLine();
            if (teacher.addCourse(mk)) {
                System.out.println("Berhasil ditambahkan");
            } else {
                System.out.println("MK sudah ada!");
            }
        }

        System.out.println("\n" + teacher);

        input.close();
    }
}