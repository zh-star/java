package liu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 15:22
 */
public class 内存中的源 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] source = "中国人民站起来了".getBytes("utf8");
        InputStream is = new ByteArrayInputStream(source);

        Scanner scanner = new Scanner(is,"utf8");
        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
