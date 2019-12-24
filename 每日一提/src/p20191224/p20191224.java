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
    public static void main(String[] agrs) {
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
        //System.out.println(ret);
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
}
