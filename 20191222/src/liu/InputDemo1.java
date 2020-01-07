package liu;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 14:35
 */
public class InputDemo1 {

    public static void main(String[] args) throws IOException {
        {
            InputStream is = new FileInputStream("本地文件.txt");
            Reader reader = new InputStreamReader(is, "UTF-8");

            StringBuilder sb1 = new StringBuilder();
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                // buffer[0,len]
                sb1.append(buffer, 0, len);
            }
            System.out.println(sb1.toString());
            reader.close();
        }
        {
            InputStream is = new FileInputStream("本地文件.txt");
            Reader reader = new InputStreamReader(is, "UTF-8");

            StringBuilder sb2 = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                char cb = (char) c;
                sb2.append(cb);
            }
            System.out.println(sb2.toString());
            reader.close();
        }

        {
            InputStream is = new FileInputStream("本地文件.txt");
            Reader reader = new InputStreamReader(is,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            System.out.println(sb.toString());
            bufferedReader.close();
        }

        {
            InputStream is = new FileInputStream("本地文件.txt");
            Scanner scanner = new Scanner(is,"utf8");

            Reader reader = new InputStreamReader(is,"utf8");
            Scanner scanner2 = new Scanner(reader);

            StringBuilder sb = new StringBuilder();
            while(scanner.hasNext()) {
                String next = scanner.next();
                sb.append(next);
            }
            System.out.println(sb.toString());
        }
    }
}
