package p20191217;


import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 每日一题 12-16
 * User: STAR
 * Date: 2019 -12
 * Time: 15:20
 */
public class TestDemo1 {


    //1.计算糖果
    public static void main1(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int dif1 = sc.nextInt();//A-B
        int dif2 = sc.nextInt();//B-C
        int sum1 = sc.nextInt();//A+B
        int sum2 = sc.nextInt();//B+C
        int retA = (dif1 + sum1)/2;
        int retB = (dif2 + sum2)/2;
        int retC = (sum2 - dif2)/2;
        if((retA-retB == dif1) && (retB - retC == dif2) && (retA+retB == sum1)
                && (retB + retC == sum2) ) {
            System.out.print(retA + " " + retB + " " + retC);
        } else {
            System.out.print("No");
        }
    }

    //2.输入n个正数，输出 出现次数 大于等于 n/2 的数
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        while(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        //遍历map
        for (Map.Entry<Integer,Integer> m : map.entrySet()) {
            if( m.getValue() >= list.size()/2) {
                System.out.println(m.getKey());
            }
        }
    }


}
