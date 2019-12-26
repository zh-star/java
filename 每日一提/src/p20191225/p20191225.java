package p20191225;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 20:03
 */
public class p20191225{
    // 1. 求一串数字组成的最小数
    public static void main1(String args[]) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        //输入数据
        int i = 0;
        for(i = 0;i < 10;i++) {
            arr[i] = sc.nextInt();
        }
        //把从数字1开始的第一个不为0的数字放到list第一个
        if(arr[0] != 0) {
            for( i = 1;i < 10;i++) {
                if(arr[i] != 0){
                    list.add(i);
                    arr[i]--;
                    break;
                }
            }
        }
        //把剩余数字按位置放入list
        for(i = 0;i < 10;i++) {
            for(int j = 0;j < arr[i];j++) {
                list.add(i);
            }
        }
        //按顺序输出即可
        for(int t : list) {
            System.out.print(t);
        }
    }


    // 2.求
    // 2^3 =
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(GetSequeOddNum(m));
    }

    public static String GetSequeOddNum(int m) {
        StringBuffer sb = new StringBuffer();
        double sum = Math.pow(m,3); // 求立方
        int avg = (int)sum / m;
        // 是偶数
        if(avg%2 == 0) {
            int temp = avg - (m/2)*2 + 1;
            for(int i = 0; i < m; i ++) {
                if(i != m -1) {
                    sb.append( temp + "+");
                } else {
                    sb.append(temp);
                }
                temp += 2;
            }
        } else {
            int temp = avg - (m/2)*2;
            for(int i = 0; i < m; i ++) {
                if(i != m -1) {
                    sb.append( temp + "+");
                } else {
                    sb.append(temp);
                }
                temp += 2;
            }
        }
        return sb.toString();
    }

}
