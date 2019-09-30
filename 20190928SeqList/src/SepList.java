public class SepList {
    //顺序表的最大元素个数
    private int[] date = new int[10];
    //size表示当前数组中的有效元素
    private int size = 0;

    //1.打印顺序表
    public void display(){
        System.out.print("[");
        for(int i = 0; i < size; size++) {
            System.out.print(date[i]);
            if(i != size -1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    //2.再pos的位置上增加新元素
    public void add(int pos,int date) {

    }

}
