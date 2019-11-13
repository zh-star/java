import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:01
 */
class Student  implements Comparable<Student>{
    private String name;
    private String classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        //this.score 当前分数；  o.score 参数分数
        //System.out.println(this.score);
        //System.out.println(o.score);
        //return (int)(this.score - o.score);

        //字符串排大小
        return this.name.compareTo(o.name);

    }
}
public class TestDemo2 {
    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("ZHXX","16040",999.0));
        list.add(new Student("WSY","160404",98.0));
        list.add(new Student("WJ","160405",997.0));
        list.add(new Student("WJA","160406",96.0));
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
