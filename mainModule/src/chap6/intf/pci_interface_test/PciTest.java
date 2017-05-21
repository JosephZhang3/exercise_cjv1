package chap6.intf.pci_interface_test;

/**
 * 将Java语言的“接口”模拟为电脑的总线接口
 * Created by Administrator on 2016/1/28.
 */
public class PciTest {
    public static void main(String[] args) {

        MainBoard mb = new MainBoard();
        //在主板上插入网卡
        PCI nc = new NetworkCard();
        mb.usePCICard(nc);

        //在主板上插入声卡
        PCI sc = new SoundCard();
        mb.usePCICard(sc);

        //在主板上插入显卡
        PCI gc = new GraphicCard();
        mb.usePCICard(gc);
    }
}


