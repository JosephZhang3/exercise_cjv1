package chap6.intf.pci_interface_test;

/**
 * Created by Administrator on 2016/1/28.
 */
public class NetworkCard implements PCI {
    public void start(){
        System.out.println("Send message...");
    }

    public void stop(){
         System.out.println("Network stop!");
    }
}
