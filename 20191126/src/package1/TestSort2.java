package package1;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 18:16
 */
public class TestSort2 {
    public static void main(String[] args){
        int[] array = {5,6,8,2,7,10};
        int[] array1 = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        Random random = new Random();
        int[] array3 = new int[10000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = random.nextInt(10000);
        }

        long time1 = System.currentTimeMillis();
        //insertSort(array1);
        
        //shellSort(array1);

        //selectSort(array1);

        //heapSort(array3);

        //bubbleSort(array3);
        mergeSort(array1,0,array1.length-1);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        System.out.println(Arrays.toString(array1));
    }
    //1.直接插入排序
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if(array[j] > temp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }
    //2.希尔排序
    public static void shellSort(int[] array) {
        int[] drr = {5,2,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j = i - gap;
            for (; j >= 0; j-= gap) {
                if(array[j] > temp) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }
    //3.选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    //4.堆排序
    public static void heapSort(int[] array) {
        //先将数组调整为一个大根堆  而且是 将数组中所有的值都调整为一个大根堆

        //(array.length-1-1)/2 是此数组 所对应的大根堆的最后一棵子树的根节点
        //array.length-1 是 大根堆的最后一个节点
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length-1);
        }

        int end = array.length-1;
        while(end > 0) {
            //堆顶肯定是最大的元素
            int temp = array[end];
            array[end] = array[0]; // 每次都是与array[0]交换，因为他永远是堆顶元素
            array[0] = temp;
            adjustDown(array,0,end-1);
            end--;
        }

    }
    public static void adjustDown(int[] array,int root,int len) {
        int parent = root;
        int child = 2*parent+1; //得到的是左孩子
        while(child <= len) {
            if((child + 1) <= len) { //说明有右子树
                child = (array[child] > array[child+1]) ? child : child+1;
            }
            int temp = array[child];
            array[child] = array[parent];
            array[parent] = temp;
            parent = child;
            child = 2*parent+1;
        }
    }
    //5.冒泡排序
    public static void bubbleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length-1; i++) {
            flag = false;
            for (int j = 0; j < array.length -1-i; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }

        }
    }
    //6.快速排序
    public static void quickSort(int[] array) {
        int par = partition(array,0,array.length-1);
        int low = 0;
        int high = array.length-1;
        if(par > low + 1) {
            partition(array,low,par);
        }
        if(par < high - 1) {
            partition(array,par+1,high);
        }
    }
    private static int partition(int[] array,int low,int high) {
        int temp = array[low];
        while(low < high) {
            while(low < high && array[high] > temp) {
                high--;
            }
            array[low] = array[high];
            while(low < high && array[low] < temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    //7.归并排序
    public static void mergeSort(int[] array,int low,int high){
        if(low == high) {
            return;
        }
        int mid = (low + high)/2;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        merge(array,low,mid,high);
    }
    private static void merge(int[] array,int low,int mid,int high) {
        int s1 = low;
        int s2 = mid+1;
        int len = high-low +1;
        int[] tmp = new int[len];
        int i = 0;
        while(s1 <= mid && s2 <= high) {
            if(array[s1] < array[s2]) {
                tmp[i++] = array[s1++];
            } else {
                tmp[i++] = array[s2++];
            }
        }
        while(s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while(s2 <= mid) {
            tmp[i++] = array[s2++];
        }

        for (int j = 0; j < tmp.length; j++) {
            array[low+j] = tmp[j];
        }
    }
}
