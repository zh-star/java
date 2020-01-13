package P20190108;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 22:13
 */
public class P20190108 {

    // 1.数字求和
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            System.out.print(sum(n) + " " + sum(n*n));
            System.out.println();
        }
    }
    // 求一个数的各位的和
    public static int sum(int n) {
        int sum = 0;
        while(n > 9) {
            sum += n % 10;
            n /= 10;
        }
        return sum + n;
    }
    // 2.
}
