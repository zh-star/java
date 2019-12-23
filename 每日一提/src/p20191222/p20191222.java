package p20191222;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 9:33
 */
public class p20191222 {
    // 1.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i],map.getOrDefault(arr[i],0) +1);
        }
        //System.out.println(map);
        for (Map.Entry<Integer,Integer> m : map.entrySet()) {
            if(m.getValue()%2 != 0) {
                System.out.print(m.getKey() + " ");
            }
        }
    }
}
