package package2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 11:20
 */
class MinStack {

    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //1、stack栈内一定会入栈
        //2、第一次minStack一定会放元素，其余的每次
        //往stack栈-》和minStack栈顶比较
        // x <= minStack.peek()--->minStack.push(x);
        stack.push(x);
        if(stack.empty()) {
            minStack.push(x);
        } else {
            if(x < minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if(stack.empty()) {
            return;
        }
        int num = stack.pop();
        if(num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if(stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.empty()) {
            return -1;
        }
        return minStack.peek();

    }
}

public class Test3 {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.push(6);
        minStack.push(1);
        System.out.println(minStack.stack);
        System.out.println(minStack.minStack);
    }
}
