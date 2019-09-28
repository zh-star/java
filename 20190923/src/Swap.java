class Num {
    int num;

    public Num(int num) {
        this.num = num;
    }
}

public class Swap {
    public void Swap(int n,int m){
        Num a = new Num(n);
        Num b = new Num(m);
        Num temp = a;
        a = b;
        b = temp;
        System.out.println(a.num);
        System.out.println(b.num);
    }
}
