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
        int[] array = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        //1. 插入排序
        quickSort(array,0,array.length -1);
        System.out.println(Arrays.toString(array));
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
}
