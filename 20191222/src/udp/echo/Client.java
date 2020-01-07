package udp.echo;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 20:21
 */
public class Client {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("请输入 ： ");

            String message = scanner.next();
            byte[] sendBuffer = message.getBytes("utf8");

            // 得到我本机的地址ip
            //InetAddress address = InetAddress.getLocalHost();
            InetAddress address = InetAddress.getByAddress(
                    new byte[]{(byte) 192, (byte) 168, 43, 112}
            );

            int port = 8888;
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                    0, sendBuffer.length, address, port);
            socket.send(sendPacket);


            byte[] receiveBuffer = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,
                    0, receiveBuffer.length);
            socket.receive(receivePacket);
            String echoMessage = new String(receiveBuffer,
                    0, receivePacket.getLength());

            System.out.println(echoMessage);
        }
    }

}
