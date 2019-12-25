package p20191224;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 21:04
 */
public class p20191224 {

    // 1.超长正整数相加
    public static void main1(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        String addend = sc.nextLine();
        String augend = sc.nextLine();
        String ret = AddLongInteger(addend,augend);
        System.out.println(ret);

    }
    public static String AddLongInteger(String addend,String augend) {
        StringBuffer ret = new StringBuffer();
        int i = addend.length()-1;
        int j = augend.length()-1;
        int temp = 0;

        while(i >= 0  && j >=0 ) {
            temp += (addend.charAt(i)-'0') + (augend.charAt(j)-'0');
            ret.append(temp%10);
            temp = temp / 10;
            i--;
            j--;
        }
        while(i >= 0) {
            temp += (addend.charAt(i)-'0');
            ret.append(temp%10);
            temp = temp / 10;
            i--;
        }
        while(j >= 0) {
            temp += (augend.charAt(j)-'0');
            ret.append(temp%10);
            temp = temp / 10;
            j--;
        }
        if(temp != 0) {
            ret.append(temp);
        }
        return ret.reverse().toString();

    }

    //2. 跟着奥巴马一起编程
    // 打印正方形  打印结果是这样
    // aaaaaaaaaa
    // a        a
    // a        a
    // a        a
    // aaaaaaaaaa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String str = sc.next();
            drawSquare(n,str);
        }
    }
    public static void drawSquare(int n, String str) {
        int list = n; // 列
        // Math.round(float)返回最接近的参数 int ，其中 int四舍五入为正无穷大。
        int row = Math.round((float) list / 2); //行
        for(int i = 0; i < row; i++) {
            // 打印第一行和最后一行
            if(i == 0 || i == row - 1) {
                for(int j = 0; j < list; j ++) {
                    System.out.print(str);
                }
            } else {  // 打印中间行
                for(int j = 0; j < list; j ++) {
                    // 每行 第一列 和最后一列 打印字母
                    if(j == 0 || j == list - 1) {
                        System.out.print(str);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
