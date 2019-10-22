import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 21:22
 */
public class MyArrayList {
    private int[] elem;
    private int usedSize;

    public MyArrayList(int[] elem, int usedSize) {
        this.elem = elem;
        this.usedSize = usedSize;
    }


    //1.打印数组
    public void display() {
        System.out.println("[");
        for (int i = 0; i < this.usedSize ; i++) {
            System.out.println(this.elem[i]);
            if(i != this.usedSize -1) {
                System.out.println(",");
            }
        }
        System.out.println("]");
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
        if(pos < 0 || pos > this.usedSize) {
            return;
        }
        if(isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //1、移动元素
        for (int i = this.usedSize - 1; i <= pos; i++) {
            this.elem[i+1] = this.elem[i];
        }
        //2、插入
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 3.判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
       if(pos < 0 || pos > this.usedSize) {
           return -1;
       }
       return this.elem[pos];

    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos > this.usedSize) {
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = this.search(toRemove);//找到元素对应的位置
        if(index < 0 || index > this.usedSize) {
            return;
        }
        if(index == this.usedSize) {
            this.usedSize--;
            return;
        }
        //移动
        for (int i = index; i < this.usedSize; i++) {
            this.elem[i+1] = this.elem[i];
        }
        this.usedSize--;

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
