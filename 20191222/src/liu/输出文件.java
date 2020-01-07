package liu;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 15:37
 */
public class 输出文件 {
    public static void main(String[] args) throws IOException {
        {
            OutputStream os = new FileOutputStream("本地输出文件.txt");
            Writer writer = new OutputStreamWriter(os, "utf8");
            writer.write('c');
            writer.write("中国人");
            char[] buffer = {'我', '爱', '中', '国'};
            writer.write(buffer, 0, buffer.length);
            writer.append("\r\n我爱北京天安门!!!😂");
            writer.flush();
            writer.close();
        }

        {
            OutputStream os = new FileOutputStream("本地输出文件.txt");
            PrintStream out = new PrintStream(os, false, "utf8");
            PrintStream out1 = new PrintStream("本地输出文件.txt");
            out.println("我是中国人");
            out.flush();
            out.close();
        }


    }
}
