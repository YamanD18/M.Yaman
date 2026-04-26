package laptop;

public class Toshiba implements Laptop {

    private int volume = 40;
    private boolean isPowerOn = false;

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Laptop Toshiba menyala...");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Laptop Toshiba mati...");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            volume += 5;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("Laptop masih mati!");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            volume -= 5;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("Laptop masih mati!");
        }
    }
}