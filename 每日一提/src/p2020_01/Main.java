package p2020_01;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -03
 * Time: 18:50
 */
public class Main {
    // 3 2
    // 3 5 7
    // 1 2
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        int y = in.nextInt();
        Set<Integer> setNum = new HashSet<>();
        setNum.add(1);
        setNum.add(5);
        setNum.add(6);
        setNum.size();
        setNum.contains(1);
        for (Integer i:setNum) {
            System.out.println(i);
        }
        List<Integer> list = new ArrayList<>(setNum);
        System.out.println(list.get(2));

    }
    static int  threeSum(String numstr) {
        String[] value = numstr.split(",");
        if(value.length == 2) {
            return 0;
        }
        //去重
        Set<String> set = new HashSet<>();
        for(int i = 0; i < value.length; i++) {
            set.add(value[i]);
        }


        int n = 0;
        int sum = 0;
        //System.out.println(Arrays.toString(value));
        //System.out.println(list);
        for(int i = 0; i < value.length; i++) {
            int a = Integer.parseInt(value[i]);
            for(int j = i+1; j < value.length; j++) {
                int b = Integer.parseInt(value[j]);
                for(int k = j+1; k < value.length; k++) {
                    sum = a+b+Integer.parseInt(value[k]);
                    if(sum == 0) {
                        n++;
                    }
                }
            }
        }
        return n;
    }
    /******************************结束写代码******************************/


    public static void main1(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _numstr;
        try {
            _numstr = in.nextLine();
        } catch (Exception e) {
            _numstr = null;
        }

        res =  threeSum(_numstr);
        System.out.println(String.valueOf(res));

    }
}

