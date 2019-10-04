import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3,4},
            {5,6,7,8}
        };

        
        //二维数组的长度是数组的列数row
        //System.out.println(arr.length);//结果是2


        //二维数组每一次元素相当于一维数组，
        //所以可用Arrays。toString()函数转化为字符串打印
        for(int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
        //双层循环访问到数组的每一个元素
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
