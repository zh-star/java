package p2020_01.p20200112;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 15:47
 */
public class p20200112 {
    // 1. 奇偶校验
    //思路就是：转为2进制后1的个数为偶数最高位要补1，注意ascii码最大就是127
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            int[] ret = new int[8];
            for(int i = 0; i < str.length(); i++) {
                ret = jicheck(str.charAt(i));
                for (int j = 0; j < 8; j++) {
                    System.out.print(ret[j]);
                }
                System.out.println();
            }
        }
//        char ch = 'a';
//        //Integer.parseInt(String.valueOf(ch))
//        System.out.println(Integer.toBinaryString(ch));
    }
    private static int[] jicheck(char ch) {
        int[] array = new int[8];
        // 将该字符的assii码 值 转成二进制
        String s = Integer.toBinaryString(ch);
        int j = 8-s.length();
        int oneNum = 0;
        for (int i = 0; i < s.length(); i++) {
            array[j] = Integer.parseInt(String.valueOf(s.charAt(i))) ;
            if(array[j] == 1) {
                oneNum++;
            }
            j++;
        }
        if(oneNum % 2 == 0) {
            array[0] = 1;
        }
        return array;
    }
    // 2.大整数排序
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            BigInteger[] value = new BigInteger[n];
            for(int i = 0; i < n; i++) {
                value[i] = in.nextBigInteger();
            }
            Arrays.sort(value);
            for(int i = 0; i < n; i++) {
                System.out.println(value[i]);
            }
        }
    }
}
