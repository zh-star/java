package p2019_12.p20191218;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:  每日一题 12-17
 * User: STAR
 * Date: 2019 -12
 * Time: 16:13
 */
public class TestDemo1 {

    // 1. 不要二  牛客网
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int count = 0;
        if(W%4==0||H%4==0){
            count=W*H/2;
        } else {
            count=W*H/2+1;
        }
        System.out.println(count);
    }

    // 2. 求最小公倍数
    public static void main2(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int i = 1;
        if (num1 == num2) {
            System.out.println(num1);
        } else if (num1 > num2) {
            if(num1 % num2 == 0) {
                System.out.println(num1);
            } else {
                while((num1 * i) % num2 != 0) {
                    i++;
                }
                System.out.println(num1*i);
            }
        } else {
            if(num2 % num1 == 0) {
                System.out.println(num2);
            } else {
                while((num2 * i) % num1 != 0) {
                    i++;
                }
                System.out.println(num2*i);
            }
        }
    }

}
