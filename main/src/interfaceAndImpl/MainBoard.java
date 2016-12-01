package interfaceAndImpl;

/**
 * Created by Administrator on 2016/1/28.
 */
public class MainBoard {
    public void usePCICard(PCI pci) {
        pci.start();
        pci.stop();
    }
}
