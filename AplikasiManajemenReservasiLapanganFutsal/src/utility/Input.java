package utility;

import java.util.Scanner;

public class Input {

    private static Scanner input = new Scanner(System.in);

    public static int inputInt(String pesan){

        System.out.print(pesan);
        return input.nextInt();

    }

    public static double inputDouble(String pesan){

        System.out.print(pesan);
        return input.nextDouble();

    }

    public static String inputString(String pesan){

        input.nextLine();
        System.out.print(pesan);

        return input.nextLine();

    }

}