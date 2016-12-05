package interfaceAndImpl;

/**
 * Created by Administrator on 2016/1/28.
 */
public class GraphicCard implements PCI {
    public void start() {
        System.out.println("Display picture...");
    }

    public void stop() {
        System.out.println("Graphic stop!");
    }
}
