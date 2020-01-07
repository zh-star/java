package liu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 17:33
 */
public class InputDemo {
    public static void main(String[] args) throws FileNotFoundException {
//        InputStream is = new FileInputStream("本地文件");
//
//        InputStream  file = 获取一个输入字节流();
//        String file = 从一个输入字节流中得到最终字符(file);
    }
    // private static String 从一个输入字节流中得到最终字符(InputDemo is) throws IOException {
        /*
        byte[] buffer = new byte[8192];
        int len = 8192;
        for (int i = 0; i < buffer.length; i++) {
            int b = is.read();
            if(b == -1) {
                len = i;
                break;
            }
            buffer[i] = (byte) b;
        }
        String s = new String(buffer,0,len,"utf-8");
        return s;
         */

        /*
        Reader reader = new InputStreamReader(is,"UTF-8");
        char[] buffer = new char[1024];
        int len = reader.read(buffer);

        return new String(buffer,0,len);
        */

        /*
        Reader reader = new InputStreamReader(is,"utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        return bufferedReader.readLine();
        */

    // Scanner scanner = new Scanner(is,"utf-8");
    // return scanner.next();

    // }


    private static InputStream 获取一个输入字节流() throws FileNotFoundException {
        InputStream is;
        is = new FileInputStream("本地文件。txt");
        return is;
    }
}
