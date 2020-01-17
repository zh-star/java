package p2019_12.p20191218;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 每日一题 12-18
 * User: STAR
 * Date: 2019 -12
 * Time: 22:26
 */
public class TestDemo2 {

    // 1. 牛客网 n 个数里面 最小的 k 的
    //每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
    //不超过100。
    public static void main1(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        int k = list.remove(list.size()-1);
        PriorityQueue<Integer> priQueue = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            priQueue.add(list.get(i));
        }
        for (int i = 0; i < k; i++) {
            System.out.print(priQueue.poll() + " ");
        }
    }

    // 2. 删数
    //
    //有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
    // 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(i);
            }
            int j = 0; // 要删除元素的下表
            while (list.size() > 1) {
                j = (j + 2) % list.size(); // 2
                list.remove(j);
            }
            System.out.println(list.get(0));
        }
    }

}
