package package1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 19:34
 */
public class TestHeap {
    int[] elem;
    int usedSize;

    public TestHeap() {
        this.elem = new int[20];
        this.usedSize = 0;
    }
    public void adjustDown(int root,int len) {
        int parent = root;
        int child = 2*parent + 1;
        while(child < len) {
            //当然如果这里是 <= len 的符号，就必须传下表，不能再传的是长度
            if((child + 1) < len) {
                child = (this.elem[child] > this.elem[child+1]) ? child : child+1;
            }
            if(this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = 2*parent + 1;
            } else {
                break;
            }
        }
    }

    public void createHeap(int[] array) {
        for(int i = 0; i < array.length; i ++) {
            this.elem[i] = array[i];
            this.usedSize ++;
        }
        for(int i = (this.usedSize-1 - 1)/2; i>= 0; i--) {
            //这里给this.usedSize-1 或者 this.usedSize都是可以的
            //因为 在向下调整方法中，主要是与len比较，判断是否有右孩子，最后一个下表+1，
            // 的结果就是9 无论传9还是10都不会进入此条件了
            adjustDown(i,this.usedSize - 1);
        }
    }

    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if(this.elem[child] < this.elem[parent]) {
                return;
            }
            int temp = this.elem[parent];
            this.elem[parent] = this.elem[child];
            this.elem[child] = temp;
            child = parent;
            parent = (child -1) / 2;
        }
    }


    public void pushHeap(int val) {
        this.elem[this.usedSize] = val;
        this.usedSize++;//11

        adjustUp(usedSize-1);

    }

    public void popHeap() {
        if(isEmpty()) {
            return;
        }
        int temp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = temp;
        this.usedSize--;
        adjustDown(0,this.usedSize-1);
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int getPop() {
        if(isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }


    //从小到大 堆排序
    public void heapSort() {
        int end = this.usedSize-1;
        while(end > 0) {
            //交换
            int temp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = temp;
            //这里可以先end-- 之后传end,也可直接传end,
            //因为在adjustDown() 方法中不影响，
            adjustDown(0,end);
            end--;
        }
    }
}
