package package2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 17:54
 */
public class TestSort2 {
    public static void main(String[] args){
        int[] array1 = {5,9,20,89,8,34};
        int[] array = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        int[] ret = intersection(array1,array);
        //1. 插入排序
        //mergeSort(array);
        System.out.println(Arrays.toString(ret));
    }

    //1. 插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length ; i++) {
            int j = i-1;
            int temp = array[i];
            for (; j >=0; j--) {
                if(array[j] > temp) {
                    array[j+1] = array[j];//注意：不是array[j+1] = temp;
                } else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

    //2.希尔排序
    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int j = i - gap;
            int temp = array[i];
            for (;j >= 0; j-=gap) {//注意：不是j <= 0;
                if(array[j] > temp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = temp;
        }
    }

    //3.选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 堆排序
    public static void heapSort(int[] array) {
        //i = (array.length-1-1)/2 是最后一棵树的给节点
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }

        int end = array.length - 1;
        while(end > 0) {
            int temp = array[end];
            array[end] = array[0];
            array[0] = temp;
            adjustDown(array,0,end);
            end--;
        }
    }

    public static void adjustDown(int[] array,int root,int len) { //len 表示最后一个元素的下表
        int parent = root;
        int child = 2*parent + 1;
        while(child < len) {
            //进入条件   说明有右子树
            if(child + 1 < len) {
                // 得到 左右子树的最大值下表
                child = array[child] > array[child + 1] ? child : child + 1;
            }
            //若父节点小，则交换
            if(array[parent] < array[child]) {
                int temp = array[parent];
                array[parent] = array[child];
                array[child] = temp;
                parent = child;
                child = 2*parent + 1;
            } else {
                break;
            }

        }
    }

    //快速排序
    public static int partition(int[] array,int low,int high) {
        int temp = array[low];
        while(low < high) {
            while(low < high && array[high] > temp) {
                high--;
            }
            array[low] = array[high];
            while(low < high && array[low] < temp) {
                low ++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return  low;
    }
    public static void quickSort(int[] array,int low,int high) {
        int par = partition(array,low,high);
        if(par > low + 1) {
            quickSort(array,low,par-1);
        }
        if(par < high - 1) {
            quickSort(array,par+1,high);
        }
    }

    // 归并排序  时间复杂度O(nlogn) 空间复杂度：O(1)
    // 稳定，如果 if(array[s1] <= array[s2]) 是< 没有 = 就是不稳定
    public static void merge(int[] array,int low,
                             int mid,int high){
        int s1 = low;
        int s2 = mid+1;
        int len = high-low+1;

        int[] tmp = new int[len];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmp[i] = array[s1];
                i++;
                s1++;
            } else {
                tmp[i] = array[s2];
                i++;
                s2++;
            }
        }

        //判断两个归并段 中 是否还有归并段有数据
        while(s1 <= mid) {
            tmp[i] = array[s1];
            s1++;
            i++;
        }
        while(s2 <= high) {
            tmp[i] = array[s2];
            s2++;
            i++;
        }
        for (int j = 0; j < len; j++) {
            array[low + j] = tmp[j];
        }
    }

    public static void mergeSort1(int[] array,int low,int high) {
        if(low == high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSort1(array,low,mid);
        mergeSort1(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    //归并排序 非递归
    public static void merge1(int[] array,int gap) {
        int[] tmp = new int[array.length];
        int i = 0;

        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 >=
                array.length ? array.length-1 : s2+gap-1;

        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                //判断
                if(array[s1] <= array[s2]) {
                    tmp[i] = array[s1];
                    i++;
                    s1++;
                } else {
                    tmp[i] = array[s2];
                    i++;
                    s2++;
                }

            }
            while(s1 <= e1) {
                tmp[i] = array[s1];
                s1++;
                i++;
            }
            while(s2 <= e2) {
                tmp[i] = array[s2];
                s2++;
                i++;
            }
            //重新s1,e1,s2,e2 位置
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 >=
                    array.length ? array.length-1 : s2+gap-1;
        }
        //判断s1是否有数据
        while(s1 < array.length) {
            tmp[i] = array[s1];
            s1++;
            i++;
        }

        //拷贝tmp到array
        for (int j = 0; j < tmp.length; j++) {
            array[j] = tmp[j];
        }

    }
    public static void mergeSort(int[] array) {
        for (int gap = 1; gap < array.length; gap*=2) {
            merge1(array,gap);
        }

    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        int len =  nums1.length < nums2.length ?  nums1.length : nums2.length;
        int[] ret = new int[len];
        int k = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    ret[k] = nums2[j];
                    k++;
                    break;
                }
            }
        }
        return ret;
    }

}
