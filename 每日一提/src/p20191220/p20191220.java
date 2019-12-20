package p20191220;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 23:14
 */
public class p20191220 {


    // 1. 一个数到斐波那契数的 步数
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        while(f2 < N) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        if((f2-N) < (N-f0)) {
            System.out.println(f2-N);
        } else {
            System.out.println(N-f0);
        }
    }


    // 2.
    //
    //有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
    //
    //给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。

    public int countWays(int x, int y) {
        // write code here
        // 从右下角 向左下角 走 是一样的
        // 若只剩最后 单条 不管 另一值是多少，都是只能一步走 （这个是从1开始的）
        if(x == 1 || y == 1) {
            return 1;
        }
        // 否则 就去 这个点的左一个节点到根部的 走法数 和 这个点的正下面一个节点到根部的 走法数
        return countWays(x-1,y) + countWays(x,y-1);
    }



}
