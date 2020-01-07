package liu;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 16:39
 */
public class SerializeDemo {
    private static class Person implements Serializable {
        transient String name;  // 加上 会持久化 这个属性，和Serializable配合使用
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        {
            Person person1 = new Person("陈沛鑫", 34);
            Person person2 = new Person("高博", 18);

            OutputStream os = new FileOutputStream("Person对象.bin");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.close();
        }

        {
            InputStream is = new FileInputStream("Person对象.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            Person p;
            p =(Person)ois.readObject();
            System.out.println(p);
            p =(Person)ois.readObject();
            System.out.println(p);
            ois.close();
        }
    }
}
