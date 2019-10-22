import java.util.Arrays;

public class SepList {
    //顺序表的最大元素个数
    private int[] elem;
    //size表示当前数组中的有效元素
    private int usedSize = 0;
    private final int CAPACITY = 10;


    public SepList() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }

    //方法
    //1.打印顺序表
    public void display(){
        System.out.print("[");
        for(int i = 0; i < this.usedSize; i++) {
            System.out.print(elem[i]);
            if(i != usedSize -1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        //System.out.println(Arrays.toString(this.elem));
    }
    
    //判断是否满了
    private boolean isFull() {
       /* if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;*/
        return this.usedSize == this.elem.length;
    }

    // 2.在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos < 0 || pos > this.usedSize) {//不能跳着插
            return;
        }

        if(isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //1、移动元素

        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }

        //2、插入
        this.elem[pos] = data;
        this.usedSize ++;

    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <= this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 3.查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i <= this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos > 0 || pos <= this.usedSize) {
            return this.elem[pos];
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
    //public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = this.search(toRemove);
        if( index == -1) {
            return;
        }

        if(index == this.usedSize -1) {
            this.usedSize --;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            //删除
            this.elem[i] = this.elem[i+1];
            this.usedSize --;

        }

    }
    // 获取顺序表有效长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
