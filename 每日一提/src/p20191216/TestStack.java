package p20191216;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 16:53
 */
public class TestStack {
    static int[] weight;
    static int count=0;
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            N = sc.nextInt();
            weight = new int[N+1];
            for (int i = 1; i <= N; i++) {
                weight[i] = sc.nextInt();
            }
            beibao(40,N);
            System.out.println(count);
        }

    }
    public static void beibao(int s,int n) {//s为剩余物品重量，n为剩余可选物品数
        if (s == 0) {//如果正好装满
            ++count;
            return;
        }
        if (s < 0 || (s > 0 && n < 1))//是s<0或n<1则不能完成
            return;
        beibao(s - weight[n], n - 1);//从后往前装，装上weight[n]后，若剩余物品仍然有解
        beibao(s, n - 1);//若装了weight[n]后，无解，则删除该包,尝试第n-1个
    }


    public static void main2(String[] args){
        TestDemo1 testDemo1 = new TestDemo1();
        testDemo1.push(3);
        testDemo1.push(1);
        testDemo1.push(2);

        System.out.println(testDemo1.pop());
        //System.out.println(testDemo1);
    }
}
