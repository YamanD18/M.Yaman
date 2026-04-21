public class Bank {

    // Overloading 1
    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer " + jumlah + 
        " ke rekening " + rekeningTujuan);
    }

    // Overloading 2
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiayaTransfer(bankTujuan);
        System.out.println("Transfer " + jumlah + 
        " ke rekening " + rekeningTujuan + 
        " di bank " + bankTujuan);
        System.out.println("Biaya transfer: " + biaya);
    }

    // Overloading 3
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biaya = hitungBiayaTransfer(bankTujuan);
        System.out.println("Transfer " + jumlah + 
        " ke rekening " + rekeningTujuan + 
        " di bank " + bankTujuan + 
        " dengan berita: " + berita);
        System.out.println("Biaya transfer: " + biaya);
    }

    // Method suku bunga
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // Bonus: biaya transfer
    public int hitungBiayaTransfer(String bankTujuan) {
        if (bankTujuan.equalsIgnoreCase("BNI")) {
            return 4000;
        } else if (bankTujuan.equalsIgnoreCase("BCA")) {
            return 6500;
        } else {
            return 7500;
        }
    }
}