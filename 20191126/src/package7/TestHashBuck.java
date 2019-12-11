package package7;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 14:57
 */
public class TestHashBuck {
    public static void main(String[] args){
        HashBuck<Integer,String> hashBuck = new HashBuck<>();
        hashBuck.push(16040223,"zhangxing");
        hashBuck.push(16040224,"wangsiying");
        hashBuck.push(16040225,"wujing");

        String ret = hashBuck.get(16040223);
        System.out.println(ret);

    }
}
