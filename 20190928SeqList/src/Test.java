public class Test {
    public static void main(String[] args){
        SepList sepList = new SepList();
        for (int i = 0; i < 10; i++) {
            sepList.add(i,i);
        }
        sepList.add(10,50);
        sepList.display();
        System.out.println(sepList.size());
        sepList.remove(2);
        System.out.println(sepList.contains(5));

        System.out.println(sepList.search(5));
    }
}
