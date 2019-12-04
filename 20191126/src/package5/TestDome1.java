package package5;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 9:43
 */
public class TestDome1 {

    //测试 BinarySearchTree
    public static void main(String[] args){
        BinarySearchTree bTree = new  BinarySearchTree();
        int[] array = {10,7,8,2,11,15,9};
        for (int i = 0; i < array.length; i++) {
            bTree.insert(array[i]);
        }
        bTree.prevOrder(bTree.root);
        System.out.println();
        bTree.InOrder(bTree.root);
        System.out.println();
        try {
            BinarySearchTree.Node ret = bTree.search(10);
            System.out.println(ret.val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("ret为空");
        }

        bTree.remove(2);
        bTree.InOrder(bTree.root);
    }
    public static void main3(String[] args){
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> lsit =  topKFrequent(words,1);
        System.out.println(lsit);
//         int[] array = {1,2,3,4,5,6};
//        topK(array,3);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        //1.需要将 字符串 与 它的数量 一一对应 所以要用map
        Map<String,Integer> map = new HashMap<>();
        //遍历字符串数组，将字符串及对应的个数放进 Map中
        for (String str: words) {
            if(map.get(str) == null) {
                map.put(str,1);
            } else {
                map.put(str,map.get(str)+1);
            }
        }

        //建立小根堆，求得 前 k 个最长的字符串
        PriorityQueue<Map.Entry<String,Integer>> minHeap =
                new PriorityQueue<>(k,new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())) {
                    // compareTo() 底层是 o1 - o2
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }

        });

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                Map.Entry<String,Integer> top = minHeap.peek();
                if( top != null && top.getValue().equals(entry.getValue())) {
                    if(top.getKey().compareTo(entry.getKey()) > 0) {
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                } else if(top != null && top.getValue() < (entry.getValue())) {
                    //if(top != null && top.getKey().equals(entry.getKey())) {
                        minHeap.poll();
                        minHeap.add(entry);
                    //}
                }
            }
        }

        for (int i = 0; i < k; i++) {
            String tmp = minHeap.poll().getKey();
            ret.add(tmp);
        }
        return ret;
    }

    // topK 问题 : 求前 K 个最大值
    public static void topK(int[] array,int k) {
        PriorityQueue<Integer> priQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1是放入优先级队列的   o2代表 原数组中没放入的
                //return o1 - o2; //小根堆
                return o2 - o1; //大根堆
            }
        });
        for (int i = 0; i < array.length; i++) {
            if(priQueue.size() < k) {
                priQueue.add(array[i]);
            } else {
                if(priQueue.peek() > array[i]) {
                    priQueue.poll();
                    //数组中的元素 在放入堆时，会 覆盖掉之前的堆顶元素
                    priQueue.add(array[i]);
                }
            }
        }
        System.out.println(priQueue);
    }


    //4. 坏键盘打字
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();//期望输入的字符
        String str2 = scanner.nextLine();//实际输入的字符
        Set<Character> setAct = new HashSet<>();
        for(char ch : str2.toUpperCase().toCharArray()) {
            setAct.add(ch);
        }
        Set<Character> setBroken = new HashSet<>();
        for(char ch : str1.toUpperCase().toCharArray()) {
            if(!setAct.contains(ch) && !setBroken.contains(ch)) {
                setBroken.add(ch);
                System.out.print(ch);
            }
        }
    }

    //3. 宝石与石头
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                count ++;
            }
        }
        return count;
    }
    //2. leetcode
    //1. 只出现一次的数字
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }

        //System.out.println(set);
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }

        }
        return -1;
    }
    public static void main1(String[] args){
        int[] nums = {1,2,1,2,3};
        singleNumber(nums);
    }
}
