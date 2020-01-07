package http;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 9:43
 */
public class Request {
    String method;
    String path;
    String version;
    Map<String,String> headers = new HashMap<>();

    public static Request parse(InputStream is) {
        Request request = new Request();
        Scanner scanner = new Scanner(is,"UTF-8");
        String line;
        // 解析 请求行
        line = scanner.nextLine();
        String[] group = line.split(" ");
        request.method = group[0];
        request.path = group[1];
        request.version = group[2];

        // 解析 请求头
        while(!(line = scanner.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            request.headers.put(key, value);
        }
        return request;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", header=" + headers +
                '}';
    }

}
