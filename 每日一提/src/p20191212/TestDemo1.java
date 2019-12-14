package p20191212;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:  每日一题2 12-11 题
 * User: STAR
 * Date: 2019 -12
 * Time: 15:19
 */
public class TestDemo1 {
    //1. 喝汽水问题： 3个换一瓶， 2 两瓶盖时 可向店铺借一瓶汽水
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int sum = 0;//总能换喝多少瓶
            int n = sc.nextInt();// 最开始有多少瓶盖
            if(n == 0) {
                continue;
            }
            while(n > 1) {
                sum += n/3;
                n = n%3 + n/3;
                if(n == 2) {
                    sum += 1;
                    break;
                }
            }
            System.out.println(sum);
        }
    }

    // 答案
    public static int drink(int n) {
        int total = 0;//饮料总数
        //当大于两个空瓶的时候才可以换饮料
        while(n > 2) {
            //n/3-->能够换来的饮料
            total = total+n/3;
            //新的空瓶子个数--》n%3可能会不能整除
            n = n/3 + n%3;
        }
        //如果n==2，说明有两个空瓶可以喝商家借一瓶饮料
        if(n == 2) {
            total = total + 1;
        }
        return total;
    }
    public static void main(String[] args){
        //创建键盘录入对象
        Scanner sc=new Scanner(System.in);
        int n;
        while(sc.hasNext()) {
            n=sc.nextInt();
            System.out.println(drink(n));
        }
    }


    // 2. 数组的逆序对个数 一组数据 , 前一个 只要大于后一个值，就组成一个逆序对，
    // 使用归并排序
    public int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        return mergeSortRecursion(A, 0, n - 1);
    }
    public static int mergeSortRecursion(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        //逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+
        // 左右结合成新的顺序数组时中出现的逆序对的数量；
        return mergeSortRecursion(arr, l, mid) + mergeSortRecursion(arr, mid + 1, r) +
                merge(arr, l, mid, r);
    }
    public static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverseNum = 0;// 新增，用来累加数组逆序对
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                // 当前一个数组元素大于后一个数组元素时，累加逆序对
                // s[i] > s[j] 推导出 s[i]...s[mid] > s[j]
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left++] = temp[k];
        }
        return inverseNum;
    }
}

