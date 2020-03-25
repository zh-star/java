package p2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -03
 * Time: 18:55
 */
public class Main快手 {

    // A
    //AB A
    //ABAC ABA
    //ABAC ABAD ABAC ABA
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuffer sb = new StringBuffer();
        if(n == 1) {
            sb.append('A');
        }
        int m = 0;
        if(n % 2 == 0) {
            m = n*n-1;// 2 --3
        } else {
            m = n*n-2;//3 ---7
        }
        int flag = 1;
        while(m > 0) {
            if(m % 10 == 1) {
                sb.append("A");
            }
            if(m % 10 == 0 && flag == 1) {
                sb.append('B');
                flag = 2;
            }
            if(m % 10 == 0 && flag == 2) {
                sb.append('C');
                flag = 3;
            }
            if(m % 10 == 0 && flag == 3) {
                sb.append('D');
            }
            m--;
        }
        System.out.println(sb);
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        StringBuffer stringBuffer = new StringBuffer();
        char ch = s.charAt(0);
        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                ch = s.charAt(i);
                stringBuffer.append(ch);
            } else {
                // 是数字
                int n = Integer.parseInt(s.charAt(i)+"")-1;
                while(n > 0) {
                    stringBuffer.append(ch);
                    n--;
                }
            }
        }
        System.out.println(stringBuffer);
    }

    // 找出数组中大于这个元素的数的个数是1的数？
    public static void main3(String[] args){
        Scanner in = new Scanner(System.in);
        String  s = in.nextLine();
        System.out.println(s);
        String[] a =  s.split(" ");
        //System.out.println(Arrays.toString(arr));
        int[] arr = new int[a.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(a[i].charAt(i)+"");
        }
        for (int i = 0; i < arr.length; i++) {
            //int A = Integer.parseInt(arr[i]);
//            for (int j = i; j < ; j++) {
//
//            }
        }
    }
    // 排序

    //15166667234,15188887234
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] arr = s.split(",");
        StringBuffer sb = new StringBuffer();
        List<int[]> a = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
             a.add(isLiang(arr[i]));
        }
        for (int i = 0; i < a.size(); i++) {
            int flag = 0;
            if(a.get(i)[0] == 1) {
                if(a.get(i)[1] != 0 && a.get(i)[1] > flag) {

                }
            }
        }
    }



    private static int[] isLiang(String s) {
        int[] arr = new int[3];
        int n = Integer.parseInt(s.charAt(2)+"");
        //System.out.println(n);// 1
        int j = 3;
        int count1 = 0;
        while( j <= 10) {
            if(Integer.parseInt(s.charAt(j) +"")== n) {
               // System.out.print(count1 + "     ");
                count1++;
            } else {
                n = Integer.parseInt(s.charAt(j)+"");
               // System.out.print(n + " ");
            }
            j++;
        }

        j = 3;
        int count2 = 0;
        while(((s.charAt(j) == s.charAt(j)+1) || (s.charAt(j) == s.charAt(j)-1)) && j <= 10) {
            count2++;
            j++;
        }
        //System.out.println(count1);
        arr[1] = count1;
        arr[2] = count2;
        if(count1 != 0 || count2 != 0) {
            arr[0] = 1;
        }
        return arr;
    }


    private  static  int[]  value(String s) {
        int[] arr = new int[2];
        int n = Integer.parseInt(s.charAt(0)+"");
        //System.out.println(n);// 1
        int j = 1;
        int count1 = 0;
        // 豹子号 count1为豹子号的位数
        while( j <= 10) {
            if(Integer.parseInt(s.charAt(j) +"")== n) {
                // System.out.print(count1 + "     ");
                count1++;
            } else {
                n = Integer.parseInt(s.charAt(j)+"");
                // System.out.print(n + " ");
            }
            j++;
        }
        // 顺子号
        j = 3;
        int count2 = 0; // 顺子号的位数
        while(((s.charAt(j) == s.charAt(j)+1) || (s.charAt(j) == s.charAt(j)-1)) && j <= 10) {
            count2++;
            j++;
        }
        return arr;
    }
}
