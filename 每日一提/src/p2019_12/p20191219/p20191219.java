package p2019_12.p20191219;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:  12-19 题
 * User: STAR
 * Date: 2019 -12
 * Time: 15:55
 */
public class p20191219 {


    // 1. 输入一个正整数n,求n!(即阶乘)末尾有多少个0？
    // 比如: n = 10; n! = 3628800,所以答案为2
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for (int i = 5; i <= num; i *= 5) {
            count += num / i;
        }
        System.out.println(count);
    }


    // 2. 数字逆序打印
    public static void main2(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num / 10 > 0) {
            System.out.print(num % 10);
            num = num / 10;
        }
        System.out.print(num % 10);
    }
}
