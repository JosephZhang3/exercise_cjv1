package interfaceAndImpl;

/**
 * Created by Administrator on 2016/1/28.
 */
public class PCI_Demo {
    public static void main(String[] args) {

        MainBoard mb=new MainBoard();
        //在主板上插入网卡
        PCI nc=new NetworkCard();
        mb.usePCICard(nc);

        //在主板上插入声卡
        PCI sc=new SoundCard();
        mb.usePCICard(sc);

        //在主板上插入显卡
        PCI gc=new GraphicCard();
        mb.usePCICard(gc);
    }
}


