 public class Person {
    //类的属性？字段/成员变量
    private String name;
    private String sex;
    private   int age;
    public static int num = 0;

    //构造方法
     public Person(String name) {
         this.name = name;
     }
     public  void steAge(int age) {
         this.age = age;
         System.out.println(this.age);
     }

     //类的方法
    public void eat() {
        System.out.println( name +"正在吃饭！");
    }

    public void sleep() {
        System.out.println(name +"正在睡觉！");
    }


}
