package p2020_01.p20200301;

import com.sun.org.glassfish.gmbal.Description;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -03
 * Time: 21:49
 */
public class p20200301 {
    // 木棒拼图
    public static void main1(String[] args){
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if(temp == 1) {
                list.add(scanner.nextInt());
            } else {
                int temp2 = scanner.nextInt();
                if(list.contains(temp2)) {
                    //删除
                    list.remove((Object)temp2);
                }
            }
            IsPolygon(list);
        }
    }
    private static void IsPolygon(List list) {
        Collections.sort(list); // 按升序排序
        int maxLen = (Integer)list.get(list.size()-1); // 最长的
        int len = 0; // 所有的长度
        for (int i = 0; i < list.size()-1; i++) {
            len += (Integer)list.get(i);
        }
        if(len > maxLen) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

//**
//        * Description:磁盘容量问题：
//            * 磁盘存储的常用单位有：T,G,M；1T=1000G,1G=1000M;
// * 第一行输入n个整数，第二行输入磁盘容量的大小，对其按照从小到大的顺序输出；
//            * 输入示例：第一行  3
//            * 输入示例：第二行： 4M,2T,512G;
// * 输出：4M,512G,2T
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

    }
}
