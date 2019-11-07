package package1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 18:49
 */
public class TestDemo1 {
    public static void main(String[] args){
        String ret = (String) reverseVowels("hello");
        System.out.println(ret);
    }

    public static String reverseVowels(String s) {
        String str = "aoeiuAOEIU";
        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));
        int left = 0;
        int right = ch.length - 1;
        while(left < right) {
            while(str.indexOf(ch[left]) == -1 && left < right) {
                left ++;
            }
            while(str.indexOf(ch[left]) == -1  && left < right) {
                right --;
            }
            //System.out.println(left);
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left ++;
            right --;
            System.out.println(Arrays.toString(ch));
        }

        return String.copyValueOf(ch);
    }

    public static int  find1(char ch) {
        char[] value = {'a','o','e','i','u','A','O','E','U'};
        for(int i = 0; i < value.length; i++) {
            if(ch == value[i]) {
                return 1;
            }
        }
        return 0;
    }
}
