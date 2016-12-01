package interfaceAndImpl;

/**
 * Created by Administrator on 2016/1/28.
 */
public class SoundCard implements PCI {
    public void start() {
        System.out.println("Play music...");
    }

    public void stop() {
        System.out.println("Sound Stop!");
    }
}
