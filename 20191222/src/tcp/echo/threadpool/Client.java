package tcp.echo.threadpool;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 11:08
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.43.112", 8888);
        /*
        Socket socket = new Socket();
        socket.bind(本地IP + 本地port);
        socket.connect(目标IP + 目标port);
         */
        InputStream is = socket.getInputStream();
        Scanner 读Server发送的Scanner = new Scanner(is, "UTF-8");
        OutputStream os = socket.getOutputStream();
        Scanner 读本地用户准备发送的Scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请提交命令: ");
            String message = 读本地用户准备发送的Scanner.nextLine();
            byte[] sendBuffer = message.getBytes("UTF-8");
            os.write(sendBuffer);
            os.write('\r');
            os.write('\n');
            System.out.println(读Server发送的Scanner.nextLine());
        }

        //socket.close();
    }
}
