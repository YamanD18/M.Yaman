package laptop;

public class MacBook implements Laptop {

    private int volume = 60;
    private boolean isPowerOn = false;

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("MacBook menyala...");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("MacBook mati...");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            volume += 15;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("MacBook belum dinyalakan!");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            volume -= 15;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("MacBook belum dinyalakan!");
        }
    }
}