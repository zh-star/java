package p2019_12.p20191215;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 每日一题 12-14  等待补充
 * User: STAR
 * Date: 2019 -12
 * Time: 22:31
 */
public class TestDemo1 {
    //2.
    //They are students.
    //aeiou
    //Thy r stdnts.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sb1 = sc.nextLine();
        String str2= sc.nextLine();
        //System.out.println(sb1);
        //System.out.println(str2);
        for (int i = 0; i < sb1.length(); i++) {
            if (str2.contains(sb1.charAt(i) + "")) {
                //System.out.println("jinlai");
                sb1 = sb1.replaceAll(sb1.charAt(i)+"","");
                //System.out.println(sb1);
            }
        }
        System.out.println(sb1);
    }

    //1.【买苹果】小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，
    // 只提供6个每袋和8个每袋的包装(包装不可拆分)。
    // 可是小易现在只想购买恰好n个苹果，小易想
    //购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isBy(n));
    }

    public static int isBy(int n) {
        if(n<6 || n%2!=0 || n == 10) {
            return -1;
        }
        if (n % 8 == 0) {
            return n/8;
        }
        return 1+n/8;
    }
}

