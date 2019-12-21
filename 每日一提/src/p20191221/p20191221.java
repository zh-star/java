package p20191221;

import com.sun.javafx.collections.MappingChange;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 19:37
 */
public class p20191221 {
    // 1. 求100311一个数中 几个0 几个1 几个3
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < N.length(); i++) {
            map.put(N.charAt(i),map.getOrDefault(N.charAt(i),0) + 1);
        }

        for (Map.Entry<Character,Integer> m : map.entrySet()) {
            System.out.print(m.getKey() + ":" +  m.getValue());
            System.out.println();
        }
    }

}
