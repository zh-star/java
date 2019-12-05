package package7;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 17:05
 */
public class Homework1 {
    public static void main(String[] args){
        String s = "leetcode";
        int ret = firstUniqChar(s);
        System.out.println(ret);
    }

    //387. 字符串中的第一个唯一字符
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars ) {
            //集合课件第一节
            //V getOrDefault(Object k, V defaultValue)
            // //根据指定的 k 查找对应的 v，没有找到用默认值代替
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        //遍历 字符串，找到 map中key值  -》最小的value 也就是 1
        //并返回当前该字符对应在字符串中的下表
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    public int firstUniqChar_3(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_4(String s) {
        boolean[] notUniq = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!notUniq[ch -'a']) {
                if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                    return i;
                } else {
                    notUniq[ch - 'a'] = true;
                }
            }
        }
        return -1;
    }

    public int firstUniqChar5(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

}
