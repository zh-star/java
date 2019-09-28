import java.util.concurrent.Callable;

public class Test {
    public static void main(String[] args){

        //- 1.编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘除四种运算.
        System.out.println("加减乘除计算");
        Calculator ret = new Calculator();
        System.out.println(ret.Add(2,3));
        System.out.println(ret.Sub(2,3));
        System.out.println(ret.Mul(2,3));
        System.out.println(ret.Div(2,3));
       //- 2.设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
        System.out.println("实例化类");
        Person xiaoli = new Person("小丽");
        xiaoli.Show();

        Person xiaohua =  new Person("小花","女",23);
        xiaohua.Show();


        //- 3.实现交换两个变量的值。要求：需要交换实参的值。
        System.out.println("实现交换");
        Swap swap = new Swap();
        swap.Swap(2,5);
    }
}
