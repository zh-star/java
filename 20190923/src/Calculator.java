public class Calculator {
    private int num1;
    private int num2;

    //加法
    public int Add(int num1,int num2){
        return num1 + num2;
    }

    //减法
    public int Sub(int num1,int num2) {
        return num1 - num2;
    }

    //乘法
    public int Mul(int num1,int num2) {
        return num1 * num2;
    }

    //除法
    public double Div(int num1,int num2) {
        return (double)num1/num2;
    }
}
