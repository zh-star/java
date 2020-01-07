package tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 10:01
 */
public class Client {
    public static void main(String[] args) throws IOException {

        //String message = "cat\r\ndog\r\nfish\r\n";

        Socket socket = new Socket("127.0.0.1", 8888);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入：");
            String message = sc.nextLine();
            byte[] sendBuffer = message.getBytes("utf8");
            os.write(sendBuffer);

            Scanner scanner = new Scanner(is, "utf8");
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());

        }
    }
}
