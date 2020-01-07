import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 9:31
 */
public class Test {
    public static void main(String[] args){
        Map<Integer,Integer> allKnownPort = new HashMap<>();

        String str = "https://www.baidu.com/s?" +
                "ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=c%2B%2B&rsv_pq=" +
                "84ef226c008d9b59&rsv_t=1c9cHkk8Nxj2aAyCVauxOtBI7Ph5TQX%2BlDZfRy" +
                "jz1cntt6wMA4p4z0QoUOc&rqlang=cn&rsv_enter=1&rsv_dl=tb&rsv_sug3=" +
                "5&rsv_sug1=6&rsv_sug7=101&rsv_sug2=0&inputT=4677&rsv_sug4=6157";

        int i = str.indexOf("://");
        String schem = str.substring(0,i);
        String hostAndPort = str.substring(0, i);
        str =str.substring(i+3);
        String host;
        int port;
        if(hostAndPort.contains(":")) {
            String[] group = hostAndPort.split(":");
            host = group[0];
            System.out.println(host);
        } else {
            host = hostAndPort;
            port = allKnownPort.get(schem);
        }
        System.out.println(host);
        //System.out.println(port);

        str = str.substring(i);
        i = str.indexOf("?");
       // if()

    }
}
