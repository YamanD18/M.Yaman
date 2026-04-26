package laptop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // pilih laptop
        System.out.println("Pilih Laptop:");
        System.out.println("1. Asus");
        System.out.println("2. Toshiba");
        System.out.println("3. MacBook");
        System.out.print("Pilih: ");
        int pilihan = input.nextInt();
        input.nextLine();

        Laptop laptop;

        switch (pilihan) {
            case 1:
                laptop = new Asus();
                break;
            case 2:
                laptop = new Toshiba();
                break;
            case 3:
                laptop = new MacBook();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        LaptopUser user = new LaptopUser(laptop);

        String aksi;

        do {
            System.out.println("\nKetik perintah: ON / OFF / UP / DOWN / EXIT");
            System.out.print("Input: ");
            aksi = input.nextLine().toUpperCase();

            switch (aksi) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                case "OFF":
                    user.turnOffLaptop();
                    break;
                case "UP":
                    user.makeLaptopLouder();
                    break;
                case "DOWN":
                    user.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenal!");
            }

        } while (!aksi.equals("EXIT"));

        input.close();
    }
}