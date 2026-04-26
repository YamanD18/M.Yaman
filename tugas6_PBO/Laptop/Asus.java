package laptop;

public class Asus implements Laptop {

    private int volume = 50;
    private boolean isPowerOn = false;

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Laptop Asus menyala...");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Laptop Asus mati...");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            volume += 10;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            volume -= 10;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }
}