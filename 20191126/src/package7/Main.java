package package7;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -04
 * Time: 19:39
 */
public class Main {
    public static void main(String[] args){
        int[] arr = {2,2,4};
        System.out.println(countDolphin(5,5,arr,5));
    }
    //时间段内 原来的 + 新生的 - 死亡的
    static long countDolphin(int n, int m, int[] birthYear, int x) {
        long count = 0;
        int year = 0;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            map.put("a"+i,m);
        }
        //System.out.println(map);
        for (int i = 0; i < birthYear.length; i++) {
            count += n;//原来的
            year = birthYear[i];
            for (int j = 1; j < n; j++) {
                map.put("a"+j,m-year);
            }
            System.out.println(map);
            if(year < m) {
                //只要小于寿命,就会生原来数量的
                count += count;
            } else {
                count -= count;
            }

        }
        return count;
    }

}
