import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 9:52
 */
public class TestDemo1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String str = scanner.next();
        str = reverse(str,0,size - 1);
        str = reverse(str,size,str.length() -1);
        str = reverse(str,0,str.length() -1);
        System.out.println(str);
        //byte[] bytes = {12,23,24,25};
        //String s = String.copyValueOf(bytes);//String.copyValueOf(char[] ch)
    }
    public static String reverse(String str,int start,int end){
        char[] ch = str.toCharArray();
        while(start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start ++;
            end --;
        }
        return  String.copyValueOf(ch);
    }
    public static String reverse(String str) {
        char[] ch = str.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while(left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left ++;
            right --;
        }
        return  new String(ch);

    }
    public static void main2(String[] args){
        String s = "abcdef";
        String ret = reverse(s);
        System.out.println(ret);
    }
    public static void main1(String[] args){
        String str = "123456a";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] < '0' && ch[i] >'9') {
                System.out.println("不是数字字符串");
                return;
            }
        }
        System.out.println("是数字字符串");
    }
}
