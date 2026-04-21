public class BankBCA extends Bank {

    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga BCA adalah 4.5%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BCA";
        int biaya = hitungBiayaTransfer(bankTujuan);

        System.out.println("Transfer " + jumlah + 
        " ke rekening " + rekeningTujuan + 
        " di bank " + bankTujuan);
        System.out.println("Biaya transfer: " + biaya);
    }
}