package p20191212;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 15:19
 */
public class TestDemo1 {
    //1. 喝汽水问题： 3个换一瓶， 2 两瓶盖时 可向店铺借一瓶汽水
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int sum = 0;//总能换喝多少瓶
            int n = sc.nextInt();// 最开始有多少瓶盖
            if(n == 0) {
                continue;
            }
            while(n > 1) {
                sum += n/3;
                n = n%3 + n/3;
                if(n == 2) {
                    sum += 1;
                    break;
                }
            }
            System.out.println(sum);
        }
    }
    // 2. 数组的逆序对个数 一组数据 , 前一个 只要大于后一个值，就组成一个逆序对，
    // 使用归并排序
    public static void main(String[] args){
        int[] a = new int[] {1,2,3,4,5,6,7,0};
        System.out.println(count(a,8));
    }
    // 方法1 ： 时间复杂度 O(n*2) 牛客网上 可以通过
    public static int count(int[] A, int n) {
        // write code here
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(A[i] > A[j]) {
                    count ++;
                }
            }
        }
        return count;
    }
}
