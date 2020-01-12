package p20200110;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 22:56
 */
public class p20200110 {

    // 1. 手形数
    // 一个树的平方后几位数如果等与这个数 就叫这个数是手形数
    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int avg = N*N;
            while(N > 0) {
                int temp1 = avg % 10;
                int temp2 = N % 10;
                if( temp1 != temp2) {
                    System.out.println("No!");
                    break;
                }
                avg /= 10;
                N /= 10;
            }
            if(N <= 0) {
                System.out.println("Yes!");
            }
        }
    }
}
