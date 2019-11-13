/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:24
 */
public class MyStack {
    public int[] elem;
    public int top;//可以存放数据元素的下表

    public MyStack() {
        this.elem = new int[10];
    }

    //入栈
    public void push(int data) {
        if(isFull()) {
            throw  new UnsupportedOperationException("栈满了");
            //return;
        }
        this.elem[this.top++] = data;
       // System.out.println(this.top);
    }
    public boolean isFull() {
        if(this.top == this.elem.length) {
            return true;
        }
        return false;
    }
    //出栈
    public int pop(){
        if(isEmpty()) {
            return -1;
        }
        int num = this.elem[this.top - 1];
        this.top --;
        return num;
    }
    public boolean isEmpty() {
        if(this.top == 0) {
            return true;
        }
        return false;
    }
    //栈顶元素
    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return this.elem[this.top - 1];
    }
    //站的大小
    public int size() {
        return this.top;
    }
}



