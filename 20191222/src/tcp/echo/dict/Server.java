package tcp.echo.dict;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 11:07
 */
/*
public class Server {
    private static class Worker implements Runnable {
        private final Socket socket;
        private static Map<String,String> dictionary = new HashMap<>();

        Worker(Socket socket) {
            this.socket = socket;
        }

        static {
            try {
                InputStream is = new FileInputStream("字典.txt");
                Scanner scanner = new Scanner(is,"utf8");
                while(true) {
                    String line = scanner.nextLine();
                    String[] kv = line.split(":");
                    dictionary.put(kv[0],kv[1]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {

                //InputStream is = new FileInputStream("字典.txt");

                OutputStream os = socket.getOutputStream();

               // Scanner scanner = new Scanner(is, "UTF-8");

                PrintStream out = new PrintStream(os, false, "UTF-8");

                while (scanner.hasNextLine()) {
                    System.out.println(name + ":等待客户端发送消息");
                    String message = scanner.nextLine();
                    System.out.println(name + ":收到消息:" + message);

                    String echoMessage = message;

                    out.println(echoMessage);
                }
            } catch (UnsupportedEncodingException e) {
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {}
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        int i = 0;
        while (true) {
            System.out.println("main:等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("main:连接建立");
            Thread thread = new Thread(new Worker(socket), "工作人员(" + i++ + ")");
            thread.start();
        }
    }
}
*/