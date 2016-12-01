package network;

import java.net.*;

public class InetAddressDemo {
	public static void main(String[] args) {
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
			String localname = ip.getHostName();
			String localaddress = ip.getHostAddress();
			System.out.println(localname);
			System.out.println(localaddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
