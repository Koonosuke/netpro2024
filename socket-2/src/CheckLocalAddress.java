import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddress {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Host name is: " + localHost.getHostName());
            System.out.println("IP address is: " + localHost.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("取得できなかった");
        }
    }
}
