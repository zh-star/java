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


    public static void main5(String[] args){
        char[] ch1 = {'a'};
        char[] ch2 = {'b'};
        System.out.println(ch1);
        System.out.println(ch2);
        swap(ch1,ch2);
        System.out.println(ch1);
        System.out.println(ch2);
    }
    public static void swap(char[] ch1, char[] ch2) {
        char temp = ch1[0];
        ch1[0] = ch2[0];
        ch2[0] = temp;
    }

    //翻转字符串 牛客网
    //输入 ：i am a student  输出：i ma a tneduts
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] ch = str.toCharArray();
        //System.out.println(Arrays.toString(ch));
        int i = 0;
        int start = 0;
        while(i < ch.length) {
            if(ch[i] == ' ') {
                str = reverse(str,start,i -1);
                start = i + 1;
                i ++;
            } else if(i == ch.length - 1){
                str = reverse(str,start,i -1);
                i++;
            } else {
                i ++;
            }
        }
        System.out.println(str);
    }
    public static String reverse(String str, int start, int end) {
        char[] ch = str.toCharArray();
        //System.out.println(Arrays.toString(ch));
        while(start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start ++;
            end --;
        }
        return String.copyValueOf(ch);
    }


    //翻转字符串 leetcode
    //示例 1：输入: "the sky is blue"    输出: "blue is sky the"

    //示例 2：输入: "  hello world!        "输出: "world! hello"
    //解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

    //示例 3：输入: "a good   example"    输出: "example good a"
    //解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

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


    //字符串拼接
    //输入 abc def  gh  输出 abcdefgh  注：一行可多输入
    public static void main1(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] value = str.split(" ");
        StringBuilder  ret  = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            ret.append(value[i]);
        }
        System.out.println(ret);
//        int count = 0;
//        while(count % 10 != 0);
    }
}
