package tcp.echo.threadpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 11:15
 */
public class Server1 {
    private static class Worker implements Runnable {
        private final Socket socket;
        Worker(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                Scanner scanner = new Scanner(is,"utf8");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        ExecutorService pool = Executors.newFixedThreadPool(100);

        while(true) {
            System.out.println("等待连接 ：");
            Socket socket = serverSocket.accept();
            System.out.println("连接建立");
            pool.execute(new Worker(socket));
        }
    }
}
