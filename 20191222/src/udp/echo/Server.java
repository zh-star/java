package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 20:06
 */
public class Server {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(8888);
        while(true) {
            byte[] buffer = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(buffer,0,buffer.length);
            socket.receive(receivePacket);

            int len = receivePacket.getLength();
            String message = new String(buffer,0,len,"utf8");
            System.out.println(message);


            String echoMessage = message;
            byte[] sendBuffer = echoMessage.getBytes("utf8");
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                    0,sendBuffer.length,receivePacket.getAddress(),receivePacket.getPort());
            socket.send(sendPacket);

        }
    }
}
