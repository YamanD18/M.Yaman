public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        System.out.println("=== OVERLOADING ===");
        bank.transferUang(100000, "123456");
        bank.transferUang(200000, "654321", "Mandiri");
        bank.transferUang(300000, "111222", "BRI", "Bayar utang");
        bank.sukuBunga();

        System.out.println("\n=== OVERRIDING BNI ===");
        bni.transferUang(500000, "999888", "bebas");
        bni.sukuBunga();

        System.out.println("\n=== OVERRIDING BCA ===");
        bca.transferUang(700000, "777666", "bebas");
        bca.sukuBunga();
    }
}