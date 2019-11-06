import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 9:58
 */
public class TestDemo3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] ch = str.toCharArray();
        int i = 0;
        int start = 0;
        while(i < ch.length -1) {
            if(ch[i] == ' ') {
                str = reverse(str,start,i);
                start = i + 1;
            } else {
                i ++;
            }
        }
        System.out.println(str);
    }
    public static String reverse(String str, int start, int end) {
        char[] ch = str.toCharArray();
        while(start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
        }
        return String.copyValueOf(ch);
    }
    public static void main2(String[] args){
        String s = "a good   example";
        String[] str = s.split(" ");
        System.out.println(Arrays.toString(str));
    }
    public static void main3(String[] args){
        String s = "the sky is    blue";
        //char[] ch = s.toCharArray();
        String ret = reverseWords(s);
        System.out.println(ret);
    }
    public static String reverseWords(String s) {
        s = s.trim();
        s = reverse1(s);
        String[] str = s.split(" ");
        System.out.println(Arrays.toString(str));
        String ret = "";
        // StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < str.length; i ++) {
            if(i != str.length -1) {
                ret += reverse1(str[i]) + " ";
            } else {
                ret += reverse1(str[i]);
            }
        }
        ret = cleanSpaces(ret);
        return ret;

    }
    public static String cleanSpaces(String s) {
        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));
        int i = 0;
        int n = 0;
        while(i < ch.length) {
            if(ch[i] == ' ' && ch[i+1] == ' ') {
                for (int j = i; j < ch.length - 1; j++) {
                    ch[j] = ch[j+1];
                }
                n ++;
                System.out.println(Arrays.toString(ch));
            } else {
                i++;
            }
        }
        return String.copyValueOf(ch,0,ch.length - n);
    }
    public static String reverse1(String s) {
        char[] value = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            char temp = value[left];
            value[left] = value[right];
            value[right] = temp;
            left ++;
            right --;
        }
        return String.copyValueOf(value);
    }

    public static void main1(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] value = str.split(" ");
        StringBuilder  ret  = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            ret.append(value[i]);
        }
        System.out.println(ret);
    }
}
