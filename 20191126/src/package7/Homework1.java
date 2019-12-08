package package7;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 17:05
 */
public class Homework1 {
    public static void main1(String[] args){
        String s = "leetcode";
        int ret = firstUniqChar(s);
        System.out.println(ret);
    }

    //1. 387. 字符串中的第一个唯一字符
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

    //2. 字符串中的第一个唯一字符
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


    //3. 349. 两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1) {
            set1.add(n);
        }
        int index = 0;
        for(int i = 0; i < nums2.length; i ++) {
            if(set1.contains(nums2[i])) {
                nums2[index++] = nums2[i];
                //需要删除，否则 下次碰到相同的数值时会在数组的下一个位置再放一次
                set1.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(nums2, 0, index);
    }

    //4. 350. 两个数组的交集 II
    //方法1：
    public int[] intersect1(int[] nums1, int[] nums2) {
        //1.先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        //2.同时遍历两个数组，谁小 谁向前先走一步，直到两值相等时，将其值添加进list
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        //3.将list中的值转为数组存放
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    //方法2：
    public int[] intersect2(int[] nums1, int[] nums2) {
        //1.将num1放进list1
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        //2.遍历num2，若list1中存在，就将其放入一个新的list2中，并将list1中的删除
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                // 从 list1 除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        //3.将list2转化为数组
        int[] res = new int[list2.size()];
        int i = 0;
        for (int num : list2) {
            res[i++] = num;
        }
        return res;
    }
    //方法3：
    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        //1. 将 nums1 出现的数值及频次放入映射的Map中
        for (int num1 : nums1) {
            map.put(num1,map.getOrDefault(num1,0)+1);
        }
        //2. 遍历num2,找到在map中存在的值，就将其放入list中，
        // 并将其在map中的映射的value(次数) -1;
        List<Integer> list = new ArrayList<>();
        for (int num2 : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map.get(num2);
            if (count != null && count != 0) {
                list.add(num2);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map.put(num2, --count);
            }
        }
        //3. 将list中的值放入数组中
        int[] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i ++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    //5. 205. 同构字符串
    public boolean isIsomorphic(String s, String t) {
        //遍历一个字符串
        for (int i = 0; i < s.toCharArray().length; i++) {

            //charAt​(int index) 返回指定索引处的 char值
            //indexOf​(int ch) 返回指定字符第一次出现的字符串内的索引。
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        String[] str = {"a","aa","aaa","aaaa"};
        //System.out.println(numSmallerByFrequency(str));
    }
    //819. 最常见的单词
    //
//    public String mostCommonWord(String paragraph, String[] banned) {
//        Map<String,Integer> map = new HashMap<>();
//        // 全部转为小写字母
//        paragraph = paragraph.toLowerCase();
//
//    }

    //1170. 比较字符串最小字母出现频次
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> list = new ArrayList<>();
        //遍历words,将字符串数组中的字符串中的最小字母对应的频数，
        // 和 频数出现的次数 映射放入map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i ++) {
            int temp = fs(words[i]);
            map.put(temp,map.getOrDefault(temp,0)) ;
        }
        //遍历queries(查询) 字符串数组 判断 每个字符串中最小字符的出现的频数，
        // 小于 map中value值的和
//        for(int i = 0; i < queries.length; i ++) {
//            int temp = fs(queries[i]);
//            for (int j = map.; j < map.values().size(); j++) {
//                if(temp < map.get()) {
//
//                }
//            }
//
//                list.add(i+1);
//
//        }

        // 统计
        int [] counter = new int[12];
        for (int i = 0; i < words.length; i++)
            counter[fs(words[i])]++;

        // 累和
        for (int i = 9; i >= 0; i--)
            counter[i] += counter[i + 1];

        // 拿值
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ret[i] = counter[fs(queries[i]) + 1];

        return ret;
    }
    //求得 字符串中最小的字母
    private static int fs(String str) {
        Map<String,Integer> map1 = new HashMap<>(); // 存放 queries 中 字符串对应的频率
        int minChar = str.charAt(0);
        int count = 0;
        for(int i = 1; i < str.length(); i++) {
            if(minChar > str.charAt(i)) {
                minChar = str.charAt(i);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if(minChar == str.charAt(i)) {
                count ++;
            }
        }
        return count;
    }
}
